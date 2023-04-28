package main.factories.query;

import main.models.Query;

public interface QueryFactory {

    Query createQuery(String statement);

}
