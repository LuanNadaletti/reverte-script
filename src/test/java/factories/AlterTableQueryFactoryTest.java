package factories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import models.AlterTableQuery;

public class AlterTableQueryFactoryTest {

	@Test
	public void testCreateQuery_ValidStatement_ReturnsAlterTableQuery() {
		String statement = "ALTER TABLE myTable ADD COLUMN myColumn INT";
		AlterTableQueryFactory factory = new AlterTableQueryFactory();
		AlterTableQuery expectedQuery = new AlterTableQuery(statement, "myTable", "ADD", "myColumn", "INT", true,
				false);

		AlterTableQuery actualQuery = (AlterTableQuery) factory.createQuery(statement);

		assertEquals(expectedQuery.getClass(), actualQuery.getClass());
		assertEquals(expectedQuery.toString(), actualQuery.toString());
		assertEquals(expectedQuery.getTable(), actualQuery.getTable());
		assertEquals(expectedQuery.getOperator(), actualQuery.getOperator());
		assertEquals(expectedQuery.getTarget(), actualQuery.getTarget());
		assertEquals(expectedQuery.getDataType(), actualQuery.getDataType());
	}

	@Test
	public void testCreateQuery_InvalidStatement_ThrowsIllegalArgumentException() {
		String statement = "ALTER TABLE";
		AlterTableQueryFactory factory = new AlterTableQueryFactory();

		assertThrows(IllegalArgumentException.class, () -> factory.createQuery(statement));
	}

}
