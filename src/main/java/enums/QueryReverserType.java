package enums;

import models.Query;
import reversers.*;

/**
 *
 * @author Luan Nadaletti
 *
 */
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
			return INSERT;
		}
		if (query.toString().contains("CREATE TABLE")) {
			return CREATE_TABLE_REVERSER;
		}
		if (query.toString().contains("ALTER TABLE")) {
			return ALTER_TABLE_REVERSER;
		}

		return null;
	}
}
