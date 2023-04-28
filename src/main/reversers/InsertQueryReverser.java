package main.reversers;

import main.models.InsertQuery;
import main.models.Query;

/**
 *
 * @author Luan Nadaletti
 *
 */
public class InsertQueryReverser implements QueryReverser {

    @Override
    public String reverse(Query query) {
        InsertQuery insertQuery = (InsertQuery) query;

        String where = "";

        for (int i = 0; i < insertQuery.getValues().size(); i++) {
            where +=  insertQuery.getFields().get(i) + " = " + insertQuery.getValues().get(i);
        }
        where += ";";

        return String.format("DELETE FROM %s WHERE %s", insertQuery.getTable(), where);
    }

}
