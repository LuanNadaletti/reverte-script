package main.factories;

import main.models.Query;

/**
*
* @author Luan Nadaletti
*
*/
public interface QueryFactory {

    Query createQuery(String statement);

}
