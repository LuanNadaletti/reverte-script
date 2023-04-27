package query.parsers;

import java.util.LinkedList;
import java.util.List;
import query.models.Query;

public class QueryParser {

    private String script;
    private LinkedList<Query> statements = new LinkedList<>();

    private int indiceAtual = 0;
    private boolean dentroDeString = false;

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
        StringBuilder declaracaoAtual = new StringBuilder();

        while (indiceAtual < script.length()) {
            char caractere = obterProximoCaractere();

            if (caractere == '\'') {
                manipularDelimitadorDeString();
            }

            if (!dentroDeString && caractere == ';') {
                declaracaoAtual.append(caractere);
                adicionarDeclaracao(declaracaoAtual.toString());
                declaracaoAtual = new StringBuilder();
            } else {
                declaracaoAtual.append(caractere);
            }
        }

        if (declaracaoAtual.length() > 0) {
            adicionarDeclaracao(declaracaoAtual.toString());
        }

        return statements;
    }

    private void adicionarDeclaracao(String sql) {
        statements.add(new Query(sql));
    }

    private char obterProximoCaractere() {
        return script.charAt(indiceAtual++);
    }

    private void manipularDelimitadorDeString() {
        dentroDeString = !dentroDeString;
    }

}
