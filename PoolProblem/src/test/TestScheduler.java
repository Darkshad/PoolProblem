package test;

import static org.junit.Assert.*;
import action.Scheduler;
import action.Action;

import org.junit.Test;

import exception.ActionFinishedException;

/**
 * Class TestScheduler from the package test
 * This class is in charge of the test of the class Scheduler
 * @author Cornaire Francis - Guyot Clement
 * Licence 3 Miage - 2015/2016
 */

public abstract class TestScheduler extends ActionTest{

	public abstract Scheduler createScheduler(Action action1);
	
	@Test
	public void SchedulerTestWithOneStepAction() throws ActionFinishedException { //testing if the scheduler finish the action in it
		OneStepAction action1 = new OneStepAction();
		Scheduler sc = createScheduler(action1);
		
		assertTrue(sc.isReady());
		assertFalse(sc.isInProgress());
		assertFalse(sc.isFinished());
		assertFalse(action1.isFinished());
		
		sc.doStep();
		
		assertFalse(sc.isReady());
		assertTrue(sc.isFinished());
		assertTrue(action1.isFinished());
		action1.getName();
	}
	
	@Test
	public void SchedulerTestWithScheduler() throws ActionFinishedException{ //testing if the scheduler finish the scheduler(with an action) in it
		Action action1 = createAction();
		Scheduler sc = createScheduler(action1);
		Scheduler sc2 = createScheduler(sc);
		
		assertFalse(sc.isFinished());
		assertFalse(sc2.isFinished());
		assertFalse(action1.isFinished());
		
		sc2.doStep();
		
		assertTrue(sc.isFinished());
		assertTrue(sc2.isFinished());
		assertTrue(action1.isFinished());		
		
	}
	
}