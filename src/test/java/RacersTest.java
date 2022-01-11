import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacersTest {
	Racers racers;

	@BeforeEach
	public void setUpRacers(){
		racers = new Racers("a,b,c");
	}

	@Test
	public void racersTest(){
		assertThat(racers.getCarList().size() == 3).isTrue();
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			Racers racers2 = new Racers("");
		});
		List<Car> carList = Lists.newArrayList();
		Racers racers3 = new Racers(carList);
		assertThat(racers3.getCarList().size() == 0).isTrue();
	}

}
