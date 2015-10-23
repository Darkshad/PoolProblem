package test;

import action.Action;
import action.Scheduler;
import action.SequentialScheduler;

public class SequentialSchedulerTest extends TestScheduler {
	
	@Override
	public Scheduler createScheduler(Action action1) {
		SequentialScheduler seqSc = new SequentialScheduler();
		seqSc.addAction(action1);
		return seqSc;
	}

	@Override
	public Action createAction() {
		return new OneStepAction();
	}

}
