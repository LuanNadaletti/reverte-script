package factories;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import enums.CreateQueryType;
import models.CreateQuery;
import models.Query;

/**
*
* @author Luan Nadaletti
*
*/
public class CreateQueryFactory implements QueryFactory {

    @Override
    public Query createQuery(String statement) {
        String regex = "\\s*CREATE\\s*(\\w*)\\s*(\\w*)\\s*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(statement);

        if (!matcher.find()) {
            throw new IllegalArgumentException("Invalid CREATE statement");
        }

        String type = matcher.group(1);
        String table = matcher.group(2);

        return new CreateQuery(statement, table, CreateQueryType.fromType(type));
    }

}
