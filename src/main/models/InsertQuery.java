package main.models;

import java.util.List;

/**
 *
 * @author Luan Nadaletti
 *
 */
public class InsertQuery extends Query {

    private List<String> fields;
    private List<String> values;

    public InsertQuery(String statement, String table, List<String> fields, List<String> values) {
        super(statement, table);
        this.fields = fields;
        this.values = values;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

}
