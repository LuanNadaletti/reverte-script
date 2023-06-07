package enums;

import factories.AlterTableQueryFactory;
import factories.CreateQueryFactory;
import factories.InsertQueryFactory;
import factories.QueryFactory;

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
    },

    CREATE {
        @Override
        public QueryFactory getQueryFactory() {
            return new CreateQueryFactory();
        }
    },

    ALTER_TABLE {
        @Override
        public QueryFactory getQueryFactory() {
            return new AlterTableQueryFactory();
        }
    };

    public abstract QueryFactory getQueryFactory();

    public static QueryType fromStatement(String statement) {
        if (statement.trim().toLowerCase().startsWith("insert")) {
            return INSERT;
        }
        if (statement.trim().toLowerCase().startsWith("create")) {
            return CREATE;
        }
        if (statement.trim().toLowerCase().startsWith("alter")) {
            return ALTER_TABLE;
        }

        return null;
    }

}
