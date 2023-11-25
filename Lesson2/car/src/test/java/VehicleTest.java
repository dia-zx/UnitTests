import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import project.Car;
import project.Motorcycle;
import project.Vehicle;

public class VehicleTest {

    @Test
    @DisplayName("проверка что экземпляр объекта Car также является экземпляром Vehicle")
    public void carDerVehicleTest() {
        Car car = new Car("Noname", "TestModel", 2023);
        assertTrue(car instanceof Vehicle);
    }

    @Test
    @DisplayName("проверка что объект Car создается с 4-мя колесами")
    public void carHas4WheelsTest() {
        Car car = new Car("Noname", "TestModel", 2023);
        assertEquals(4, car.getNumWheels());
    }

    @Test
    @DisplayName("проверка что объект Motorcycle создается с 2-мя колесами")
    public void motorcycleHas2WheelsTest() {
        Motorcycle motorcycle = new Motorcycle("Noname", "TestModel", 2023);
        assertEquals(2, motorcycle.getNumWheels());
    }

    @Test
    @DisplayName("проверка что объект Car развивает скорость 60 в режиме testDrive()")
    public void carSpeedTestDriveTest() {
        Car car = new Car("Noname", "TestModel", 2023);
        car.testDrive();
        assertEquals(60, car.getSpeed());
    }

    @Test
    @DisplayName("проверка что объект Motorcycle развивает скорость 75 в режиме testDrive()")
    public void motorcycleSpeedTestDriveTest() {
        Motorcycle motorcycle = new Motorcycle("Noname", "TestModel", 2023);
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed());
    }

    @Test
    @DisplayName("проверка что в режиме парковки машина останавливается в режиме парковки")
    public void carParkSpeedTest() {
        Car car = new Car("Noname", "TestModel", 2023);
        car.testDrive();
        assertTrue(car.getSpeed() > 0); // убедимся что машина едет
        car.park();
        assertTrue(car.getSpeed() == 0); // убедимся что машина остановилась
    }

    @Test
    @DisplayName("проверка что в режиме парковки мотоцикл останавливается в режиме парковки")
    public void motorcycleParkSpeedTest() {
        Motorcycle motorcycle = new Motorcycle("Noname", "TestModel", 2023);
        motorcycle.testDrive();
        assertTrue(motorcycle.getSpeed() > 0); // убедимся что мотоцикл едет
        motorcycle.park();
        assertTrue(motorcycle.getSpeed() == 0); // убедимся что мотоцикл остановился
    }    

}
