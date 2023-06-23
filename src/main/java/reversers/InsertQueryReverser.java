package reversers;

import models.InsertQuery;

import models.Query;

/**
 * Reverses an InsertQuery by generating the reversed SQL statement. This class
 * extends the {@link QueryReverser} class and provides the implementation to
 * reverse an InsertQuery.
 *
 * The class provides the {@link #reverse(Query)} method, which takes an
 * InsertQuery as input and generates the reversed SQL statement.
 *
 * Instances of this class are stateless and can be reused for multiple queries.
 *
 * @author Luan Nadaletti
 */
public class InsertQueryReverser extends QueryReverser {

	/**
	 * Reverses an InsertQuery by generating the reversed SQL statement.
	 *
	 * @param query The InsertQuery to be reversed.
	 *
	 * @return The reversed SQL statement.
	 *
	 * @throws IllegalArgumentException If the provided query is not an instance of
	 *                                  InsertQuery.
	 */
	@Override
	public String reverse(Query query) {
		InsertQuery insertQuery = (InsertQuery) query;

		String where = "";

		for (int i = 0; i < insertQuery.getValues().size(); i++) {
			where += insertQuery.getFields().get(i) + " = " + insertQuery.getValues().get(i);

			if (i != insertQuery.getValues().size() - 1) {
				where += " AND ";
			}
		}

		return String.format("DELETE FROM %s WHERE %s;", insertQuery.getTable(), where);
	}

}
