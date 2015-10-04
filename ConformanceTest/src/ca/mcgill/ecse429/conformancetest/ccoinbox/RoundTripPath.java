package ca.mcgill.ecse429.conformancetest.ccoinbox;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.w3c.dom.*;

import ca.mcgill.ecse429.conformancetest.statemodel.State;
import ca.mcgill.ecse429.conformancetest.statemodel.StateMachine;
import ca.mcgill.ecse429.conformancetest.statemodel.Transition;
import ca.mcgill.ecse429.conformancetest.statemodel.persistence.PersistenceStateMachine;
import tuantests.Node;

public class RoundTripPath {
	static ArrayList<ArrayList<Node>> allPaths = new ArrayList<ArrayList<Node>>();

	public static class Node {
		private State name;
		private int value;
		private State state;
		private Transition prevTrans;
		private ArrayList<Node> children;
		public int count;

		public Node(State state, Transition prevTrans, ArrayList<Node> children) {
			this.state = state;
			this.prevTrans = prevTrans;
			this.children = new ArrayList<Node>();

		}

		public void addChild(Node newNode) {
			children.add(newNode);
		}
	}

	public static void getAllPaths(Node root, ArrayList<Node> currentPath, ArrayList<ArrayList<Node>> allPaths) {

		if (root == null) {
			return;
		}

		// path.add(node);

		if (root.children.isEmpty()) {
			currentPath.add(root);
			allPaths.add(currentPath);
		} else {
			for (Node s : root.children) {
				ArrayList<Node> newPath = copyPath(currentPath);
				newPath.add(root);

				getAllPaths(s, newPath, allPaths);
			}
		}

		// printAllPaths(path.get(node.children.indexOf(node)),path);
		// System.out.println("yo");
	}

	public static ArrayList<Node> copyPath(ArrayList<Node> path) {
		ArrayList<Node> newPath = new ArrayList<Node>();
		for (Node s : path) {
			newPath.add(s);
		}
		return newPath;
	}
	
	public static void generateTestFunctions(){
		
		System.out.println("allPaths Size : " + allPaths.size());
		Integer allPathsLength = allPaths.size();
		String outputString = "";
		String addNewLine = "\n";
		for(int i = 0; i < allPathsLength; i++){
			outputString += "@Test" + addNewLine;
			outputString += "public void conformanceTest" + i + "() {" + addNewLine;
			outputString += "System.out.println(\"==================== conformanceTest" + i + " =========================\");" + addNewLine
					+ "StateMachine sm;" + addNewLine
					+ "sm = StateMachine.getInstance();" + addNewLine
					+ "assertTrue(ccb.getState().name(), ccb.getState().name().equals(\"empty\"));"
					+ ""
					+ ""
					+ ""
					+ "";
		}
		
		System.out.println(allPaths.get(0).get(0).state.getName());
		System.out.println(allPaths.get(0).get(1).prevTrans.getEvent());
		System.out.println(allPaths.get(0).get(1).state.getName());
		System.out.println(allPaths.get(0).get(2).prevTrans.getEvent());
		System.out.println(allPaths.get(0).get(2).state.getName());
		
		
	}
	
	public static void generateRoundTripPathFile() throws IOException{
		String addNewLine = "\n";

		System.out.println("In Main Class \n");
		PersistenceStateMachine.loadStateMachine("ccoinbox.xml");
		StateMachine sm = StateMachine.getInstance();

		String CCoinBoxString = sm.getClassName().substring(0, sm.getClassName().length()-5);


		File outputTestFile = new File("src/ca/mcgill/ecse429/conformancetest/ccoinbox/GeneratedTestFile.java");
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
				
				+ "import static org.junit.Assert.*;" + addNewLine

				+ "import org.junit.After;" + addNewLine
				+ "import org.junit.AfterClass;" + addNewLine
				+ "import org.junit.Before;" + addNewLine
				+ "import org.junit.BeforeClass;" + addNewLine
				+ "import org.junit.Test;" + addNewLine

				+ "import ca.mcgill.ecse429.conformancetest.statemodel.State;" + addNewLine
				+ "import ca.mcgill.ecse429.conformancetest.statemodel.StateMachine;" + addNewLine
				+ "import ca.mcgill.ecse429.conformancetest.statemodel.Transition;" + addNewLine
				+ "import ca.mcgill.ecse429.conformancetest.statemodel.persistence.PersistenceStateMachine;" + addNewLine
				+ "import tuantests.Node;" + addNewLine

				+ ""
				+ "");
		
		/* WRITE FILE CLASS */
		outputTestFileWriter.write(""
				+ "public class GeneratedTestFile {" + addNewLine + addNewLine
								
				
				/* TESTS PART */
				+ "@BeforeClass" + addNewLine
				+ "public static void setUpBeforeClass() throws Exception {" + addNewLine
				+ "}" + addNewLine

				+ "@AfterClass" + addNewLine
				+ "public static void tearDownAfterClass() throws Exception {" + addNewLine
				+ "}" + addNewLine

				+ "@Before" + addNewLine
				+ "public void setUp() throws Exception {" + addNewLine
				+ "		PersistenceStateMachine.loadStateMachine(\"ccoinbox.xml\");" + addNewLine
				+ "StateMachine sm;" + addNewLine
				+ "}" + addNewLine

				+ "@After" + addNewLine
				+ "public void tearDown() throws Exception {" + addNewLine
				+ "	StateMachine.getInstance().delete();" + addNewLine
				+ "}" + addNewLine

				/* Test 1 */
				+ "@Test" + addNewLine
				+ "public void conformanceTest01() {" + addNewLine
				+ "	System.out.println(\"==================== conformanceTest01 =========================\");" + addNewLine
						+ "	StateMachine sm;" + addNewLine
				+ "	sm = StateMachine.getInstance();" + addNewLine
				+ 	CCoinBoxString + " ccb = new " + CCoinBoxString + "();" + addNewLine
					
				+ "	//constructor initial state" + addNewLine
				+ "	System.out.println(\"ccb.getState().name() : \" + ccb.getState().name());" + addNewLine
					+ "	assertTrue(ccb.getState().name(), ccb.getState().name().equals(\"empty\"));" + addNewLine
					
					
					
				+ "}" + addNewLine
				/* Test 2 */
				
				+ "	@Test" + addNewLine
				+ "public void conformanceTest02(){" + addNewLine
				+ "System.out.println(\"==================== conformanceTest02 =========================\");" + addNewLine
	
				+ "StateMachine sm;" + addNewLine
				+ "sm = StateMachine.getInstance();" + addNewLine
				+ "CCoinBox ccb = new CCoinBox();" + addNewLine
			
				+ "//start, empty, empty, " + addNewLine
				+ "System.out.println(\"ccb.getStateFullName() : \" + ccb.getStateFullName());" + addNewLine
				+ "System.out.println(\"ccb.returnQtrs()\");" + addNewLine
				+ "ccb.returnQtrs();" + addNewLine
				+ "System.out.println(\"ccb.getState() : \" + ccb.getState());" + addNewLine
				+ "ccb.addQtr();" + addNewLine
				+ "System.out.println(\"ccb.getState()  after add : \" + ccb.getState());" + addNewLine

		
		
		
				+ "}" + addNewLine
			+ ""

				
				
				
				
	

		+ "	}" + addNewLine
		);
		
		
		outputTestFileWriter.flush();
		outputTestFileWriter.close();
	}

	public static void main(String[] agrs) throws IOException {
		PersistenceStateMachine.loadStateMachine("ccoinbox.xml");
		HashMap<String, Node> map = new HashMap<String, Node>();
		StateMachine sm = StateMachine.getInstance();
		ArrayList<Node> fullTree = new ArrayList<Node>();
		State currentState = sm.getStartState();
		Node rootNode = new Node(currentState, null, null);

		LinkedList<Transition> transitions = new LinkedList<Transition>();
		for (int i = 0; i < sm.getTransitions().size(); i++) {
			transitions.add(sm.getTransition(i));
		}

		Node previousNode = rootNode;

		fullTree.add(0, rootNode);
		map.put(rootNode.state.getName(), rootNode);

		while (transitions.isEmpty() == false) {
			Transition currentTransition = transitions.poll();
			currentState = currentTransition.getFrom();
			previousNode = map.get(currentState.getName());

			Node nextNode = new Node(currentTransition.getTo(), currentTransition, null);
			if (!map.containsKey(currentTransition.getTo().getName())) {
				map.put(currentTransition.getTo().getName(), nextNode);
			}

			previousNode.addChild(nextNode);

			fullTree.add(nextNode);

		}

		getAllPaths(rootNode, new ArrayList<Node>(), allPaths);

		// System.out.println("hello");
		// Prints all paths with states
		for (int i = 0; i < allPaths.size(); i++) {
			System.out.println();
			for (int j = 0; j < allPaths.get(i).size(); j++) {
				System.out.print(allPaths.get(i).get(j).state.getName() + ", ");
			}
		}
		System.out.println("");
		System.out.println("========== GENERATED TEST FILE ==========");
		
		//generateTestFunctions();
		generateRoundTripPathFile();
		//GeneratedTestFile.main(args);
		//GeneratedTestFile


	}

}
