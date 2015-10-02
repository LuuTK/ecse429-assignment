package tuantests;

import java.util.ArrayList;
import java.util.List;

import ca.mcgill.ecse429.conformancetest.statemodel.State;

public class Node {
	String name;
	Boolean isParent;
	Node parent;
	List<Node> children;
	int value;
	String data;

	State state;

	public Node(String name) {
		this.name = name;
		children = new ArrayList<Node>();
	}

	public void treeInstert(Node parentNode, Node childrenNode) {
		parentNode.children.add(childrenNode);
		childrenNode.parent = parentNode;
	}

}
