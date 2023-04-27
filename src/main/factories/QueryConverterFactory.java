package main.factories;

import main.converters.InsertQueryConverter;
import main.converters.QueryConverter;
import main.models.Query;

/**
 *
 * @author Luan Nadaletti
 *
 */
public class QueryConverterFactory {

    public static QueryConverter getConverter(Query query) {
        if (isInsertQuery(query)) {
            return new InsertQueryConverter();
        }

        return null;
    }

    public static boolean isInsertQuery(Query query) {
        return query.toString().contains("INSERT INTO") && query.toString().contains("VALUES");
    }

}
