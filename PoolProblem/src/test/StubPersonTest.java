package test;

import action.PersonAction;

public class StubPersonTest extends PersonActionTest{

	@Override
	protected PersonAction createPersonAction() {
		return new StubPerson();
	}

}
