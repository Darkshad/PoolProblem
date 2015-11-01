package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import exception.ActionFinishedException;
import resource.ResourcePool;
import resource.ResourcefulUser;
import action.FreeResourceAction;
import action.ResourcePoolAction;

public class TestFreeResourceActionTest extends ResourcePoolActionTest{

	@Override
	protected ResourcePoolAction<MockResource> createAction(ResourcePool<MockResource> pool, ResourcefulUser<MockResource> user) {
		FreeResourceAction<MockResource> tmp = new FreeResourceAction<MockResource>(user,pool);
		user.setResource(pool.provideResource());
		return tmp;
	}

	@Test
	public void testFreeResourceAction() throws ActionFinishedException {
		ResourcePoolAction<MockResource> r = createAction();
		assertTrue(r.isReady());
		assertFalse(r.isInProgress());
		assertFalse(r.isFinished());
		r.doStep();
		assertFalse(r.isReady());
		assertFalse(r.isInProgress());
		assertTrue(r.isFinished());
		assertEquals(user.getResource(),null);
	}
	
}
