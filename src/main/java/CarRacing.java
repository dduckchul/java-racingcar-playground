import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

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
		List<Car> winnerList = getWinners(carList);

		StringJoiner joiner = new StringJoiner(",");
		for(Car car : winnerList){
			joiner.add(car.getName());
		}
		String winnerString = joiner.toString().concat(CarRacingValues.WINNER_ANNOUNCE_STRING);

		IoUtils.printMsg(winnerString);
	}

	public List<Car> getWinners(List<Car> carList){
		List<Car> winnerList = new ArrayList<>();
		Position firstPlacePosition = carList.get(0).getPosition();

		for (Car car : carList) {
			addWinner(car, firstPlacePosition, winnerList);
		}

		return winnerList;
	}

	public void addWinner(Car car, Position firstPlacePosition, List<Car> winnerList) {
		if (car.getPosition().getPosition() == firstPlacePosition.getPosition()) {
			winnerList.add(car);
		}
	}
}
