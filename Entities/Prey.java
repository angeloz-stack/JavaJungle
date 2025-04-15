package Entities;

public class Prey extends Animal{
    private boolean mimetic;
    private boolean poisonous;
    public Prey(int[] coord, float reproductive_rate, int energy, boolean mimetic, boolean poisonous){
        super(coord, reproductive_rate, energy, true, false);
        this.mimetic = mimetic;
        this.poisonous = poisonous;
    }
    
    public boolean isMimetic(){
        return mimetic;
    }

    public boolean isPoisonous(){
        return poisonous;
    }
        
    @Override
    public void dailyUpdate() {
        // To be implemented
    }
}