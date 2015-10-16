package test;
import test.MockResource; 
import resource.ResourcePool;

public class MockResourcePool extends ResourcePool<MockResource> {

	public MockResourcePool(int nbResource) {
		super(nbResource);
	}
	protected MockResource createResource() {
		return new MockResource();
	}

}
