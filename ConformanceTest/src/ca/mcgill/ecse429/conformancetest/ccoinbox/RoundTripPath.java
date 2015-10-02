package ca.mcgill.ecse429.conformancetest.ccoinbox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ca.mcgill.ecse429.conformancetest.statemodel.State;
import ca.mcgill.ecse429.conformancetest.statemodel.StateMachine;
import ca.mcgill.ecse429.conformancetest.statemodel.persistence.PersistenceStateMachine;

public class RoundTripPath {
	
	private static class Node {
		private String name;
		private Boolean isParent;
		private Node parent;
		private List<Node> children;
		private int value;
		private String data;

		private State state;

		public Node(String name) {
			this.name = name;
			children = new ArrayList<Node>();
		}

		public void treeInstert(Node parentNode, Node childrenNode) {
			parentNode.children.add(childrenNode);
			childrenNode.parent = parentNode;
		}
	}
	
	public static void main(String[] agrs) throws IOException{
		PersistenceStateMachine.loadStateMachine("ccoinbox.xml");
		StateMachine sm = StateMachine.getInstance();
		int i = 0;
		System.out.println(sm.getStates());

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

		System.out.println(root.children.get(1).name);
		
		// QUICKFIX : added in the while statement to avoid the error (out of bounds)
		while(sm.getTransitions().isEmpty() == false && i < 13){
			System.out.println("transitions");
			//System.out.println(sm.getTransition(i).getEvent());
			System.out.println(sm.getTransition(i));
			i++;
		}
		
	}

}