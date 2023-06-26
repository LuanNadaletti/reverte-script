package parsers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.InsertQuery;
import models.Query;

/**
 *
 * @author Luan Nadaletti
 *
 */
class QueryParserTest {

	private QueryParser parser;

	@BeforeEach
	public void setup() {
		String script = "INSERT INTO table (column) VALUES ('value');";
		parser = new QueryParser(script);
	}

	@Test
	public void testParse() {
		List<Query> queries = parser.parse();

		assertEquals(1, queries.size());

		Query insertQuery = queries.get(0);
		assertTrue(insertQuery instanceof InsertQuery);

		insertQuery = (InsertQuery) insertQuery;
		assertEquals("INSERT INTO table (column) VALUES ('value');", insertQuery.toString());
	}

}
