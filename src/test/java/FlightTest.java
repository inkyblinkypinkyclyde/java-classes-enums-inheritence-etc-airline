import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {
    Flight flight1;
    Pilot pilot1;
    Pilot pilot2;
    FirstOfficer firstOfficer;
    Purser purser;
    FlightAttendant flightAttendant;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;
    Passenger passenger4;
    Passenger passenger5;
    Plane plane1;
    Plane plane2;
    Plane plane3;


    @Before
    public void beforeEach(){
        flight1 = new Flight("ABC123", Destinations.GLA, Destinations.EDI, "12:00");
        pilot1 = new Pilot("Bob", Rank.CAPTAIN, 123);
        pilot2 = new Pilot("Frank", Rank.CAPTAIN, 123);
        firstOfficer = new FirstOfficer("Charles", Rank.FIRSTOFFICER);
        purser = new Purser("Dominic", Rank.PURSER);
        flightAttendant = new FlightAttendant("Edward", Rank.FLIGHTATTENDANT);
        passenger1 = new Passenger("Alice", 1);
        passenger2 = new Passenger("George", 2);
        passenger3 = new Passenger("Harry", 3);
        passenger4 = new Passenger("Ian", 4);
        passenger5 = new Passenger("Julian", 5);
        plane1 = new Plane(PlaneType.BIGPLANE);
        plane2 = new Plane(PlaneType.MEDIUMPLANE);
        plane3 = new Plane(PlaneType.TINYPLANE);
    }
    @Test
    public void flightHasFlightNumber(){
        assertEquals("ABC123", flight1.getFlightNumber());
    }

    @Test
    public void flightHasDepartureDestination(){
        assertEquals(Destinations.GLA, flight1.getDepartureDestination());
    }

    @Test
    public void flightHasArrivalDestination(){
        assertEquals(Destinations.EDI, flight1.getArrivalDestination());
    }

    @Test
    public void flightHasDepartureTime(){
        assertEquals("12:00", flight1.getDepartureTime());
    }

    @Test
    public void flightStartsWithNoPlane(){
        assertEquals(false, flight1.hasPlane());
    }

    @Test
    public void flightStartWithNoPilot(){
        assertEquals(false, flight1.hasPilot());
    }

    @Test
    public void flightShouldStartWithNoCabinCrew(){
        assertEquals(0, flight1.getNumberOfCrew());
    }

    @Test
    public void flightShouldStartWithNoPassengers(){
        assertEquals(0, flight1.getNumberOfPassengers());
    }

    @Test
    public void flightCanAddAPilot(){
        flight1.addPilot(pilot1);
        assertEquals(true, flight1.hasPilot());
        assertEquals(pilot1, flight1.getPilot());
    }

    @Test
    public void flightCanAddAPlane(){
        flight1.addPlane(plane1);
        assertEquals(plane1, flight1.getPlane());
    }

    @Test
    public void flightCanAddCabinCrew(){
        flight1.addCrew(firstOfficer);
        flight1.addCrew(purser);
        flight1.addCrew(flightAttendant);
        assertEquals(3, flight1.getNumberOfCrew());
    }

    @Test
    public void flightCanAddPassengers(){
        flight1.addPlane(plane1);
        flight1.addPassenger(passenger1);
        flight1.addPassenger(passenger2);
        flight1.addPassenger(passenger3);
        flight1.addPassenger(passenger4);
        flight1.addPassenger(passenger5);
        assertEquals(5, flight1.getNumberOfPassengers());
    }

    @Test
    public void flightCanGetNumberOfEmptySeats(){
        flight1.addPlane(plane1);
        flight1.addPassenger(passenger5);
        assertEquals(99, flight1.getNumberOfEmptySeats());
    }

    @Test
    public void flightShouldReturn0ForAFullPlane(){
        flight1.addPlane(plane1);
        for (int i = 0; i<100;  i++){
            flight1.addPassenger(passenger1);
        }
        assertEquals(0, flight1.getNumberOfEmptySeats());
    }

    @Test
    public void flightShouldOnlyBookIfThereAreEmptySeats(){
        flight1.addPlane(plane1);
        for (int i = 0; i<101;  i++){
            flight1.addPassenger(passenger1);
        }
        assertEquals(100, flight1.getNumberOfPassengers());
    }

    @Test
    public void flightCanGetBaggageAllowanceForEachPassenger(){
        flight1.addPlane(plane1);
        flight1.addPassenger(passenger1);
        flight1.addPassenger(passenger1);
        flight1.addPassenger(passenger1);
        flight1.addPassenger(passenger1);
        flight1.addPassenger(passenger1);
        flight1.addCrew(firstOfficer);
        flight1.addCrew(purser);
        flight1.addCrew(flightAttendant);
        flight1.addPilot(pilot1);
        flight1.addCrew(pilot2);
        assertEquals(2300, flight1.getBaggageAllowance());
    }

    @Test
    public void flightCanGetTakeOffWeight(){
        flight1.addPlane(plane1);
        flight1.addPilot(pilot1);
        flight1.addCrew(flightAttendant);
        flight1.addPassenger(passenger1);
        assertEquals(320, flight1.getTakeOffWeight());

    }

    @Test
    public void flightCanReturnRemainingBaggageAllowanceForWholeFlight(){
        flight1.addPlane(plane1);
        flight1.addPassenger(passenger1);
        flight1.addPassenger(passenger2);
        flight1.addPassenger(passenger3);
        flight1.addPassenger(passenger4);
        flight1.addPassenger(passenger5);
        flight1.addCrew(firstOfficer);
        flight1.addCrew(purser);
        flight1.addCrew(flightAttendant);
        flight1.addPilot(pilot1);
        flight1.addCrew(pilot2);
        assertEquals(11200, flight1.getRemainingBaggageAllowance());
    }

    @Test
    public void flightCanGetWeightOfAllPersonsOnBoard(){
        flight1.addPlane(plane1);
        flight1.addPassenger(passenger1);
        assertEquals(100, flight1.getWeightOfAllPersonsOnBoard());
    }


    @Test
    public void flightCanGetWeightOfAllBaggage(){
        flight1.addPlane(plane1);
        flight1.addPassenger(passenger1);
        flight1.addPassenger(passenger2);
        assertEquals(60, flight1.getWeightOfAllBaggage());
    }
}
