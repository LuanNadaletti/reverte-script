
import java.io.File;
import java.io.IOException;
import java.util.List;

import enums.QueryReverserType;
import factories.InsertQueryFactory;
import models.Query;
import parsers.QueryParser;
import reversers.QueryReverser;
import util.TextFileReader;

/**
 * This class represents a script responsible for reversing queries based on
 * their query type. Each query is parsed and reversed using a specific
 * implementation of {@link QueryReverser}. The reversed result of each query is
 * displayed in the console.
 *
 * To use this class, provide the path to a file containing the script to be
 * processed as a command-line argument. The script is read from the file,
 * queries are parsed and reversed, and the result is displayed in the console.
 *
 * Example usage:
 *
 * <pre>
 * java -jar ReverteScript path/to/file.txt
 * </pre>
 *
 * @author Luan Nadaletti
 */
public class ReverteScript {

	public static void main(String[] args) throws IOException {
		if (args.length < 1) {
			System.out.println("Caminho do arquivo não fornecido. Uso: 'java -jar ReverteScript <caminho_do_arquivo>'");
			return;
		}

		String filePath = args[0];

		try {
			String script = TextFileReader.read(new File(filePath));
			List<Query> queries = parseQueries(script);

			for (Query query : queries) {
				reverseQuery(query);
			}
		} catch (IOException e) {
			System.out.println("Ocorreu um erro na leitura do arquivo: " + e.getMessage());
		}
	}

	/**
	 * Parses the provided script and returns a list of queries.
	 *
	 * @param script The script to be parsed.
	 *
	 * @return A list of queries extracted from the script.
	 */
	private static List<Query> parseQueries(String script) {
		QueryParser queryParser = new QueryParser(script);
		return queryParser.parse();
	}

	/**
	 * Reverses the provided query based on the query type and displays the result
	 * in the console.
	 *
	 * @param query The query to be reversed.
	 *
	 * @throws IllegalArgumentException      If the query cannot be reversed.
	 * @throws UnsupportedOperationException If the query reversal is not supported.
	 */
	private static void reverseQuery(Query query) {
		QueryReverserType reverserType = QueryReverserType.fromQuery(query);
		if (reverserType == null) {
			throw new IllegalArgumentException("Não é possível reverter a query: " + query);
		}

		QueryReverser reverser = reverserType.getQueryReverser();
		if (reverser == null) {
			throw new UnsupportedOperationException("Reversão da query não suportada: " + query);
		}

		String reversedQuery = reverser.reverse(query);
		System.out.println(reversedQuery);
	}

}
