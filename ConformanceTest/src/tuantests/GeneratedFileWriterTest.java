package tuantests;
import ca.mcgill.ecse429.conformancetest.statemodel.StateMachine;
import ca.mcgill.ecse429.conformancetest.statemodel.persistence.PersistenceStateMachine;
import ca.mcgill.ecse429.conformancetest.ccoinbox.CCoinBox;
public class GeneratedFileWriterTest{
public static void main(String[] args) {
System.out.println("In Main Class ");
PersistenceStateMachine.loadStateMachine("ccoinbox.xml");
StateMachine sm = StateMachine.getInstance();
		String CCoinBoxString = sm.getClassName().substring(0, sm.getClassName().length()-5);
		System.out.println(CCoinBoxString);
CCoinBox test = new CCoinBox();
System.out.println(test.getCurQtrs());
}
}
