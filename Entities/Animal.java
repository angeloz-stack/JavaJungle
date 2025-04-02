public abstract class Animal extends Entity {
    protected boolean Herbivore;
    protected boolean Carnivore;

    public Animal(int x, int y, float reproductive_rate, boolean Herbivore, boolean Carnivore){
        super(x, y, reproductive_rate);
        this.Herbivore = Herbivore;
        this.Carnivore = Carnivore;
    }
    

    // Reproduction has to be implemented
    @Override
    public Animal reproduce(){
        return null;
    }

    // Moving has to be implemented
    public void move(){}
    
    // Eating has to be implemented
    public void eat(){}


}