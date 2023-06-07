package reversers;

import models.CreateQuery;
import models.Query;

/**
*
* @author Luan Nadaletti
*
*/
public class CreateQueryReverser extends QueryReverser {

    @Override
    public String reverse(Query query) {
        CreateQuery createQuery = (CreateQuery) query;

        return String.format("DROP %s %s;", createQuery.getCreateQueryType().getKeyWord(), createQuery.getTable());
    }

}
