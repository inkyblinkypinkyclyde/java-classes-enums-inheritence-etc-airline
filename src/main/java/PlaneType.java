public enum PlaneType {
    BIGPLANE(100, 12500),
    MEDIUMPLANE(50, 500),
    TINYPLANE(5, 50);

    private final int capacity;
    private final int maxTakeOffWeight;
    PlaneType(int capacity, int maxTakeOffWeight) {
        this.capacity = capacity;
        this.maxTakeOffWeight = maxTakeOffWeight;
    }
    public int getCapacity(){
        return capacity;
    }
    public int getMaxTakeOffWeight(){
        return maxTakeOffWeight;
    }
}
