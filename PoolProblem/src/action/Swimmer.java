package action;


import resource.BasketResource;
import resource.BasketPool;
import resource.CubicleResource;
import resource.CubiclePool;
import resource.ResourcefulUser;

/**
 * Class Swimmer from package action
 * It represent a swimmer and all of his action.
 * @author Guyot Clement - Cornaire Francis
 * Licence 3 Miage - 2015/2016
 */
public class Swimmer extends SequentialScheduler {
	//Attributes
	protected ResourcefulUser<BasketResource> basketRes;
	protected ResourcefulUser<CubicleResource> cubicleRes;
	
	//Constructor
	
	/**
	 * The Constructor create a swimmer, a swimmer is a sequential scheduler of the actions a swimmer has to do.
	 * @param name - The name of the swimmer.
	 * @param baskets - The baskets the swimmer has to take.
	 * @param cubicles - The cubicles the swimmer has to take.
	 * @param nbUndress - The number of step the swimmer need to do to realise to undress.
	 * @param nbSwim - The number of step the swimmer need to do to swim.
	 * @param nbDress - The number of step the swimmer need to do to dress.
	 */
	public Swimmer(String name,BasketPool baskets,CubiclePool cubicles,int nbUndress,int nbSwim,int nbDress) {
		basketRes = new ResourcefulUser<BasketResource>(name);
		cubicleRes = new ResourcefulUser<CubicleResource>(name);
		this.addAction(new TakeResourceAction<BasketResource>(basketRes,baskets));
		this.addAction(new TakeResourceAction<CubicleResource>(cubicleRes,cubicles));
		this.addAction(new ForeseebleAction(nbUndress,"undress",name));
		this.addAction(new FreeResourceAction<CubicleResource>(cubicleRes,cubicles));
		this.addAction(new ForeseebleAction(nbSwim,"swimming",name));
		this.addAction(new TakeResourceAction<CubicleResource>(cubicleRes,cubicles));
		this.addAction(new ForeseebleAction(nbDress,"dressing",name));
		this.addAction(new FreeResourceAction<CubicleResource>(cubicleRes,cubicles));
		this.addAction(new FreeResourceAction<BasketResource>(basketRes,baskets));
	}
	
	public String getName() {
		return this.basketRes.getName();
	}

}
