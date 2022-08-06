public class Passenger extends Person{
    private int numberOfBags;
    private Flight flight;
    public Passenger(String name, int numberOfBags){
        super(name);
        this.numberOfBags = numberOfBags;
    }

    public int getNumberOfBags(){
        return numberOfBags;
    }
}
