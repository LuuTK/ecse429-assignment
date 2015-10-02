import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestCCoinBox {

	public static void main(String[] args) throws IOException {

		generateTestFile();

		GeneratedTestFile.main(args); // runs the generated test file

	}

	public static void generateTestFile() throws IOException {
		String addNewLine = "\n";

		// URL url = getClass().getResource("CCoinBox.java");

		System.out.println("In Main Class \n");
		File outputTestFile = new File("src/GeneratedTestFile.java");
		FileWriter outputTestFileWriter = new FileWriter(outputTestFile);

		outputTestFile.createNewFile(); // creates a new testCCoinBox file
		outputTestFileWriter
				.write("" + "public class GeneratedTestFile{" + addNewLine 
						+ "public static void main(String[] args) {" + addNewLine
						+ "System.out.println(\"In Main Class \");" + addNewLine

		+ "}" + addNewLine

		+ "}" + addNewLine

		);
		outputTestFileWriter.flush();
		outputTestFileWriter.close();
	}
}
