import java.util.ArrayList;

public class Flight {
    private ArrayList<Plane> plane;
    private ArrayList<Pilot> pilots;
    private ArrayList<CrewMember> crewMembers;
    private ArrayList<Passenger> passengers;
    private String flightNumber;
    private Destinations departureDestination;
    private Destinations arrivalDestination;
    private String departureTime;

    public Flight(String flightNumber, Destinations departureDestination, Destinations arrivalDestination, String departureTime){
        this.flightNumber = flightNumber;
        this.departureDestination = departureDestination;
        this.arrivalDestination = arrivalDestination;
        this.departureTime = departureTime;
        this.crewMembers = new ArrayList<>();
        this.pilots = new ArrayList<>();
        this.passengers = new ArrayList<>();
        this.plane = new ArrayList<>();
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Destinations getDepartureDestination() {
        return departureDestination;
    }

    public Destinations getArrivalDestination() {
        return arrivalDestination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public boolean hasPlane() {
        if (plane.size() == 1){
            return true;
        } else {
            return false;
        }
    }

    public boolean hasPilot() {
        if (pilots.size()> 0 ){
            return true;
        } else {
            return false;
        }
    }

    public int getNumberOfCrew() {
        return crewMembers.size();
    }

    public int getNumberOfPassengers() {
        return passengers.size();
    }

    public void addPilot(Pilot pilot) {
        pilots.add(pilot);
    }

    public Pilot getPilot() {
        return pilots.get(0);
    }

    public void addPlane(Plane planeToBeAdded) {
        if (plane.size() < 1){
            plane.add(planeToBeAdded);
        }
    }

    public Plane getPlane() {
        return plane.get(0);
    }

    public void addCrew(CrewMember crewMember) {
        crewMembers.add(crewMember);
    }

    public void addPassenger(Passenger passenger) {
        if (getNumberOfEmptySeats()>0){
            passengers.add(passenger);
        }
    }


    public int getNumberOfEmptySeats() {
        if (plane.size() > 0){
            return plane.get(0).getCapacity() - passengers.size();
        } else {
            return 0;
        }
    }

    public int getBaggageAllowance() {
        return (plane.get(0).getMaxTakeOffWeight()-getWeightOfAllPersonsOnBoard())/getNumberOfPassengers();
    }

    public int getWeightOfAllBaggage() {
        int baggageWeight = 0;
        for (Passenger passenger: passengers){
            baggageWeight = baggageWeight + (passenger.getNumberOfBags()*20);
        };
        return baggageWeight;
    }

    public int getRemainingBaggageAllowance() {
        return plane.get(0).getMaxTakeOffWeight() - getTakeOffWeight();
    }

    public int getWeightOfAllPersonsOnBoard() {
        return (getNumberOfPassengers()*100)+(getNumberOfCrew()*100)+(pilots.size()*100);
    }

    public int getTakeOffWeight() {
        return getWeightOfAllPersonsOnBoard() + getWeightOfAllBaggage();
    }


}
