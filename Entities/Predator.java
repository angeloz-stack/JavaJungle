public class Predator extends Animal{
    private int max_preys_per_day;

    public Predator(int x, int y, float reproductive_rate, boolean Herbivore, boolean Carnivore, int max_preys_per_day){
        super(x, y, reproductive_rate, Herbivore, Carnivore);
        this.max_preys_per_day = max_preys_per_day;
    }
    
    @Override
    public void dailyUpdate() {
        // To be implemented
    }

    public void hunt(){
        // To be implemented
    }

}