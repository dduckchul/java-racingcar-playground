import java.util.Collections;
import java.util.List;

import util.CarRacingValues;
import util.IoUtils;

public class CarRacing {
	private Racers racers;
	private Racing racing;

	public void hostCarRacing() {
		IoUtils.printMsg(CarRacingValues.INPUT_CAR_MSG);
		String racerString = IoUtils.inputString();
		racers = new Racers(racerString);

		IoUtils.printMsg(CarRacingValues.INPUT_LOOP_MSG);
		int loops = IoUtils.inputNumbers();
		racing = new Racing(loops);
		IoUtils.printMsg("");
	}

	public void doCarRacing() {
		IoUtils.printMsg(CarRacingValues.START_CAR_RACING);
		List<Car> carList = racers.getCarList();
		for (int i = 0; i < racing.getLoop(); i++) {
			driveLoop(carList);
			IoUtils.printMsg("");
		}
	}

	public void driveLoop(List<Car> carList) {
		for (Car car : carList) {
			racing.doRace(car);
			IoUtils.printMsg(car.toString());
		}
	}

	public void announceWinner() {
		List<Car> carList = racers.getCarList();
		Collections.sort(carList);

		Position firstPlacePosition = carList.get(0).getPosition();
		StringBuffer sb = new StringBuffer();
		for (Car car : carList) {
			sb.append(getWinnerName(car, firstPlacePosition));
		}
		sb.append(CarRacingValues.WINNER_ANNOUNCE_STRING);

		IoUtils.printMsg(sb.toString());
	}

	public String getWinnerName(Car car, Position firstPlacePosition) {
		if (car.getPosition().getPosition() == firstPlacePosition.getPosition()) {
			return car.getName() + ",";
		}
		return "";
	}
}
