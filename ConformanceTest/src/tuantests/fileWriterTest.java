package tuantests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.script.ScriptException;

import ca.mcgill.ecse429.conformancetest.statemodel.StateMachine;
import ca.mcgill.ecse429.conformancetest.statemodel.persistence.PersistenceStateMachine;

public class fileWriterTest {

	public static void generateTestFile() throws IOException {
		String addNewLine = "\n";

		// URL url = getClass().getResource("CCoinBox.java");

		
		
		
		
		System.out.println("In Main Class \n");
		PersistenceStateMachine.loadStateMachine("ccoinbox.xml");
		StateMachine sm = StateMachine.getInstance();
		
		String CCoinBoxString = sm.getClassName().substring(0, sm.getClassName().length()-5);
		
		
		File outputTestFile = new File("src/tuantests/GeneratedFileWriterTest.java");
		FileWriter outputTestFileWriter = new FileWriter(outputTestFile);
		
		
		
		
		outputTestFile.createNewFile(); // creates a new testCCoinBox file
		outputTestFileWriter
				.write("" 
						+ "package tuantests;" + addNewLine + addNewLine
						+ "import ca.mcgill.ecse429.conformancetest.statemodel.StateMachine;" + addNewLine
						+ "import ca.mcgill.ecse429.conformancetest.statemodel.persistence.PersistenceStateMachine;" + addNewLine
						+ "import ca.mcgill.ecse429.conformancetest.ccoinbox." + CCoinBoxString + ";" + addNewLine
						+ "public class GeneratedFileWriterTest{" + addNewLine 

						+ "public static void main(String[] args) {" + addNewLine
						+ "System.out.println(\"In Main Class \");" + addNewLine
						+ "PersistenceStateMachine.loadStateMachine(\"ccoinbox.xml\");" + addNewLine
						+ "StateMachine sm = StateMachine.getInstance();" + addNewLine
						+ "		String CCoinBoxString = sm.getClassName().substring(0, sm.getClassName().length()-5);" + addNewLine
						+ "		System.out.println(CCoinBoxString);" + addNewLine
						+ CCoinBoxString + " test = new " + CCoinBoxString +"();" + addNewLine
						+ "System.out.println(test.getCurQtrs());" + addNewLine

		+ "}" + addNewLine

		+ "}" + addNewLine

		);
		outputTestFileWriter.flush();
		outputTestFileWriter.close();
		
		
	}
	public static void main(String[] args) throws IOException {		
		
		generateTestFile();
		GeneratedFileWriterTest.main(args);
	}
	
	
}
