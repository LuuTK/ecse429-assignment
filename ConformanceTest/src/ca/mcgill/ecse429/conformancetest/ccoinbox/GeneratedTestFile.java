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
	public void conformanceTest0() {
		CCoinBox ccb = new CCoinBox();
		StateMachine sm;
		sm = StateMachine.getInstance();
		System.out.println("==================== conformanceTest0.0 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.returnQtrs();
		System.out.println("==================== conformanceTest0.1 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.returnQtrs();
		System.out.println("==================== conformanceTest0.2 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.returnQtrs();
	}

	@Test
	public void conformanceTest1() {
		CCoinBox ccb = new CCoinBox();
		StateMachine sm;
		sm = StateMachine.getInstance();
		System.out.println("==================== conformanceTest1.0 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.reset();
		System.out.println("==================== conformanceTest1.1 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.reset();
		System.out.println("==================== conformanceTest1.2 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.reset();
	}

	@Test
	public void conformanceTest2() {
		CCoinBox ccb = new CCoinBox();
		StateMachine sm;
		sm = StateMachine.getInstance();
		System.out.println("==================== conformanceTest2.0 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest2.1 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest2.2 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest2.3 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
	}

	@Test
	public void conformanceTest3() {
		CCoinBox ccb = new CCoinBox();
		StateMachine sm;
		sm = StateMachine.getInstance();
		System.out.println("==================== conformanceTest3.0 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest3.1 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest3.2 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest3.3 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
	}

	@Test
	public void conformanceTest4() {
		CCoinBox ccb = new CCoinBox();
		StateMachine sm;
		sm = StateMachine.getInstance();
		System.out.println("==================== conformanceTest4.0 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest4.1 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest4.2 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest4.3 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest4.4 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
	}

	@Test
	public void conformanceTest5() {
		CCoinBox ccb = new CCoinBox();
		StateMachine sm;
		sm = StateMachine.getInstance();
		System.out.println("==================== conformanceTest5.0 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest5.1 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest5.2 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest5.3 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest5.4 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
	}

	@Test
	public void conformanceTest6() {
		CCoinBox ccb = new CCoinBox();
		StateMachine sm;
		sm = StateMachine.getInstance();
		System.out.println("==================== conformanceTest6.0 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest6.1 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest6.2 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest6.3 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest6.4 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
	}

	@Test
	public void conformanceTest7() {
		CCoinBox ccb = new CCoinBox();
		StateMachine sm;
		sm = StateMachine.getInstance();
		System.out.println("==================== conformanceTest7.0 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest7.1 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest7.2 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest7.3 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest7.4 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
	}

	@Test
	public void conformanceTest8() {
		CCoinBox ccb = new CCoinBox();
		StateMachine sm;
		sm = StateMachine.getInstance();
		System.out.println("==================== conformanceTest8.0 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest8.1 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest8.2 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest8.3 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest8.4 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
	}

	@Test
	public void conformanceTest9() {
		CCoinBox ccb = new CCoinBox();
		StateMachine sm;
		sm = StateMachine.getInstance();
		System.out.println("==================== conformanceTest9.0 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest9.1 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest9.2 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest9.3 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
		System.out.println("==================== conformanceTest9.4 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		ccb.addQtr();
	}

}
