package test;

import action.Action;
import action.ForeseebleAction;

/**
 * Class ForeseebleActionTest from the package test
 * This class is in charge of the test of the class ForeseebleAction
 * @author Cornaire Francis - Guyot Clement
 * Licence 3 Miage - 2015/2016
 */

public class ForeseebleActionTest extends ActionTest {
	
	@Override
	public Action createAction() {
		return new ForeseebleAction(5,"test","");
	}

}
