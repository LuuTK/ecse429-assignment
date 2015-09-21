package ca.mcgill.ecse429.conformancetest.ccoinbox.test;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


import ca.mcgill.ecse429.*;
import ca.mcgill.ecse429.conformancetest.ccoinbox.CCoinBox;

public class TestCCoinBox {

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
		//fail("Not yet implemented");
		CCoinBox ccb = new CCoinBox();
		
		System.out.println("getStateFullName = " + ccb.getStateFullName());
		/* Testing if on creation, its state is empty */
		assertTrue(ccb.getStateFullName().equals("empty"));
		
		/* Testing if on creation, its curQtrs == 0 */
		System.out.println("getCurQtrs = " + ccb.getCurQtrs());
		assertEquals(0, ccb.getCurQtrs());
		
		/* Testing if on creation, its getTotalQtrs == 0 */
		System.out.println("getTotalQtrs = " + ccb.getTotalQtrs());
		assertEquals(0, ccb.getTotalQtrs());
		
		/* Testing if on creation, its isAllowVend == 0 */
		System.out.println("isAllowVend = " + ccb.isAllowVend());
		assertFalse(ccb.isAllowVend()); 
		
	}
	
	
}
