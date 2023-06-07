package factories;

import models.Query;

/**
*
* @author Luan Nadaletti
*
*/
public interface QueryFactory {

    Query createQuery(String statement);

}
