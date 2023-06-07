package reversers;

import models.AlterTableQuery;
import models.Query;

/**
*
* @author Luan Nadaletti
*
*/
public class AlterTableQueryReverser extends QueryReverser {

    @Override
    public String reverse(Query query) {
        AlterTableQuery alterTableQuery = (AlterTableQuery) query;

        return String.format("ALTER TABLE %s %s %s;", alterTableQuery.getTable(), alterTableQuery.getReverseOperation(), alterTableQuery.getColumn());
    }

}
