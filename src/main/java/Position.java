import static util.PositionValues.*;

import java.util.Objects;

public class Position implements Comparable<Position> {
	private int position;

	public Position() {
		this.position = INITIAL_POSITION;
	}

	public void goForward() {
		position++;
	}

	public void goBackward() {
		position--;
	}

	public int getPosition() {
		return position;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < position; i++) {
			sb.append(POSITION_STRING);
		}

		return sb.toString();
	}

	@Override
	public int compareTo(Position comparePosition) {
		return position < comparePosition.getPosition() ? 1 : (position == comparePosition.getPosition()) ? 0 : -1;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Position position1 = (Position)o;
		return position == position1.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}
}
