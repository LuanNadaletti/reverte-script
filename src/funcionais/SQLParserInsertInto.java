package funcionais;

import java.util.Arrays;
import java.util.List;

public class SQLParserInsertInto extends SQLParser {

    @Override
    public List<String> getCampos(String statement) {
        String colunas = statement.substring(statement.indexOf('('), statement.indexOf(')'));
        String valores = statement.substring(statement.lastIndexOf('('), statement.lastIndexOf(')'));

        return null;
    }

    @Override
    public String getTabela(String statement) {
        String[] palavras = statement.split(" ");
        String flag = "INTO";
        int index = Arrays.asList(palavras).indexOf(flag);

        return palavras[index + 1];
    }

    @Override
    public String getRevertedScript(String tabela, List<String> campos) {
        // TODO Auto-generated method stub
        return null;
    }

}
