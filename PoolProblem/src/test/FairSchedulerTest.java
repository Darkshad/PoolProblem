package test;

/**
 * Class FairSchedulerTest from the package test
 * This class is in charge of the test of the class FairScheduler
 * @author Cornaire Francis - Guyot Clement
 * Licence 3 Miage - 2015/2016
 */

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

	
	
}
