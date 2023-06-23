package models;

import java.util.Map;

/**
 * Represents an ALTER TABLE query, which modifies the structure of a database
 * table. This class extends the {@link Query} class and provides additional
 * properties and functionality specific to ALTER TABLE queries.
 *
 * An ALTER TABLE query consists of an operator (e.g., ADD, DROP), a column
 * name, and optionally a data type for the column.
 *
 * The class provides methods to retrieve the reverse operation for the given
 * operator and to access the query's properties.
 *
 * The reverse operation is determined based on the operator using a predefined
 * mapping in the {@link #operatorToReverseOperation} map.
 *
 * Instances of this class are immutable once created.
 *
 * @author Luan Nadaletti
 */
public class AlterTableQuery extends Query {

	private String operator;
	private String column;
	private String dataType;

	private static final Map<String, String> operatorToReverseOperation = Map.ofEntries(Map.entry("ADD", "DROP"),
			Map.entry("DROP", "ADD"));

	/**
	 * Constructs an AlterTableQuery object with the provided statement, table name,
	 * operator, column name, and data type.
	 *
	 * @param statement The original statement of the ALTER TABLE query.
	 * @param table     The name of the table being altered.
	 * @param operator  The operator of the ALTER TABLE query (e.g., ADD, DROP).
	 * @param column    The name of the column being modified.
	 * @param dataType  The data type of the column (optional).
	 */
	public AlterTableQuery(String statement, String table, String operator, String column, String dataType) {
		super(statement, table);
		this.operator = operator;
		this.column = column;
		this.dataType = dataType;
	}

	/**
	 * Retrieves the reverse operation for the given operator. The reverse operation
	 * is determined based on the operator using a predefined mapping.
	 *
	 * @return The reverse operation for the operator.
	 */
	public String getReverseOperation() {
		return operatorToReverseOperation.get(operator.toUpperCase());
	}

	public String getOperator() {
		return operator;
	}

	public String getColumn() {
		return column;
	}

	public String getDataType() {
		return dataType;
	}

	@Override
	public String toString() {
		return statement;
	}

}
