package main.parsers;

import java.util.LinkedList;
import java.util.List;
import main.enums.QueryType;
import main.factories.QueryFactory;
import main.models.Query;

/**
 *
 * @author Luan Nadaletti
 *
 */
public class QueryParser {

    private String script;
    private LinkedList<Query> queries = new LinkedList<>();

    private int currentIndex = 0;
    private boolean insideString = false;

    public QueryParser(String script) {
        this.script = script;
    }

    /**
     *
     * Analisa o script SQL fornecido e retorna uma lista de todas as declarações SQL encontradas.
     *
     * @return Uma lista de todas as declarações SQL encontradas no script.
     */
    public List<Query> parse() {
        StringBuilder currentQuery = new StringBuilder();

        while (currentIndex < script.length()) {
            char character = getNextCharacter();

            if (character == '\'') {
                handleStringDelimiter();
            }

            if (!insideString && character == ';') {
                currentQuery.append(character);
                addQuery(currentQuery.toString());
                currentQuery = new StringBuilder();
            } else {
                currentQuery.append(character);
            }
        }

        if (currentQuery.length() > 0) {
            addQuery(currentQuery.toString());
        }

        return queries;
    }

    private void addQuery(String query) {
        QueryFactory factory = QueryType.fromStatement(query).getQueryFactory();
        queries.add(factory.createQuery(query));
    }

    private char getNextCharacter() {
        return script.charAt(currentIndex++);
    }

    private void handleStringDelimiter() {
        insideString = !insideString;
    }

}
