import static util.RacingValues.*;

import java.util.concurrent.ThreadLocalRandom;

import util.CarRacingValues;
import util.RacingValues;

public class Racing {
	private final int loop;

	public Racing(int loop) {
		validateRace(loop);
		this.loop = loop;
	}

	public void validateRace(int loop) {
		if (loop < MIN_LOOPS) {
			throw new IllegalArgumentException(CarRacingValues.RACING_EXCEPTION_MSG);
		}
	}

	public int getLoop() {
		return loop;
	}

	public void doRace(Car car) {
		int randomNum = ThreadLocalRandom.current().nextInt(RacingValues.MIN_RANDOM_INT, MAX_RANDOM_INT);
		if (randomNum >= MOVE_MIN_VALUE) {
			car.move();
		}
	}
}
