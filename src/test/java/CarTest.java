import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
    Car car;

    @BeforeEach
    public void setUpCar() {
        car = new Car("TestCar");
    }

    @Test
    public void carProduceTest() {
        Car car = new Car("TestCar");
        assertEquals("TestCar : ", car.toString());
    }

    @Test
    public void carMoveTest() {
        car.move();
        assertEquals("TestCar : -", car.toString());
        car.move();
        assertEquals("TestCar : --", car.toString());
    }
}
