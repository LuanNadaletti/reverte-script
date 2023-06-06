package main.reversers;

import main.models.CreateTableQuery;
import main.models.Query;

public class CreateTableQueryReverser extends QueryReverser {

    @Override
    public String reverse(Query query) {
        CreateTableQuery createTableQuery = (CreateTableQuery) query;

        return String.format("DROP TABLE %s;", createTableQuery.getTable());
    }

}
