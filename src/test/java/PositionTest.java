import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PositionTest {
	Position position;

	@BeforeEach
	public void setUpPosition() {
		position = new Position();
	}

	@Test
	public void moveTest(){
		position.goBackward();
		position.goForward();
		position.goForward();
		assertEquals("-", position.toString());
		position.goForward();
		position.goForward();
		position.goForward();
		assertEquals("----", position.toString());
	}

}
