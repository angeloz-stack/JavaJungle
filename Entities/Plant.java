
public class Plant extends Entity{
    private boolean poisonous;
    
    public Plant (int x, int y, float reproductive_rate, boolean poisonous){
        super(x,y,reproductive_rate);
        this.poisonous = poisonous;
    }
    
    @Override
    public void dailyUpdate(){}

    @Override
    public Plant reproduce(){
        return null;
    }


}







