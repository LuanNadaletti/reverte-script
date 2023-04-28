package main.parsers;

import java.util.LinkedList;
import java.util.List;
import main.enums.QueryType;
import main.factories.query.QueryFactory;
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
        StringBuilder currentStatement = new StringBuilder();

        while (currentIndex < script.length()) {
            char character = getNextCharacter();

            if (character == '\'') {
                handleStringDelimiter();
            }

            if (!insideString && character == ';') {
                currentStatement.append(character);
                addQuery(currentStatement.toString());
                currentStatement = new StringBuilder();
            } else {
                currentStatement.append(character);
            }
        }

        if (currentStatement.length() > 0) {
            addQuery(currentStatement.toString());
        }

        return queries;
    }

    private void addQuery(String statement) {
        QueryFactory factory = QueryType.fromStatement(statement).getQueryFactory();
        queries.add(factory.createQuery(statement));
    }

    private char getNextCharacter() {
        return script.charAt(currentIndex++);
    }

    private void handleStringDelimiter() {
        insideString = !insideString;
    }

}
