package ca.mcgill.ecse429.conformancetest.ccoinbox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

	}

}
