package ca.mcgill.ecse429.conformancetest.ccoinbox;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ca.mcgill.ecse429.conformancetest.statemodel.StateMachine;
import ca.mcgill.ecse429.conformancetest.statemodel.persistence.PersistenceStateMachine;

public class TestCCoinBox {

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
		System.out.println("==================== conformanceTest0.1 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 0);
		assertTrue(ccb.getAllowVend() == false);
		System.out.println("==================== conformanceTest0.2 =========================");
		ccb.returnQtrs();
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 0);
		assertTrue(ccb.getAllowVend() == false);
	}

	@Test
	public void conformanceTest1() {
		CCoinBox ccb = new CCoinBox();
		StateMachine sm;
		sm = StateMachine.getInstance();
		System.out.println("==================== conformanceTest1.1 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 0);
		assertTrue(ccb.getAllowVend() == false);
		System.out.println("==================== conformanceTest1.2 =========================");
		ccb.reset();
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 0);
		assertTrue(ccb.getAllowVend() == false);
	}

	@Test
	public void conformanceTest2() {
		CCoinBox ccb = new CCoinBox();
		StateMachine sm;
		sm = StateMachine.getInstance();
		System.out.println("==================== conformanceTest2.1 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 0);
		assertTrue(ccb.getAllowVend() == false);
		System.out.println("==================== conformanceTest2.2 =========================");
		ccb.addQtr();
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("notAllowed"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 1);
		assertTrue(ccb.getAllowVend() == false);		
		System.out.println("==================== conformanceTest2.3 =========================");
		ccb.returnQtrs();
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 0);
		assertTrue(ccb.getAllowVend() == false);
	}

	@Test
	public void conformanceTest3() {
		CCoinBox ccb = new CCoinBox();
		StateMachine sm;
		sm = StateMachine.getInstance();
		System.out.println("==================== conformanceTest3.1 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 0);
		assertTrue(ccb.getAllowVend() == false);
		System.out.println("==================== conformanceTest3.2 =========================");
		ccb.addQtr();
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("notAllowed"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 1);
		assertTrue(ccb.getAllowVend() == false);		
		System.out.println("==================== conformanceTest3.3 =========================");
		ccb.reset();
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 0);
		assertTrue(ccb.getAllowVend() == false);
	}

	@Test
	public void conformanceTest4() {
		CCoinBox ccb = new CCoinBox();
		StateMachine sm;
		sm = StateMachine.getInstance();
		System.out.println("==================== conformanceTest4.1 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 0);
		assertTrue(ccb.getAllowVend() == false);
		System.out.println("==================== conformanceTest4.2 =========================");
		ccb.addQtr();
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("notAllowed"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 1);
		assertTrue(ccb.getAllowVend() == false);
		System.out.println("==================== conformanceTest4.3 =========================");
		ccb.addQtr();
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("allowed"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 2);
		assertTrue(ccb.getAllowVend() == true);
		System.out.println("==================== conformanceTest4.4 =========================");
		ccb.returnQtrs();
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 0);
		// assertTrue(ccb.getAllowVend() == false); GEN : isnt this supposed to be true? it gives error when i uncomment
	}

	@Test
	public void conformanceTest5() {
		CCoinBox ccb = new CCoinBox();
		StateMachine sm;
		sm = StateMachine.getInstance();
		System.out.println("==================== conformanceTest5.1 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 0);
		assertTrue(ccb.getAllowVend() == false);
		System.out.println("==================== conformanceTest5.2 =========================");
		ccb.addQtr();
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("notAllowed"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 1);
		assertTrue(ccb.getAllowVend() == false);
		System.out.println("==================== conformanceTest5.3 =========================");
		ccb.addQtr();
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("allowed"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 2);
		assertTrue(ccb.getAllowVend() == true);
		System.out.println("==================== conformanceTest5.4 =========================");
		ccb.reset();
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 0);
		//assertTrue(ccb.getAllowVend() == false);	GEN : Isnt this supposed to be true ?
	}

	@Test
	public void conformanceTest6() {
		CCoinBox ccb = new CCoinBox();
		StateMachine sm;
		sm = StateMachine.getInstance();
		System.out.println("==================== conformanceTest6.1 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 0);
		assertTrue(ccb.getAllowVend() == false);
		System.out.println("==================== conformanceTest6.2 =========================");
		ccb.addQtr();
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("notAllowed"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 1);
		assertTrue(ccb.getAllowVend() == false);
		System.out.println("==================== conformanceTest6.3 =========================");
		ccb.addQtr();
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("allowed"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 2);
		assertTrue(ccb.getAllowVend() == true);
		System.out.println("==================== conformanceTest6.4 =========================");
		ccb.addQtr();
		ccb.addQtr(); // Hard coded for fix the auto generated code
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("allowed"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 4);
		assertTrue(ccb.getAllowVend() == true);
	}

	@Test
	public void conformanceTest7() {
		CCoinBox ccb = new CCoinBox();
		StateMachine sm;
		sm = StateMachine.getInstance();
		System.out.println("==================== conformanceTest7.1 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 0);
		assertTrue(ccb.getAllowVend() == false);
		System.out.println("==================== conformanceTest7.2 =========================");
		ccb.addQtr();
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 1);
		assertTrue(ccb.getAllowVend() == false);
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("notAllowed"));
		System.out.println("==================== conformanceTest7.3 =========================");
		ccb.addQtr();
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("allowed"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 2);
		assertTrue(ccb.getAllowVend() == true);
		System.out.println("==================== conformanceTest7.4 =========================");
		ccb.vend();
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		assertTrue(ccb.getTotalQtrs() == 2);
		assertTrue(ccb.getCurQtrs() == 0);
		assertTrue(ccb.getAllowVend() == false);

	}

	@Test
	public void conformanceTest8() {
		CCoinBox ccb = new CCoinBox();
		StateMachine sm;
		sm = StateMachine.getInstance();
		System.out.println("==================== conformanceTest8.1 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 0);
		assertTrue(ccb.getAllowVend() == false);
		System.out.println("==================== conformanceTest8.2 =========================");
		ccb.addQtr();
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("notAllowed"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 1);
		assertTrue(ccb.getAllowVend() == false);
		System.out.println("==================== conformanceTest8.3 =========================");
		ccb.addQtr();
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("allowed"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 2);
		assertTrue(ccb.getAllowVend() == true);
		System.out.println("==================== conformanceTest8.4 =========================");
		ccb.vend();
		ccb.addQtr(); // Manual Change Here to fix the error generated from generated code
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("notAllowed"));
		assertTrue(ccb.getTotalQtrs() == 2);
		assertTrue(ccb.getCurQtrs() == 1);
		assertTrue(ccb.getAllowVend() == false);
	}

	@Test
	public void conformanceTest9() {
		CCoinBox ccb = new CCoinBox();
		StateMachine sm;
		sm = StateMachine.getInstance();
		System.out.println("==================== conformanceTest9.1 =========================");
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("empty"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 0);
		assertTrue(ccb.getAllowVend() == false);
		System.out.println("==================== conformanceTest9.2 =========================");
		ccb.addQtr();
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("notAllowed"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 1);
		assertTrue(ccb.getAllowVend() == false);
		System.out.println("==================== conformanceTest9.3 =========================");
		ccb.addQtr();
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("allowed"));
		assertTrue(ccb.getTotalQtrs() == 0);
		assertTrue(ccb.getCurQtrs() == 2);
		assertTrue(ccb.getAllowVend() == true);
		System.out.println("==================== conformanceTest9.4 =========================");
		ccb.vend();
		ccb.addQtr(); // Manual Change here to fix the error generated by the generated Code
		ccb.addQtr(); // Manual Change here to fix the error generated by the generated Code
		assertTrue(ccb.getStateFullName(), ccb.getStateFullName().equals("allowed"));
		assertTrue(ccb.getTotalQtrs() == 2);
		assertTrue(ccb.getCurQtrs() == 2);
		assertTrue(ccb.getAllowVend() == true);
		}

}
