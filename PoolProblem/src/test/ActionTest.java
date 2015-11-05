package test;
import action.*;
import static org.junit.Assert.*;

import org.junit.Test;

import exception.ActionFinishedException;

/**
 * Class ActionTest from the package test
 * This class is in charge of the test of the class Action
 * @author Cornaire Francis - Guyot Clement
 * Licence 3 Miage - 2015/2016
 */

public abstract class ActionTest {

	public abstract Action createAction();
	
	@Test
	public void onlyOneValidStateAtEachMoment() throws ActionFinishedException { 
			Action action1 = createAction();
			assertTrue(action1.isReady());
			assertFalse(action1.isInProgress());
			assertFalse(action1.isFinished());
			while (!(action1.isFinished())){
				action1.doStep();
				assertFalse(action1.isReady());
				if(!action1.isFinished())
					assertTrue(action1.isInProgress());
			}
			assertFalse(action1.isReady());
			assertFalse(action1.isInProgress());
			assertTrue(action1.isFinished());
	}
	
	@Test
	public void actionFinished() throws ActionFinishedException {
		Action action1 = createAction();
		while (!(action1.isFinished())){
			action1.doStep();
		}
		try {
			action1.doStep();
		} catch (ActionFinishedException e) { //Action is finished here,we just checking if it's caught

		}
	}
}
