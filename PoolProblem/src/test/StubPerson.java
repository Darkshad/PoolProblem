package test;


import resource.ResourcefulUser;
import action.ForeseebleAction;
import action.FreeResourceAction;
import action.PersonAction;
import action.TakeResourceAction;

public class StubPerson extends PersonAction {
	protected ResourcefulUser<MockResource> mockRes = new ResourcefulUser<MockResource>("person");
	protected MockResourcePool mock = new MockResourcePool(1);

	public StubPerson() {
		this.addAction(new FreeResourceAction<MockResource>(mockRes,mock));	
		this.addAction(new ForeseebleAction(3,"mocking"));
		this.addAction(new TakeResourceAction<MockResource>(mockRes,mock));
	}

}
