package enums;

public enum CreateQueryType {

	TABLE {

		@Override
		public String getKeyWord() {
			return "TABLE";
		}

	},
	SEQUENCE {

		@Override
		public String getKeyWord() {
			return "SEQUENCE";
		}

	};

	public abstract String getKeyWord();

	public static CreateQueryType fromType(String type) {
		if (type.toUpperCase().equals("TABLE")) {
			return TABLE;
		}

		if (type.toUpperCase().equals("SEQUENCE")) {
			return SEQUENCE;
		}

		return null;
	}

}
