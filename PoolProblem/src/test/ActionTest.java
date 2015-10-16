package test;
import action.*;

import static org.junit.Assert.*;

import org.junit.Test;

public abstract class ActionTest {

	public abstract Action createAction();
	
	@Test
	public void onlyOneValidStateAtEachMoment() {
			Action action1 = createAction();
			assertTrue(action1.isReady());
			assertFalse(action1.isInProgress());
			assertFalse(action1.isFinished());
			while (!(action1.isFinished())){
				action1.doStep();
				assertFalse(action1.isReady());
				assertTrue(action1.isInProgress());
			}
			assertFalse(action1.isReady());
			assertFalse(action1.isInProgress());
			assertTrue(action1.isFinished());
	}
}
