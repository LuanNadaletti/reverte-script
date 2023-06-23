package reversers;

import models.AlterTableQuery;
import models.Query;

/**
 * Reverses an AlterTableQuery by generating the reversed SQL statement. This
 * class extends the {@link QueryReverser} class and provides the implementation
 * to reverse an AlterTableQuery.
 *
 * The class provides the {@link #reverse(Query)} method, which takes an
 * AlterTableQuery as input and generates the reversed SQL statement.
 *
 * Instances of this class are stateless and can be reused for multiple queries.
 *
 * @author Luan Nadaletti
 */
public class AlterTableQueryReverser extends QueryReverser {

	/**
	 * Reverses an AlterTableQuery by generating the reversed SQL statement.
	 *
	 * @param query The AlterTableQuery to be reversed.
	 *
	 * @return The reversed SQL statement.
	 *
	 * @throws IllegalArgumentException If the provided query is not an instance of
	 *                                  AlterTableQuery.
	 */
	@Override
	public String reverse(Query query) {
		AlterTableQuery alterTableQuery = (AlterTableQuery) query;

		return String.format("ALTER TABLE %s %s %s;", alterTableQuery.getTable(), alterTableQuery.getReverseOperation(),
				alterTableQuery.getColumn());
	}

}
