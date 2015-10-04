package ca.mcgill.ecse429.conformancetest.ccoinbox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.w3c.dom.*;
import static org.junit.Assert.*;
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

public class GeneratedTestFile {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		PersistenceStateMachine.loadStateMachine("ccoinbox.xml");
		StateMachine sm;
	}

	@After
	public void tearDown() throws Exception {
		StateMachine.getInstance().delete();
	}

	@Test
	public void conformanceTest01() {
		System.out.println("==================== conformanceTest01 =========================");
		StateMachine sm;
		sm = StateMachine.getInstance();
		CCoinBox ccb = new CCoinBox();
		// constructor initial state
		System.out.println("ccb.getState().name() : " + ccb.getState().name());
		assertTrue(ccb.getState().name(), ccb.getState().name().equals("empty"));
	}

	@Test
	public void conformanceTest02() {
		System.out.println("==================== conformanceTest02 =========================");
		StateMachine sm;
		sm = StateMachine.getInstance();
		CCoinBox ccb = new CCoinBox();
		// start, empty, empty,
		System.out.println("ccb.getStateFullName() : " + ccb.getStateFullName());
		System.out.println("ccb.returnQtrs()");
		ccb.returnQtrs();
		System.out.println("ccb.getState() : " + ccb.getState());
		ccb.addQtr();
		System.out.println("ccb.getState()  after add : " + ccb.getState());
	}
}
