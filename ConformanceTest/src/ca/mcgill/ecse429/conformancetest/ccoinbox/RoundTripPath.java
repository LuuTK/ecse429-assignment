package ca.mcgill.ecse429.conformancetest.ccoinbox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.w3c.dom.*;

import ca.mcgill.ecse429.conformancetest.statemodel.State;
import ca.mcgill.ecse429.conformancetest.statemodel.StateMachine;
import ca.mcgill.ecse429.conformancetest.statemodel.Transition;
import ca.mcgill.ecse429.conformancetest.statemodel.persistence.PersistenceStateMachine;
import tuantests.Node;

public class RoundTripPath {
	

	
	public static void main(String[] agrs) throws IOException{
		PersistenceStateMachine.loadStateMachine("ccoinbox.xml");
		StateMachine sm = StateMachine.getInstance();
		ArrayList<Node> fullTree = new ArrayList<Node>();
		State currentState = sm.getStartState();
		Node rootNode = new Node(currentState, null, new ArrayList<Node>());
		
		int indexStart = sm.indexOfState(currentState);
		Transition startTrans = sm.getTransition(indexStart);
		
		LinkedList<Transition> transitions = new LinkedList<Transition>(); 
		for(int i = 0; i < sm.getTransitions().size(); i++){
			transitions.add(sm.getTransition(i));
		}
		while(transitions.isEmpty() == false){
			
			Transition currentTransition = transitions.poll();
			currentState = currentTransition.getFrom();
		
			//Node currentNode = new Node(currentState, );
			
			
			//Node root = new Node(startState);
		    //root.addChild(new Node("child1"));
		   // root.addChild(new Node("child2")); //etc.
			
			//System.out.println("transitions");
			//System.out.println(sm.getTransition(i).getEvent());
			//System.out.println(sm.getTransition(0));
			//System.out.println("gennnn"+ sm.getState(0) + "stateeeeeeeeee");
		}
		
	}

}


/*import org.w3c.dom.*;
import java.util.*;

public class StackTraversal implements ITraversal {

  *//**
   * Performs full tree traversal using stack.
   *//*
  public void traverse( Node rootNode ) {

    Stack stack = new Stack();
    // ignore root -- root acts as a container
    Node node=rootNode.getFirstChild();

    while (node!=null) {
      // print node information
      System.out.println( node.getNodeName()+"="+node.getNodeValue());

      if ( node.hasChildNodes()) {
        // store next sibling in the stack. We return to it after all children are
        processed.
        if (node.getNextSibling()!=null)
          stack.push( node.getNextSibling() );
        node = node.getFirstChild();
      }
      else {
        node = node.getNextSibling();
        if (node==null && !stack.isEmpty())
          // return to the parent's level.
          // note that some levels can be skipped if the parent's node was the last one.
          node=(Node) stack.pop();
      }
    }
  }
}
*/