package main.parsers;

import java.util.LinkedList;
import java.util.List;
import main.enums.QueryType;
import main.factories.QueryFactory;
import main.models.Query;

/**
 * The QueryParser class is responsible for parsing a given SQL script and
 * returning a list of all SQL statements found in the script.
 *
 * <p>
 * This class uses a set of methods to perform the analysis and extraction of
 * SQL statements. The SQL script is provided through the constructor, and the
 * {@link #parse()} method is used to initiate the parsing.
 * </p>
 *
 * *
 * <p>
 * Usage example:
 *
 * <pre>{@code
 * String script = "INSERT INTO table (column) VALUES ('value');";
 * QueryParser parser = new QueryParser(script);
 * List<Query> queries = parser.parse();
 * }</pre>
 * </p>
 *
 * @author Luan Nadaletti
 * @see Query
 */
public class QueryParser {

	private String script;
	private LinkedList<Query> queries = new LinkedList<>();

	private int currentIndex = 0;
	private boolean insideString = false;

	public QueryParser(String script) {
		this.script = script;
	}

	/**
	 * Parses the provided SQL script and returns a list of all SQL statements
	 * found.
	 *
	 * @return A list of all SQL statements found in the script.
	 */
	public List<Query> parse() {
		StringBuilder currentStatement = new StringBuilder();

		while (currentIndex < script.length()) {
			char character = getNextCharacter();

			if (character == '\'') {
				handleStringDelimiter();
			}

			if (!insideString && character == ';') {
				currentStatement.append(character);
				addQuery(currentStatement.toString());
				currentStatement = new StringBuilder();
			} else {
				currentStatement.append(character);
			}
		}

		if (currentStatement.length() > 0) {
			addQuery(currentStatement.toString());
		}

		return queries;
	}

	/**
	 * Adds a new query to the list of queries.
	 *
	 * @param statement The SQL statement to be added.
	 */
	private void addQuery(String statement) {
		QueryFactory factory = QueryType.fromStatement(statement).getQueryFactory();
		if (factory == null) {
			return;
		}

		queries.add(factory.createQuery(statement));
	}

	/**
	 * Retrieves the next character from the SQL script.
	 *
	 * @return The next character from the script.
	 */
	private char getNextCharacter() {
		return script.charAt(currentIndex++);
	}

	/**
	 * Handles the string delimiter ('), toggling the inside/outside string state.
	 */
	private void handleStringDelimiter() {
		insideString = !insideString;
	}

}
