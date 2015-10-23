package test;

import static org.junit.Assert.*;

import org.junit.Test;

import action.Action;
import action.FairScheduler;
import action.Scheduler;

public class FairSchedulerTest extends TestScheduler {

	@Override
	public Scheduler createScheduler(Action action1) {
		FairScheduler sc = new FairScheduler();
		sc.addAction(action1);
		return sc;
	}

	@Override
	public Action createAction() {
		return new OneStepAction();
	}

	@Test
	public void testAddAction(){
		
	}
	
}
