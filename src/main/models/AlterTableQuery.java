package main.models;

import java.util.HashMap;
import java.util.Map;

public class AlterTableQuery extends Query {

    private static final Map<String, String> operatorToReverseOperation = new HashMap<String, String>() {{
        put("ADD", "DROP");
        put("DROP", "ADD");
    }};

    public AlterTableQuery(String statement, String table) {
        super(statement, table);
    }

    public Map<String, String> getOperatorToReverseOperation() {
        return operatorToReverseOperation;
    }

}
