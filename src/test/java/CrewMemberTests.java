import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CrewMemberTests {
    Pilot pilot;
    FirstOfficer firstOfficer;
    Purser purser;
    FlightAttendant flightAttendant;

    @Before
    public void before(){
        pilot = new Pilot("Bob", Rank.CAPTAIN, 123);
        firstOfficer = new FirstOfficer("Charles", Rank.FIRSTOFFICER);
        purser = new Purser("Dominic", Rank.PURSER);
        flightAttendant = new FlightAttendant("Edward", Rank.FLIGHTATTENDANT);
    }

    @Test
    public void canGetRankCaptain(){
        assertEquals(Rank.CAPTAIN, pilot.getRank());
    }
    @Test
    public void canGetRankFirstOfficer(){
        assertEquals(Rank.FIRSTOFFICER, firstOfficer.getRank());
    }
    @Test
    public void canGetRankPurser(){
        assertEquals(Rank.PURSER, purser.getRank());
    }
    @Test
    public void canGetRankFlightAttendant(){
        assertEquals(Rank.FLIGHTATTENDANT, flightAttendant.getRank());
    }
    @Test
    public void canGetPilotNumber(){
        assertEquals(123, pilot.getPilotNumber());
    }
    @Test
    public void pilotSHouldBeAbleToFlyAPlane(){
        assertEquals("Kneeeeeeeeow, I'm a pilot", pilot.flyPlane());
    }

}
