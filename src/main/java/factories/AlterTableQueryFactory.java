package factories;

import java.util.regex.Matcher;

import java.util.regex.Pattern;
import models.AlterTableQuery;
import models.Query;

/**
 *
 * @author Luan Nadaletti
 *
 */
public class AlterTableQueryFactory implements QueryFactory {

	@Override
	public Query createQuery(String statement) {
		String regex = "ALTER\\s*TABLE\\s*(\\w*)\\s*(\\w*)\\s*(\\w*)\\s*(\\w*)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(statement);

		if (!matcher.find()) {
			throw new IllegalArgumentException("Invalid ALTER TABLE statement");
		}

		String table = matcher.group(1);
		String operator = matcher.group(2);
		String column = matcher.group(3);
		String dataType = matcher.group(4);

		return new AlterTableQuery(statement, table, operator, column, dataType);
	}

}
