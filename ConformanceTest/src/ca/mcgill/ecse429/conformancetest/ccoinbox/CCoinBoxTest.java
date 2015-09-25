package ca.mcgill.ecse429.conformancetest.ccoinbox;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.mcgill.ecse429.conformancetest.statemodel.StateMachine;
import ca.mcgill.ecse429.conformancetest.statemodel.persistence.PersistenceStateMachine;

public class CCoinBoxTest {

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
	public void test() {
		
		StateMachine sm;
		
		PersistenceStateMachine.loadStateMachine("ccoinbox.xml");
		sm = StateMachine.getInstance();
		sm.setClassName(sm.getClassName());
		sm.setPackageName(sm.getPackageName());
		sm.setStartState(sm.getStartState());
		
		System.out.println(sm.getStates().get(0));
		System.out.println(sm.getStates().get(1));
		System.out.println(sm.getStates().get(2));
	
	}

}
