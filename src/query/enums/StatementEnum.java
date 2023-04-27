package query.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum StatementEnum {
    InsertInto {
        @Override
        public String converter(String s) throws Exception {
            List<String> campos = new ArrayList<>();
            String camposParaDarSplit = s.substring(s.indexOf('(') + 1, s.indexOf(')'));
            campos.addAll(Arrays.asList(camposParaDarSplit.split(",")));

            List<String> valores = new ArrayList<>();
            String camposParaDarSplit2 = s.substring(s.lastIndexOf('(') + 1, s.lastIndexOf(')'));
            valores.addAll(Arrays.asList(camposParaDarSplit2.split(",")));

            List<String> palavras = Arrays.asList(s.split(" "));
            String tabela = palavras.get(palavras.indexOf("INTO") + 1);

            String revertido = "DELETE FROM " + tabela + " WHERE ";

            for (int i = 0; i < campos.size(); i++) {
                revertido += campos.get(i) + " = " + valores.get(i);

                if (i != campos.size() - 1) {
                    revertido += " AND ";
                }
            }

            return revertido;
        }
    };

    public abstract String converter(String s) throws Exception;

}
