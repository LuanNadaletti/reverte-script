package main.enums;

import main.factories.InsertQueryFactory;
import main.factories.QueryFactory;

/**
 *
 * @author Luan Nadaletti
 *
 */
public enum QueryType {
    INSERT {
        @Override
        public QueryFactory getQueryFactory() {
            return new InsertQueryFactory();
        }

    };

    public abstract QueryFactory getQueryFactory();

    public static QueryType fromStatement(String statement) {
        if (statement.toLowerCase().startsWith("insert")) {
            return INSERT;
        }

        throw new IllegalArgumentException("Invalid statement");
    }

}
