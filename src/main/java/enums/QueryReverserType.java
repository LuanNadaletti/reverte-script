package main.enums;

import main.models.Query;
import main.reversers.CreateTableQueryReverser;
import main.reversers.InsertQueryReverser;
import main.reversers.QueryReverser;

public enum QueryReverserType {
    INSERT {
        @Override
        public QueryReverser getQueryReverser() {
            return new InsertQueryReverser();
        }
    },

    CREATE_TABLE_REVERSER {
        @Override
        public QueryReverser getQueryReverser() {
            return new CreateTableQueryReverser();
        }
    };

    public abstract QueryReverser getQueryReverser();

    public static QueryReverserType fromQuery(Query query) {
        if (query.toString().contains("INSERT INTO") && query.toString().contains("VALUES")) {
            return INSERT;
        }
        if (query.toString().contains("CREATE TABLE")) {
            return CREATE_TABLE_REVERSER;
        }

        return null;
    }
}
