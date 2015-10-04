package ca.mcgill.ecse429.conformancetest.ccoinbox;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import ca.mcgill.ecse429.conformancetest.statemodel.persistence.PersistenceStateMachine;

public class Main {

	public static void generateFileHeader() throws IOException{
		String addNewLine = "\n";

		System.out.println("In Main Class \n");
		PersistenceStateMachine.loadStateMachine("ccoinbox.xml");
		

		File outputTestFile = new File("src/ca/mcgill/ecse429/conformancetest/ccoinbox/GeneratedRoundTripPath.java");
		FileWriter outputTestFileWriter = new FileWriter(outputTestFile);
		
		
		
		
		outputTestFile.createNewFile(); // creates a new testCCoinBox file
		outputTestFileWriter.write("Hello");
		outputTestFileWriter.flush();
		outputTestFileWriter.close();
	}
	
	public static void main(String[] args) throws IOException {	
		generateFileHeader();
	}

}
