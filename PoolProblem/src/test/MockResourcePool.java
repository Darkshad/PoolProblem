package test;
import test.MockResource; 
import resource.ResourcePool;

/**
 * Class MockResourcePool from the package test
 * A Mock pool used for test
 * @author Cornaire Francis - Guyot Clement
 * Licence 3 Miage - 2015/2016
 */

public class MockResourcePool extends ResourcePool<MockResource> {

	public MockResourcePool(int nbResource) {
		super(nbResource);
	}
	protected MockResource createResource() {
		return new MockResource();
	}
	@Override
	public String getName() {
		MockResource m = new MockResource();
		return m.description();
	}

}
