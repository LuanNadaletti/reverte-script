package main;

import java.util.List;
import main.factories.queryreverser.QueryReverserFactory;
import main.models.Query;
import main.parsers.QueryParser;

/**
 *
 * @author Luan Nadaletti
 *
 */
public class ReverteScript {

    public static void main(String[] args) throws Exception {
        String script = "INSERT INTO GER_MENU (MNU_COD, MNU_DESC) VALUES (1, 'TESTE');"
        		+ "CREATE TABLE GER_MENU ("
        		+ "		MNU_COD INTEGER(60) PRIMARY KEY,"
        		+ "		MNU_DESC VARCHAR(70)"
        		+ ");";

        QueryParser queryParser = new QueryParser(script);
        List<Query> queryList = queryParser.parse();

        for (Query query : queryList) {
            System.out.println(QueryReverserFactory.getConverter(query).reverse(query));
        }
    }

}
