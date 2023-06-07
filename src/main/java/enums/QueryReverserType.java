package enums;

import models.Query;
import reversers.AlterTableQueryReverser;
import reversers.CreateQueryReverser;
import reversers.InsertQueryReverser;
import reversers.QueryReverser;

/**
 *
 * @author Luan Nadaletti
 *
 */
public enum QueryReverserType {
	INSERT_REVERSER {
		@Override
		public QueryReverser getQueryReverser() {
			return new InsertQueryReverser();
		}
	},

	CREATE_REVERSER {
		@Override
		public QueryReverser getQueryReverser() {
			return new CreateQueryReverser();
		}

	},

	ALTER_TABLE_REVERSER {

		@Override
		public QueryReverser getQueryReverser() {
			return new AlterTableQueryReverser();
		}

	};

	public abstract QueryReverser getQueryReverser();

	public static QueryReverserType fromQuery(Query query) {
		if (query.toString().contains("INSERT INTO") && query.toString().contains("VALUES")) {
			return INSERT_REVERSER;
		}
		if (query.toString().contains("CREATE")) {
			return CREATE_REVERSER;
		}
		if (query.toString().contains("ALTER TABLE")) {
			return ALTER_TABLE_REVERSER;
		}

		return null;
	}

}
