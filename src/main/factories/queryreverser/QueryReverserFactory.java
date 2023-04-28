package main.factories.queryreverser;

import main.models.Query;
import main.reversers.CreateTableReverser;
import main.reversers.InsertQueryReverser;
import main.reversers.QueryReverser;

/**
 *
 * @author Luan Nadaletti
 *
 */
public class QueryReverserFactory {

    public static QueryReverser getConverter(Query query) {
        if (isInsertQuery(query)) {
            return new InsertQueryReverser();
        } else if (isCreateTableQuery(query)) {
        	return new CreateTableReverser();
        }

        return null;
    }

    private static boolean isInsertQuery(Query query) {
        return query.toString().contains("INSERT INTO") && query.toString().contains("VALUES");
    }
    
    private static boolean isCreateTableQuery(Query query) {
    	return query.toString().contains("CREATE TABLE");
    }

}
