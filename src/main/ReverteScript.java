package main;

import java.util.List;
import main.factories.QueryConverterFactory;
import main.models.Query;
import main.parsers.QueryParser;

/**
 *
 * @author Luan Nadaletti
 *
 */
public class ReverteScript {

    public static void main(String[] args) throws Exception {
        String script = "";

        QueryParser queryParser = new QueryParser(script);
        List<Query> queryList = queryParser.parse();

        for (Query query : queryList) {
            QueryConverterFactory.getConverter(query).convert(query.toString());
        }
    }

}
