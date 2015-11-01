package test;

import action.Action;
import action.ForeseebleAction;

public class ForeseebleActionTest extends ActionTest {
	
	@Override
	public Action createAction() {
		return new ForeseebleAction(5,"test","");
	}

}
