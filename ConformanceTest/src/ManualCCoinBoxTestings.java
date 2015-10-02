import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ca.mcgill.ecse429.conformancetest.statemodel.State;
import ca.mcgill.ecse429.conformancetest.statemodel.StateMachine;
import ca.mcgill.ecse429.conformancetest.statemodel.persistence.PersistenceStateMachine;

public class ManualCCoinBoxTestings {

	private Node root;


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

	public static void main(String[] args) throws IOException {

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

		System.out.println(root.children.get(1).name);

	}
}
