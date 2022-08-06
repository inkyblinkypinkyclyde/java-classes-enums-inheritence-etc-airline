public class Pilot extends CrewMember{
    private int pilotNumber;
    public Pilot(String name, Rank rank, int pilotNumber){
        super(name, rank);
        this.pilotNumber = pilotNumber;
    }

    public int getPilotNumber() {
        return pilotNumber;
    }

    public String flyPlane(){
        return "Kneeeeeeeeow, I'm a pilot";
    }


}
