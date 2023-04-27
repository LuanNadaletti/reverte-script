package query.factories;

import query.converters.InsertQueryConverter;
import query.converters.QueryConverter;
import query.models.Query;

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
