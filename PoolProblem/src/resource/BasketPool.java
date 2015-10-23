package resource;

public class BasketPool extends ResourcePool<BasketResource>{
	public BasketPool(int n) {
		super(n);
	}

	@Override
	protected BasketResource createResource() {
		return new BasketResource();
	}

	@Override
	public String getName() {
		BasketResource b = new BasketResource();
		return b.description();
	}

}
