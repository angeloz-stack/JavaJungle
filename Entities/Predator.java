public class Predator extends Animal{
    private int max_preys_per_day;

    public Predator(int[] coord, float reproductive_rate, boolean Herbivore, boolean Carnivore, int max_preys_per_day){
        super(coord, reproductive_rate, Herbivore, Carnivore);
        this.max_preys_per_day = max_preys_per_day;
    }
    
    public int[] search(Entity AnotherEntity){
        
        
        
        return null;
    }

    public void dailyUpdate() {
        // To be implemented
    }

    public void hunt(){
        // To be implemented
    }

}