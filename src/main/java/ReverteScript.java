
import java.io.File;
import java.io.IOException;
import java.util.List;

import enums.QueryReverserType;
import models.Query;
import parsers.QueryParser;
import reversers.QueryReverser;
import util.TextFileReader;

/**
 *
 * @author Luan Nadaletti
 *
 */
public class ReverteScript {

	public static void main(String[] args) throws IOException {
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

	private static List<Query> parseQueries(String script) {
		QueryParser queryParser = new QueryParser(script);
		return queryParser.parse();
	}

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
