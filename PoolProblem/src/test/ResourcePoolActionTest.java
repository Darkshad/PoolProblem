package test;

import action.ResourcePoolAction;

import resource.ResourcePool;
import resource.ResourcefulUser;

public abstract class ResourcePoolActionTest extends ActionTest{

	int n = 2;
	MockResourcePool pool = new MockResourcePool(n);
	ResourcefulUser<MockResource> user = new ResourcefulUser<MockResource>();
	
	public ResourcePoolAction<MockResource> createAction() {
		return createAction(pool,user);
	}
	
	protected abstract ResourcePoolAction<MockResource> createAction(ResourcePool<MockResource> pool,ResourcefulUser<MockResource>user);

}
