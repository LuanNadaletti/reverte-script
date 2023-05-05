package main.factories;

import main.models.Query;

public interface QueryFactory {

    Query createQuery(String statement);

}
