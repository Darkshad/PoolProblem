package resource;

public class ResourcefulUser<R extends Resource> {
	//Attribute
	protected R resource;
	protected String name;
	
	//Constructor
	public ResourcefulUser(String name) {
		this.name = name;
	}
	
	//Methods
	public String getName() {
		return this.name;
	}
	
	public R getResource() {
		return this.resource;
	}

	public void setResource(R resource) {
		this.resource = resource;
	}
	
	public void resetResource() {
		this.resource = null;
	}
}
