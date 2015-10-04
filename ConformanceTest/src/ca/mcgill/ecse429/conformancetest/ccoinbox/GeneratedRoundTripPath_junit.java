package ca.mcgill.ecse429.conformancetest.ccoinbox;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.w3c.dom.*;

import org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.mcgill.ecse429.conformancetest.statemodel.State;
import ca.mcgill.ecse429.conformancetest.statemodel.StateMachine;
import ca.mcgill.ecse429.conformancetest.statemodel.Transition;
import ca.mcgill.ecse429.conformancetest.statemodel.persistence.PersistenceStateMachine;
import tuantests.Node;

public class GeneratedRoundTripPath_junit {

	private static class Node {
		private State name;
		private int value;
		private State state;
		private Transition prevTrans;
		private ArrayList<Node> children;

		public Node(State state, Transition prevTrans, ArrayList<Node> children) {
			this.state = state;
			this.prevTrans = prevTrans;
			this.children = new ArrayList<Node>();

		}

		public void addChild(Node newNode) {
			children.add(newNode);
		}
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void conformanceTest01() {
		System.out.println("==================== conformanceTest01 =========================");
		StateMachine sm;
		PersistenceStateMachine.loadStateMachine("ccoinbox.xml");
		sm = StateMachine.getInstance();
		CCoinBox ccb = new CCoinBox();
		
		//constructor initial state
		System.out.println("ccb.getState().name() : " + ccb.getState().name());
		assertTrue(ccb.getState().name(), ccb.getState().name().equals("empty"));
		
		
		
	}
	
	@Test
	public void conformanceTest02(){
		System.out.println("==================== conformanceTest02 =========================");

		StateMachine sm;
		PersistenceStateMachine.loadStateMachine("ccoinbox.xml");
		sm = StateMachine.getInstance();
		CCoinBox ccb = new CCoinBox();
		
		//start, empty, empty, 
		System.out.println("ccb.getStateFullName() : " + ccb.getStateFullName());
		System.out.println("ccb.returnQtrs()");
		ccb.returnQtrs();
		System.out.println("ccb.getState() : " + ccb.getState());
		ccb.addQtr();
		System.out.println("ccb.getState()  after add : " + ccb.getState());

		
		
		
	}

//	public static void main(String[] agrs) throws IOException {
//		PersistenceStateMachine.loadStateMachine("ccoinbox.xml");
//		HashMap<String, Node> map = new HashMap<String, Node>();
//		StateMachine sm = StateMachine.getInstance();
//		ArrayList<Node> fullTree = new ArrayList<Node>();
//		State currentState = sm.getStartState();
//		Node rootNode = new Node(currentState, null, null);
//		LinkedList<Transition> transitions = new LinkedList<Transition>();
//		for (int i = 0; i < sm.getTransitions().size(); i++) {
//			transitions.add(sm.getTransition(i));
//		}
//		Node previousNode = rootNode;
//		fullTree.add(0, rootNode);
//		map.put(rootNode.state.getName(), rootNode);
//		while (transitions.isEmpty() == false) {
//			Transition currentTransition = transitions.poll();
//			currentState = currentTransition.getFrom();
//			previousNode = map.get(currentState.getName());
//			Node nextNode = new Node(currentTransition.getTo(), currentTransition, null);
//			if (!map.containsKey(currentTransition.getTo().getName())) {
//				map.put(currentTransition.getTo().getName(), nextNode);
//			}
//			previousNode.addChild(nextNode);
//			fullTree.add(nextNode);
//		}
//		System.out.println("hello");
//	}
}
