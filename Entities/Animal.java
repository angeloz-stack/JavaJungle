public abstract class Animal extends Entity {
    protected boolean Herbivore;
    protected boolean Carnivore;

    public Animal(int[] coord, float reproductive_rate, boolean Herbivore, boolean Carnivore){
        super(coord, reproductive_rate);
        this.Herbivore = Herbivore;
        this.Carnivore = Carnivore;
    }
    

    // Reproduction has to be implemented
    public Animal reproduce(){
        return null;
    }

    public abstract int[] search(Entity AnotherEntity);

    // Moving has to be implemented
    public void move(int[] destination){

    }
    
    // Eating has to be implemented
    public void eat(){}


}