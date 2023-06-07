package models;

import java.util.HashMap;

import java.util.Map;

/**
*
* @author Luan Nadaletti
*
*/
public class AlterTableQuery extends Query {

    private String operator;
    private String column;
    private String dataType;

    private static final Map<String, String> operatorToReverseOperation = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
	{
        put("ADD", "DROP");
        put("DROP", "ADD");
    }};

    public AlterTableQuery(String statement, String table, String operator, String column, String dataType) {
        super(statement, table);
        this.operator = operator;
        this.column = column;
        this.dataType = dataType;
    }

    public String getReverseOperation() {
        return operatorToReverseOperation.get(operator.toUpperCase());
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Override
    public String toString() {
        return statement;
    }

}
