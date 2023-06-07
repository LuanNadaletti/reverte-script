package models;

/**
 *
 * @author Luan Nadaletti
 *
 */
public abstract class Query {

    protected final String statement;
    protected final String table;

    public Query(String statement, String table) {
        this.statement = statement;
        this.table = table;
    }

    public String getTable() {
        return table;
    }

    @Override
    public String toString() {
        return statement;
    }

}
