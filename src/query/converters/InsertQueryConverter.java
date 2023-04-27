package query.converters;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import query.models.Query;

public class InsertQueryConverter implements QueryConverter {

    @Override
    public Query convert(Query query) {
        Objects.requireNonNull(query, "A instrução de inserção não pode ser nula");

        String tabela = query.getTabela();
        List<String> campos = query.getCampos();
        List<String> valores = query.getValores();

        String clausulaWhere = IntStream.range(0, campos.size())
                .mapToObj(i -> campos.get(i) + " = ?")
                .collect(Collectors.joining(" AND ", "WHERE ", ""));

        return null;
    }

}
