package query.factories;

import query.models.Query;

public interface QueryFactory {

    Query createQuery(String statement);

}
