package Entities;

public abstract class Animal extends Entity {
    protected boolean Herbivore;
    protected boolean Carnivore;

    public Animal(int[] coord, float reproductive_rate, int energy, boolean Herbivore, boolean Carnivore){
        super(coord, reproductive_rate, energy);
        this.Herbivore = Herbivore;
        this.Carnivore = Carnivore;
    }
    
    public boolean isHerbivore(){
        return Herbivore;
    }

    public boolean isCarnivore(){
        return Carnivore;
    }

    // Reproduction has to be implemented

    @Override
    public Entity reproduce(){
        return null;
    }

    // Moving has to be implemented
    public void move(int[] destination){

    }
    
    // Eating has to be implemented
    public void eat(){}


}