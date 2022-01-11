import java.util.Objects;

public class Car implements Comparable<Car> {
	private String name;
	private Position position;

	public Car(String name) {
		this.name = name;
		this.position = new Position();
	}

	public Position getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

	public void move() {
		position.goForward();
	}

	@Override
	public String toString() {
		return name + " : " + position.toString();
	}

	@Override
	public int compareTo(Car compareCar) {
		return position.compareTo(compareCar.position);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Car car = (Car)o;
		return Objects.equals(name, car.name) &&
			Objects.equals(position, car.position);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, position);
	}
}