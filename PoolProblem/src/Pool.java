import exception.ActionFinishedException;
import action.FairScheduler;
import action.Swimmer;
import resource.BasketPool;
import resource.CubiclePool;

/**
 * Class Pool from
 * The main class,simulates the pool problem
 * @author Cornaire Francis - Guyot Clement
 * Licence 3 Miage - 2015/2016
 */

public class Pool {

	public static void main(String[] args) throws ActionFinishedException {
		BasketPool baskets = new BasketPool(6);
		CubiclePool cubicles = new CubiclePool(3);
		FairScheduler s = new FairScheduler();
		
		s.addAction(new Swimmer("Camille",baskets,cubicles,6,4,8));
		s.addAction(new Swimmer("Lois",baskets,cubicles,2,10,4));
		s.addAction(new Swimmer("Mae",baskets,cubicles,10,18,10));
		s.addAction(new Swimmer("Ange",baskets,cubicles,3,7,5));
		s.addAction(new Swimmer("Louison",baskets,cubicles,18,3,3));
		s.addAction(new Swimmer("Charlie",baskets,cubicles,3,6,10));
		s.addAction(new Swimmer("Alexis",baskets,cubicles,6,5,7));
		
		int nbSteps = 0;
		while(!s.isFinished()) {
			nbSteps++;
			s.doStep();
		}
		System.out.println("Finished in " + nbSteps + " steps");
	}

}
