package tuantests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import ca.mcgill.ecse429.conformancetest.ccoinbox.CCoinBox;
import ca.mcgill.ecse429.conformancetest.statemodel.State;
import ca.mcgill.ecse429.conformancetest.statemodel.StateMachine;
import ca.mcgill.ecse429.conformancetest.statemodel.persistence.PersistenceStateMachine;

public class ManualCCoinBoxTestings {

	private Node root;

	public static void getXMLInfo() throws ScriptException {
		PersistenceStateMachine.loadStateMachine("ccoinbox.xml");
		StateMachine sm = StateMachine.getInstance();
		int i = 0;

		System.out.println("========================================================");

		// QUICKFIX : added in the while statement to avoid the error (out of
		// bounds)
		while (sm.getTransitions().isEmpty() == false && i < 13) {
			// System.out.println("transitions");
			// System.out.println(sm.getTransition(i).getEvent());

			System.out.println("Events " + i + " : " + sm.getTransition(i).getEvent());
			System.out.println("Condition " + i + " : " + sm.getTransition(i).getCondition());
			System.out.println("Condition " + i + " : " + sm.getTransition(i).getAction());

			i++;
			System.out.println("========================================================");
		}

		System.out.println("States  : " + sm.getStates().get(1).getName()); // empty
																			// state
		System.out.println("States  : " + sm.getStates().get(2).getName()); // not
																			// allowed
																			// state
		System.out.println("States  : " + sm.getStates().get(3).getName()); // allowed
																			// state

		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("JavaScript");
		String testCondition = "10 > 3";
		System.out.println(engine.eval(testCondition));

	}

	public static void createRootNode() {
		
		PersistenceStateMachine.loadStateMachine("ccoinbox.xml");
		StateMachine sm = StateMachine.getInstance();
		int i = 0;
//		while (sm.getTransitions().isEmpty() == false && i < 13) {
//			// System.out.println("transitions");
//			// System.out.println(sm.getTransition(i).getEvent());
//
//			System.out.println("Events " + i + " : " + sm.getTransition(i).getEvent());
//			System.out.println("Condition " + i + " : " + sm.getTransition(i).getCondition());
//			System.out.println("Condition " + i + " : " + sm.getTransition(i).getAction());
//
//			i++;
//			System.out.println("========================================================");
//			
//			if(sm.getTransition(i).getEvent().equals("@ctor")){
//				
//			}
			

			
		//}
		String CCoinBoxString = sm.getClassName().substring(0, sm.getClassName().length()-5);
		CCoinBox test = new CCoinBox();
		System.out.println("sm.getClassName() : " + sm.getClassName());
		System.out.println("sm.getPackageName() : " + sm.getPackageName());
		System.out.println("sm.getClass() : " + sm.getClass());

		System.out.println(CCoinBoxString);
		String tmp = sm.getClassName();
		constructor = tmp.substring(0, sm.getClassName().length() - 5);
		//CCoinBoxString test = new CCoinBoxString();

	}

	public static void main(String[] args) throws IOException, ScriptException {

		System.out.println("In ManualCCoinBoxTestings File");
		StateMachine sm;

		PersistenceStateMachine.loadStateMachine("ccoinbox.xml");
		sm = StateMachine.getInstance();

		// ManualCCoinBoxTestings root = new
		// ManualCCoinBoxTestings(sm.getStates().get(1));
		Node root = new Node("root");
		Node S1 = new Node("S1");
		Node S2 = new Node("S2");
		Node S3 = new Node("S3");
		Node S4 = new Node("S4");

		root.state = sm.getStates().get(1);
		root.treeInstert(root, S1);
		root.treeInstert(root, S2);
		root.treeInstert(root, S3);
		root.treeInstert(root, S4);
		root.treeInstert(S1, S4);

		System.out.println(root.children.get(1).parent.name);
		//getXMLInfo();
		createRootNode();
	}
}

// public static class Node {
// private String name;
// private Boolean isParent;
// private Node parent;
// private List<Node> children;
// private int value;
// private String data;
//
// private State state;
//
// public Node(String name) {
// this.name = name;
// children = new ArrayList<Node>();
// }
//
// public void treeInstert(Node parentNode, Node childrenNode) {
// parentNode.children.add(childrenNode);
// childrenNode.parent = parentNode;
// }
// }