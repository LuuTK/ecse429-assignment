package ca.mcgill.ecse429.conformancetest.ccoinbox;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import ca.mcgill.ecse429.conformancetest.statemodel.State;
import ca.mcgill.ecse429.conformancetest.statemodel.StateMachine;
import ca.mcgill.ecse429.conformancetest.statemodel.Transition;
import ca.mcgill.ecse429.conformancetest.statemodel.persistence.PersistenceStateMachine;
import tuantests.GeneratedFileWriterTest;

public class Main {

	public static void generateRoundTripPathFile() throws IOException{
		String addNewLine = "\n";

		System.out.println("In Main Class \n");
		PersistenceStateMachine.loadStateMachine("ccoinbox.xml");
		

		File outputTestFile = new File("src/ca/mcgill/ecse429/conformancetest/ccoinbox/GeneratedRoundTripPath.java");
		FileWriter outputTestFileWriter = new FileWriter(outputTestFile);
		
		
		
		
		outputTestFile.createNewFile(); // creates a new testCCoinBox file
		
		/* WRITE PACKAGE AND IMPORTS */
		outputTestFileWriter.write(""
				+ "package ca.mcgill.ecse429.conformancetest.ccoinbox;" + addNewLine
				+ "import java.io.IOException;" + addNewLine
				+ "import java.util.ArrayList; " + addNewLine
				+ "import java.util.HashMap;" + addNewLine
				+ "import java.util.LinkedList;" + addNewLine
				+ "import java.util.List;" + addNewLine
				+ "import java.util.Map;" + addNewLine
				+ "import org.w3c.dom.*;" + addNewLine

				+ "import ca.mcgill.ecse429.conformancetest.statemodel.State;" + addNewLine
				+ "import ca.mcgill.ecse429.conformancetest.statemodel.StateMachine;" + addNewLine
				+ "import ca.mcgill.ecse429.conformancetest.statemodel.Transition;" + addNewLine
				+ "import ca.mcgill.ecse429.conformancetest.statemodel.persistence.PersistenceStateMachine;" + addNewLine
				+ "import tuantests.Node;" + addNewLine

				+ "");
		
		/* WRITE FILE CLASS */
		outputTestFileWriter.write(""
				+ "public class GeneratedRoundTripPath {" + addNewLine + addNewLine
				+ "private static class Node {" + addNewLine
				+ "private State name;" + addNewLine
				+ "private int value;" + addNewLine
				+ "private State state;" + addNewLine
				+ "private Transition prevTrans;" + addNewLine
				+ "private ArrayList<Node> children;" + addNewLine +addNewLine
				+ "		public Node(State state, Transition prevTrans, ArrayList<Node> children) {" + addNewLine
				+ "this.state = state;" + addNewLine
				+ "this.prevTrans = prevTrans;" + addNewLine
				+ "this.children = new ArrayList<Node>();" + addNewLine + addNewLine
			
				+ "}" + addNewLine
		
				+ "public void addChild(Node newNode){" + addNewLine
				+ "	children.add(newNode);" + addNewLine
				+ "}" + addNewLine
				+ ""
				+ ""
				+ ""
				+ ""
				+ "}" + addNewLine
	
				+ "public static void main(String[] agrs) throws IOException{" + addNewLine
		+ "PersistenceStateMachine.loadStateMachine(\"ccoinbox.xml\");" + addNewLine
		+ "HashMap<String, Node> map = new HashMap<String, Node>();" + addNewLine
		+ "StateMachine sm = StateMachine.getInstance();" + addNewLine
		+ "ArrayList<Node> fullTree = new ArrayList<Node>();" + addNewLine
				+ "State currentState = sm.getStartState();" + addNewLine
		+ "Node rootNode = new Node(currentState, null, null);" + addNewLine
		
		+ "LinkedList<Transition> transitions = new LinkedList<Transition>();" + addNewLine
		+ "for(int i = 0; i < sm.getTransitions().size(); i++){" + addNewLine
		+ "	transitions.add(sm.getTransition(i));" + addNewLine
		+ "}" + addNewLine
		
		+ "Node previousNode = rootNode;" + addNewLine
		
		+ "fullTree.add(0, rootNode);" + addNewLine
		+ "map.put(rootNode.state.getName(), rootNode);" + addNewLine
		
		+ "while(transitions.isEmpty() == false){" + addNewLine
		+ "	Transition currentTransition = transitions.poll();" + addNewLine
		+ "	currentState = currentTransition.getFrom();" + addNewLine
		+ "	previousNode = map.get(currentState.getName());" + addNewLine
			
		+ "	Node nextNode = new Node(currentTransition.getTo(), currentTransition , null);" + addNewLine
		+ "	if(!map.containsKey(currentTransition.getTo().getName())){" + addNewLine
		+ "		map.put(currentTransition.getTo().getName(), nextNode);" + addNewLine
		+ "	}" + addNewLine
		
		+ "	previousNode.addChild(nextNode);" + addNewLine
			
		+ "	fullTree.add(nextNode);" + addNewLine
				
		+ "}" + addNewLine
		
		+ "System.out.println(\"hello\");" + addNewLine
		+ "}" + addNewLine

		+ "}" + addNewLine

				+ ""
				+ ""
				+ ""
				+ "");
		
		
		
		outputTestFileWriter.flush();
		outputTestFileWriter.close();
	}
	
	public static void CreateFileFunctions(){

	}
	public static void main(String[] args) throws IOException {	
		generateRoundTripPathFile();
		GeneratedRoundTripPath.main(args);
	}

}
