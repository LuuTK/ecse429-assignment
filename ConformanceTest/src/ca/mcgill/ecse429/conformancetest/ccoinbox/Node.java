package ca.mcgill.ecse429.conformancetest.ccoinbox;

import java.util.ArrayList;
import java.util.List;

import ca.mcgill.ecse429.conformancetest.ccoinbox.RoundTripPath.Node;
import ca.mcgill.ecse429.conformancetest.statemodel.State;
import ca.mcgill.ecse429.conformancetest.statemodel.Transition;

public class Node {
	private State name;
	private Boolean isParent;
	private Node parent;
	private List<Node> children;
	private int value;
	private State state;
	private Transition prevTrans;

	public Node(State state, Transition prevTrans, ArrayList<Node> children) {
		this.state = state;
		this.prevTrans = prevTrans;
		children = new ArrayList<Node>();
	}

	public void treeInstert(Node parentNode, Node childrenNode) {
		parentNode.children.add(childrenNode);
		childrenNode.parent = parentNode;
	}

}
