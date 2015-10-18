package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import resource.ResourcePool;
import resource.ResourcefulUser;
import action.ResourcePoolAction;
import action.TakeResourceAction;

public class TakeResourceActionTest extends ResourcePoolActionTest {
	@Override
	protected ResourcePoolAction<MockResource> createAction(ResourcePool<MockResource> pool, ResourcefulUser<MockResource> user) {
		return new TakeResourceAction<MockResource>(user,pool);
	}

	@Test
	public void TestWaitingTakeResource() {
		ResourcePoolAction<MockResource> r = this.createAction();
		ArrayList<MockResource> allResources = new ArrayList<MockResource>(this.n);
		for(int i = 0; i<n ; i++) 
			allResources.add(this.pool.provideResource());
		assertTrue(r.isReady());
		assertFalse(r.isInProgress());
		assertFalse(r.isFinished());
		
		r.doStep();
		assertFalse(r.isReady());
		assertTrue(r.isInProgress());
		assertFalse(r.isFinished());
		assertFalse(r.isReady());
		assertTrue(r.isInProgress());
		assertFalse(r.isFinished());
		
		pool.freeResource(allResources.get(0));
		r.doStep();
		assertFalse(r.isReady());
		assertFalse(r.isInProgress());
		assertTrue(r.isFinished());
		}

}
