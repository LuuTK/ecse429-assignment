package ca.mcgill.ecse429.conformancetest.ccoinbox;

import ca.mcgill.ecse429.conformancetest.statemodel.StateMachine;
import ca.mcgill.ecse429.conformancetest.statemodel.persistence.PersistenceStateMachine;

public class RoundTripPath {
	
	public static void main(String[] agrs){
		PersistenceStateMachine.loadStateMachine("ccoinbox.xml");
		StateMachine sm = StateMachine.getInstance();
		int i = 0;
		System.out.println(sm.getStates());
		while(sm.getTransitions().isEmpty() == false){
			System.out.println("transitions");
			System.out.println(sm.getTransition(i));
			i++;
		}
		
		
	}

}