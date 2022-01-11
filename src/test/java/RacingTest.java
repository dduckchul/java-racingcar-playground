import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingTest {
	Racing racing;
	Racers racers;

	@BeforeEach
	public void setUpRacing() {
		racing = new Racing(5);
		racers = new Racers("가,나,다,라,마");
	}

	@Test
	public void racingTest() {
		assertEquals(racing.getLoop(), 5);
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->{
			Racing racing2 = new Racing(0);
		});
	}

	@Test
	public void doRacingTest() {
		assertEquals(racers.getCarList().size(), 5);
		Car testCar = racers.getCarList().get(0);
		for(int i=0; i < racing.getLoop(); i++) {
			racing.doRace(testCar);
		}
		int positionNum = testCar.getPosition().getPosition();
		assertTrue(positionNum >= 0 && positionNum <= 5);
	}
}
