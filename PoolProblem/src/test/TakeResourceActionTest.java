package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import exception.ActionFinishedException;
import resource.ResourcePool;
import resource.ResourcefulUser;
import action.ResourcePoolAction;
import action.TakeResourceAction;

/**
 * Class TakeResourceActionTest from the package test
 * This class is in charge of the test of the class TakeResourceAction
 * @author Cornaire Francis - Guyot Clement
 * Licence 3 Miage - 2015/2016
 */

public class TakeResourceActionTest extends ResourcePoolActionTest {
	@Override
	protected ResourcePoolAction<MockResource> createAction(ResourcePool<MockResource> pool, ResourcefulUser<MockResource> user) {
		return new TakeResourceAction<MockResource>(user,pool);
	}

	@Test
	public void TestWaitingTakeResource() throws ActionFinishedException { //testing if the action finish only when the pool finally take a resource
		ResourcePoolAction<MockResource> r = this.createAction();
		ArrayList<MockResource> allResources = new ArrayList<MockResource>(this.n);
		for(int i = 0; i<n ; i++) 
			allResources.add(this.pool.provideResource()); // here,all resource are provided
		assertTrue(r.isReady());
		assertFalse(r.isInProgress());
		assertFalse(r.isFinished());
		
		r.doStep(); // the action is still in progress because all resource are used
		assertFalse(r.isReady());
		assertTrue(r.isInProgress());
		assertFalse(r.isFinished());
		assertFalse(r.isReady());
		assertTrue(r.isInProgress());
		assertFalse(r.isFinished());
		
		pool.freeResource(allResources.get(0)); //one resource is free
		r.doStep(); // now the action can take the resource and finish
		assertFalse(r.isReady());
		assertFalse(r.isInProgress());
		assertTrue(r.isFinished());
		}

}
