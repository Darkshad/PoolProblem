package resource;

/**
 * Class ResourcefulUser from the package resource
 * This class represent an user with a resource 
 * @author Cornaire Francis - Guyot Clement
 * Licence 3 Miage - 2015/2016
 */

public class ResourcefulUser<R extends Resource> {
	//Attribute
	protected R resource;
	protected String name;
	
	//Constructor
	public ResourcefulUser(String name) {
		this.name = name;
	}
	
	//Methods
	
	/**
	 * This method permit to know the name of the resource.
	 * @return The name of the resource.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * This method permit to get the resource.
	 * @return the resource
	 */
	public R getResource() {
		return this.resource;
	}

	/**
	 * This method permit to change the resource.
	 * @param The new resource.
	 */
	public void setResource(R resource) {
		this.resource = resource;
	}
	
	/**
	 * This method permit to reset the resource.
	 */
	public void resetResource() {
		this.resource = null;
	}
}
