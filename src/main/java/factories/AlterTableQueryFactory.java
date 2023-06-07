package main.factories;

import main.models.Query;

public class AlterTableQueryFactory implements QueryFactory {

    @Override
    public Query createQuery(String statement) {
        String regex = "^\\s*ALTER\\s*TABLE\\s*(\\w*)\\s*(\\w*)\\s*(\\w*)\\s*(\\w*)";

        return null;
    }

}
