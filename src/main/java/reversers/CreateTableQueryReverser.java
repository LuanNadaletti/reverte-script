package reversers;

import models.CreateTableQuery;

import models.Query;

/**
*
* @author Luan Nadaletti
*
*/
public class CreateTableQueryReverser extends QueryReverser {

    @Override
    public String reverse(Query query) {
        CreateTableQuery createTableQuery = (CreateTableQuery) query;

        return String.format("DROP TABLE %s;", createTableQuery.getTable());
    }

}
