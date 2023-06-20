package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * The {@code TextFileReader} class provides utility methods for reading the
 * contents of a text file.
 *
 * @author Luan Nadaletti
 */
public class TextFileReader {

	private static final int BUFFER_SIZE = 8192;

	/**
	 * Reads the contents of a text file and returns it as a string.
	 *
	 * @param file The text file to read.
	 * @return The contents of the text file as a string.
	 * @throws IOException If an I/O error occurs while reading the file.
	 */
	public static String read(File file) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file), BUFFER_SIZE);

		char[] buffer = new char[BUFFER_SIZE];

		int charsRead;
		while ((charsRead = bufferedReader.read(buffer, 0, BUFFER_SIZE)) != -1)
			stringBuilder.append(buffer, 0, charsRead);

		bufferedReader.close();
		return stringBuilder.toString();
	}

}
