package test;

import static org.junit.Assert.*;
import action.Scheduler;
import action.Action;

import org.junit.Test;

import exception.ActionFinishedException;

public abstract class TestScheduler extends ActionTest{

	public abstract Scheduler createScheduler(Action action1);
	
	@Test
	public void SchedulerTestWithOneStepAction() throws ActionFinishedException {
		OneStepAction action1 = new OneStepAction();
		Scheduler sc = createScheduler(action1);
		
		assertFalse(sc.isFinished());
		assertFalse(action1.isFinished());
		
		sc.doStep();
		
		assertTrue(sc.isFinished());
		assertTrue(action1.isFinished());
	}
	
	public void SchedulerTestWithScheduler() throws ActionFinishedException{
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