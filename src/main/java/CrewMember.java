public abstract class CrewMember extends Person{
    private Rank rank;
    public CrewMember(String name, Rank rank){
        super(name);
        this.rank = rank;
    }

    public Rank getRank(){
        return rank;
    }
}
