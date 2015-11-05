package test;

import action.Action;
import action.Scheduler;
import action.SequentialScheduler;

/**
 * Class SequentialSchedulerTest from the package test
 * This class is in charge of the test of the class SequentialScheduler
 * @author Cornaire Francis - Guyot Clement
 * Licence 3 Miage - 2015/2016
 */

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
