public class Prey extends Animal{
    private boolean mimetic;
    public Prey(int x, int y, float reproductive_rate, boolean mimetic){
        super(x, y, reproductive_rate, true, false);
        this.mimetic = mimetic;
    }
    
    @Override
    public void dailyUpdate() {
        // To be implemented
    }
}