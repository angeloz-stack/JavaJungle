public class Plant extends Entity{
    private boolean poisonous;
    
    public Plant (int[] coord, float reproductive_rate, boolean poisonous){
        super(coord,reproductive_rate);
        this.poisonous = poisonous;
    }
    

    public boolean isPoisonous(){
        return poisonous;
    }

    @Override
    public void dailyUpdate(){}

    @Override
    public Plant reproduce(){
        return null;
    }

}







