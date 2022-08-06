import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;
    Passenger passenger4;
    Passenger passenger5;

    @Before
    public void before(){
        passenger1 = new Passenger("Alice", 1);
        passenger2 = new Passenger("George", 2);
        passenger3 = new Passenger("Harry", 3);
        passenger4 = new Passenger("Ian", 4);
        passenger5 = new Passenger("Julian", 5);
    }

    @Test
    public void hasName(){
        assertEquals("Alice", passenger1.getName());
    }
    @Test
    public void canGetNumberOfBags(){
        assertEquals(1, passenger1.getNumberOfBags());
    }
}
