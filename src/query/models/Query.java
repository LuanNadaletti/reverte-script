package query.models;

public abstract class Query {

    protected final String statement;
    protected String table;

    public Query(String statement) {
        this.statement = statement;
    }

    @Override
    public String toString() {
        return statement;
    }

}
