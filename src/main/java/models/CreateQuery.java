package models;

import enums.CreateQueryType;

public class CreateQuery extends Query {

	private CreateQueryType createQueryType;

	public CreateQuery(String statement, String table, CreateQueryType createQueryType) {
		super(statement, table);
		this.createQueryType = createQueryType;
	}

	public CreateQueryType getCreateQueryType() {
		return createQueryType;
	}

}
