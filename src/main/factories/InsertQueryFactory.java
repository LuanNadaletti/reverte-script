package main.factories;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import main.models.InsertQuery;
import main.models.Query;

/**
 *
 * @author Luan Nadaletti
 *
 */
public class InsertQueryFactory implements QueryFactory {

    @Override
    public Query createQuery(String statement) {
        String regex = "\\s*INSERT\\s*INTO\\s*(\\w+)\\s*\\((.+)\\)\\s*VALUES\\s*\\((.+)\\)\\s*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(statement);

        if (!matcher.find()) {
            throw new IllegalArgumentException("Invalid INSERT statement");
        }

        String table = matcher.group(1);
        List<String> fields = Arrays.asList(matcher.group(2).split(",")).stream().map(String::trim).collect(Collectors.toList());
        List<String> values = Arrays.asList(matcher.group(3).split(",")).stream().map(String::trim).collect(Collectors.toList());

        return new InsertQuery(statement, table, fields, values);
    }

}
