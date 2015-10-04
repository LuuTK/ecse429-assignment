package ca.mcgill.ecse429.conformancetest.ccoinbox;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.mcgill.ecse429.conformancetest.ccoinbox.RoundTripPath.Node;
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
		StateMachine sm = StateMachine.getInstance();

		String CCoinBoxString = sm.getClassName().substring(0, sm.getClassName().length()-5);


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
				+ "public class GeneratedRoundTripPath {" + addNewLine + addNewLine
				+ "static ArrayList<ArrayList<Node>> allPaths = new ArrayList<ArrayList<Node>>();" + addNewLine
				+ "public static class Node {" + addNewLine
				+ "	private State name;" + addNewLine
				+ "	private int value;" + addNewLine
				+ "	private State state;" + addNewLine
				+ "	private Transition prevTrans;" + addNewLine
				+ "	private ArrayList<Node> children;" + addNewLine
				+ "	public int count;" + addNewLine
					

				+ "	public Node(State state, Transition prevTrans, ArrayList<Node> children) {" + addNewLine
				+ "		this.state = state;" + addNewLine
				+ "		this.prevTrans = prevTrans;" + addNewLine
				+ "		this.children = new ArrayList<Node>();" + addNewLine
					
				+ "	}" + addNewLine
					
				+ "	public void addChild(Node newNode){" + addNewLine
				+ "		children.add(newNode);" + addNewLine
				+ "	}" + addNewLine
				+ "}" + addNewLine
				
				+ "public static void getAllPaths(Node root, ArrayList<Node> currentPath, ArrayList<ArrayList<Node>> allPaths ){" + addNewLine
					
					
			        
				+ "	if (root == null){" + addNewLine
				+ "		return;" + addNewLine
				+ "    }" + addNewLine
					
				+ "	//path.add(node);" + addNewLine
					
				+ "	if (root.children.isEmpty()){" + addNewLine
				+ "		currentPath.add(root);" + addNewLine
				+ "		allPaths.add(currentPath);" + addNewLine
				+ "	} else {" + addNewLine
				+ "		for (Node s: root.children){" + addNewLine
				+ "			ArrayList<Node> newPath =copyPath(currentPath);" + addNewLine
				+ "			newPath.add(root);" + addNewLine
							
				+ "			getAllPaths(s, newPath, allPaths );				" + addNewLine
				+ "		}	" + addNewLine
				+ "	}" + addNewLine
					
				+ "	//printAllPaths(path.get(node.children.indexOf(node)),path);" + addNewLine
				+ "}" + addNewLine
				
				/* HELPER FUNCTIONS */
				
				+ "public static ArrayList<Node> copyPath (ArrayList<Node> path){" + addNewLine
				+ "	ArrayList<Node> newPath = new ArrayList<Node>();" + addNewLine
				+ "	for( Node s: path){" + addNewLine
				+ "		newPath.add(s);" + addNewLine
				+ "	}" + addNewLine
				+ "	return newPath;" + addNewLine
				+ "}" + addNewLine
				
				
				
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

				
				
				
				
	/* MAIN FUNCTION */
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
		
		+ "getAllPaths(rootNode, new ArrayList<Node>(), allPaths);" + addNewLine
		
		+ "//Prints all paths with states" + addNewLine
		+ "for(int i = 0; i < allPaths.size(); i++){" + addNewLine
		+ "	System.out.println();" + addNewLine
		+ "	for(int j = 0; j < allPaths.get(i).size();j++){" + addNewLine
		+ "		System.out.print(allPaths.get(i).get(j).state.getName() + \", \");" + addNewLine
		+ "	}" + addNewLine
		+ "	}" + addNewLine


		+ "	}" + addNewLine

		+ "	}" + addNewLine
		);
		
		
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
