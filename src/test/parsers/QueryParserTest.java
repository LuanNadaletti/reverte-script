package test.parsers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import main.models.AlterTableQuery;
import main.models.CreateTableQuery;
import main.models.InsertQuery;
import main.models.Query;
import main.parsers.QueryParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QueryParserTest {

    @Test
    @DisplayName("InsertQueryParse")
    void testInsertQueryParse() {
        String script = "INSERT INTO GER_MENU (MNU_COD, MNU_DESC, MNU_NIVEL) VALUES (1, 'DESC', 'NIV');";
        QueryParser parser = new QueryParser(script);
        Query query = parser.parse().get(0);

        assertTrue(query instanceof InsertQuery);
        InsertQuery selectQuery = (InsertQuery) query;

        assertEquals("GER_MENU", selectQuery.getTable());
        assertEquals(Arrays.asList("MNU_COD", "MNU_DESC", "MNU_NIVEL") ,selectQuery.getFields());
        assertEquals(Arrays.asList("1", "'DESC'", "'NIV'"), selectQuery.getValues());
    }

    @Test
    @DisplayName("CreateTableQueryParse")
    void testCreateTableQueryParse() {
        String script = "CREATE TABLE table_name ("
                + "    column1 datatype,"
                + "    column2 datatype,"
                + "    column3 datatype,"
                + ");";

        QueryParser parser = new QueryParser(script);
        Query query = parser.parse().get(0);

        assertTrue(query instanceof CreateTableQuery);
        CreateTableQuery selectQuery = (CreateTableQuery) query;

        assertEquals("table_name", selectQuery.getTable());
    }

    @Test
    @DisplayName("AlterTableQueryParse")
    void testAlterTableQueryParse() {
        String script = "ALTER TABLE table_name"
                + " ADD column_name datatype;";

        QueryParser parser = new QueryParser(script);
        Query query = parser.parse().get(0);

        assertTrue(query instanceof AlterTableQuery);
        AlterTableQuery alterTableQuery = (AlterTableQuery) query;

        assertEquals("table_name", alterTableQuery.getTable());
        assertEquals("ADD", alterTableQuery.getOperator());
        assertEquals("column_name", alterTableQuery.getColumn());
        assertEquals("datatype", alterTableQuery.getDataType());
    }
}
