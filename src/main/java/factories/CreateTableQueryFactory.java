package factories;

import java.util.regex.Matcher;

import java.util.regex.Pattern;
import models.CreateTableQuery;
import models.Query;

/**
*
* @author Luan Nadaletti
*
*/
public class CreateTableQueryFactory implements QueryFactory {

    @Override
    public Query createQuery(String statement) {
        String regex = "\\s*CREATE\\s*TABLE\\s*(\\w*)\\s*\\(";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(statement);

        if (!matcher.find()) {
            throw new IllegalArgumentException("Invalid CREATE TABLE statement");
        }

        String table = matcher.group(1);

        return new CreateTableQuery(statement, table);
    }

}
