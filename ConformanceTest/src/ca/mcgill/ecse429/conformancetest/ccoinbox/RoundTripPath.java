package ca.mcgill.ecse429.conformancetest.ccoinbox;

import ca.mcgill.ecse429.conformancetest.statemodel.StateMachine;
import ca.mcgill.ecse429.conformancetest.statemodel.persistence.PersistenceStateMachine;

public class RoundTripPath {
	
	public static void main(String[] agrs){
		PersistenceStateMachine.loadStateMachine("ccoinbox.xml");
		StateMachine sm = StateMachine.getInstance();
		int i = 0;
		System.out.println(sm.getStates());
		
		// QUICKFIX : added in the while statement to avoid the error (out of bounds)
		while(sm.getTransitions().isEmpty() == false && i < 13){
			System.out.println("transitions");
			//System.out.println(sm.getTransition(i).getEvent());
			System.out.println(sm.getTransition(i));
			i++;
		}
		
		
	}

}