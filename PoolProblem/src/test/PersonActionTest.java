package test;

import static org.junit.Assert.*;

import org.junit.Test;

import action.PersonAction;

public abstract class PersonActionTest {

	protected abstract PersonAction createPersonAction();
	
	@Test
	public void personActionWithoutSchedulerTest() {
		PersonAction person = createPersonAction();
		assertTrue(person.isReady());
		assertFalse(person.isFinished());
		while(!person.isFinished()) {
			person.reallyDoStep();
		}
		assertFalse(person.isReady());
		assertTrue(person.isFinished());
	}

	
}
