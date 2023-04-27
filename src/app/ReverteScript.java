package app;

import java.util.List;
import query.factories.QueryConverterFactory;
import query.models.Query;
import query.parsers.QueryParser;

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
