package test;

import java.util.NoSuchElementException;

import org.junit.Test;

import action.ResourcePoolAction;
import resource.ResourcePool;
import resource.ResourcefulUser;

/**
 * Class ResourcePoolActionTest from the package test
 * This class is in charge of the test of the class ResourcePoolAction
 * @author Cornaire Francis - Guyot Clement
 * Licence 3 Miage - 2015/2016
 */

public abstract class ResourcePoolActionTest extends ActionTest{

	int n = 2;
	MockResourcePool pool = new MockResourcePool(n);
	ResourcefulUser<MockResource> user = new ResourcefulUser<MockResource>("mock");
	
	public ResourcePoolAction<MockResource> createAction() {
		return createAction(pool,user);
	}
	
	protected abstract ResourcePoolAction<MockResource> createAction(ResourcePool<MockResource> pool,ResourcefulUser<MockResource>user);
	
	@Test
	public void noResourceTest() { //testing exception if no resource to provide
		try {
			while(true)
				pool.provideResource();
		}
		catch (NoSuchElementException e) { //checking the exception if there is no resource 
			
		}
	}
	
	@Test
	public void freeBadResourceTest() { //testing exception if freeing a resource not used
		try {
			MockResource m = new MockResource();
			pool.freeResource(m);
		}
		catch (IllegalArgumentException e) { // checking the exception if we are freeing a resource not used
			
		}
	}
}
