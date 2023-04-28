package main.enums;

import main.factories.query.CreateTableQueryFactory;
import main.factories.query.InsertQueryFactory;
import main.factories.query.QueryFactory;

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
    
    CREATE_TABLE {
		@Override
		public QueryFactory getQueryFactory() {
			return new CreateTableQueryFactory();
		}
    };

    public abstract QueryFactory getQueryFactory();

    public static QueryType fromStatement(String statement) {
        if (statement.toLowerCase().startsWith("insert")) {
            return INSERT;
        }
        
        if (statement.toLowerCase().startsWith("create")) {
        	return CREATE_TABLE;
        }

        throw new IllegalArgumentException("Invalid statement");
    }

}
