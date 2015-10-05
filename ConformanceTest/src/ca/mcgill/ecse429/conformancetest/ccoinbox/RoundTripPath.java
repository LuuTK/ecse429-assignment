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

public class RoundTripPath {
	static ArrayList<ArrayList<Node>> allPaths = new ArrayList<ArrayList<Node>>();
	static String StateMachineXML = "ccoinbox.xml";
	//static String StateMachineXML = "legislation.xml";
	
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

	}

	public static ArrayList<Node> copyPath(ArrayList<Node> path) {
		ArrayList<Node> newPath = new ArrayList<Node>();
		for (Node s : path) {
			newPath.add(s);
		}
		return newPath;
	}
	
	public static String generateTestFunctions(){
		
		System.out.println("=========== START generateTestFunctions Automatically ============== ");
		Integer allPathsLength = allPaths.size();
		String outputString = "";
		String addNewLine = "\n";
		
		PersistenceStateMachine.loadStateMachine(StateMachineXML);
		StateMachine sm = StateMachine.getInstance();
		String CCoinBoxString = sm.getClassName().substring(0, sm.getClassName().length()-5);

		for(int i = 0; i < allPathsLength; i++){
			outputString += "@Test" + addNewLine;
			outputString += "public void conformanceTest" + i + "() {" + addNewLine
			+ CCoinBoxString + " ccb = new " + CCoinBoxString + "();" + addNewLine
			+ "StateMachine sm;" + addNewLine
			+ "sm = StateMachine.getInstance();" + addNewLine;

			for(int j = 1; j < allPaths.get(i).size(); j++){
				
			outputString += "System.out.println(\"==================== conformanceTest" + i + "." + j +" =========================\");" + addNewLine;

			if(j!=1){
				outputString += "ccb." + allPaths.get(i).get(j).prevTrans.getEvent() + "();" + addNewLine;
			}
					/* START Manual Changes Here */
//					if(j!=1){
//						outputString += "ccb." + allPaths.get(i).get(j).prevTrans.getEvent() + "();" + addNewLine;
//						
//						
//						/* hardcoded tests */
//						if((i == 6 && j == 4) && StateMachineXML.equals("ccoinbox.xml")){
//							outputString += "ccb." + allPaths.get(i).get(j).prevTrans.getEvent() + "(); //Hard coded" + addNewLine;
//						}
//						if(( i == 8 && j == 4 ) && StateMachineXML.equals("ccoinbox.xml")){
//							outputString += "ccb.addQtr(); //hardcoded" + addNewLine;
//						}
//						if(( i == 9 && j == 4 ) && StateMachineXML.equals("ccoinbox.xml")){
//							outputString += "ccb.addQtr(); //hardcoded" + addNewLine;
//							outputString += "ccb.addQtr(); //hardcoded" + addNewLine;
//							
//						}
//
//					}
//					
					/* END Manual Changes Here */

				outputString += "assertTrue(ccb.getStateFullName()," + "" +  "ccb.getStateFullName().equals(\"" + allPaths.get(i).get(j).state.getName() + "\")" + ");" + addNewLine;


					outputString += "";
				
			}
			if( i != allPathsLength){
				outputString += "}" + addNewLine ; 
			}
		}
		
		/* Testing purposes */
//		System.out.println(allPaths.get(0).get(0).state.getName());
//		System.out.println(allPaths.get(0).get(1).prevTrans.getEvent());
//		System.out.println(allPaths.get(0).get(1).state.getName());
//		System.out.println(" returnQtrs : " + allPaths.get(0).get(2).prevTrans.getEvent());
//		System.out.println(allPaths.get(0).get(2).state.getName());
//		System.out.println();
//		System.out.println(allPaths.get(1).get(0).state.getName());
//		System.out.println(allPaths.get(1).get(1).prevTrans.getEvent());
//		System.out.println(allPaths.get(1).get(1).state.getName());
//		System.out.println(allPaths.get(1).get(2).prevTrans.getEvent());
//		System.out.println(allPaths.get(1).get(2).state.getName());

		
		System.out.println("=========== END  generateTestFunctions Automatically ============== ");

		return outputString;
	}
	
	public static void generateRoundTripPathFile(String outputString) throws IOException{
		String addNewLine = "\n";

		PersistenceStateMachine.loadStateMachine(StateMachineXML);
		StateMachine sm = StateMachine.getInstance();

		String CCoinBoxString = sm.getClassName().substring(0, sm.getClassName().length()-5);


		File outputTestFile = new File("src/ca/mcgill/ecse429/conformancetest/ccoinbox/GeneratedTestCCoinBox.java");
		FileWriter outputTestFileWriter = new FileWriter(outputTestFile);
		
		
		
		
		outputTestFile.createNewFile(); // creates a new testCCoinBox file
		
		/* WRITE PACKAGE AND IMPORTS */
		outputTestFileWriter.write(""
				+ "package ca.mcgill.ecse429.conformancetest.ccoinbox;" + addNewLine

				
				+ "import static org.junit.Assert.*;" + addNewLine

				+ "import org.junit.After;" + addNewLine
				+ "import org.junit.AfterClass;" + addNewLine
				+ "import org.junit.Before;" + addNewLine
				+ "import org.junit.BeforeClass;" + addNewLine
				+ "import org.junit.Test;" + addNewLine
				+ "import ca.mcgill.ecse429.conformancetest.statemodel.StateMachine;" + addNewLine
				+ "import ca.mcgill.ecse429.conformancetest.statemodel.persistence.PersistenceStateMachine;" + addNewLine

				+ ""
				+ "");
		
		/* WRITE FILE CLASS */
		outputTestFileWriter.write(""
				+ "public class GeneratedTestCCoinBox {" + addNewLine + addNewLine
								
				
				/* TESTS PART */
				+ "@BeforeClass" + addNewLine
				+ "public static void setUpBeforeClass() throws Exception {" + addNewLine
				+ "}" + addNewLine

				+ "@AfterClass" + addNewLine
				+ "public static void tearDownAfterClass() throws Exception {" + addNewLine
				+ "}" + addNewLine

				+ "@Before" + addNewLine
				+ "public void setUp() throws Exception {" + addNewLine
				+ "		PersistenceStateMachine.loadStateMachine(\"" + StateMachineXML + "\");" + addNewLine
				+ "StateMachine sm;" + addNewLine
				+ "}" + addNewLine

				+ "@After" + addNewLine
				+ "public void tearDown() throws Exception {" + addNewLine
				+ "	StateMachine.getInstance().delete();" + addNewLine
				+ "}" + addNewLine
				
				//outputString is the string that generates all the @Test methods
				+ outputString + addNewLine

		
		
			+ ""

				
				
				
				
	

		+ "	}" + addNewLine
		);
		
		
		outputTestFileWriter.flush();
		outputTestFileWriter.close();
	}

	public static void main(String[] agrs) throws IOException {
		PersistenceStateMachine.loadStateMachine(StateMachineXML);
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

		// Prints all paths with states
		for (int i = 0; i < allPaths.size(); i++) {
			System.out.println();
			for (int j = 0; j < allPaths.get(i).size(); j++) {
				System.out.print(allPaths.get(i).get(j).state.getName() + ", ");
			}
		}
		
		System.out.println("");
		System.out.println("========== GENERATED TEST FILE ==========");
		
		generateTestFunctions();
		generateRoundTripPathFile(generateTestFunctions());


	}

}
