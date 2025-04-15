package Entities;

/*
i: int, i coordinate of the entity (rows)
j: int, j coordinate of the entity (columns)
energy: int, energy of the entity; entity is alive if energy > 0
age: int, age of the entity
reproductive_rate: int, reproductive rate of the entity; (0,1]
*/

public abstract class Entity {
    protected int[] coord;
    protected int energy;
    protected int age;
    protected float reproductive_rate;

    // Generic constructor: it will be called by super() in subclasses
    public Entity(int[] coord, float reproductive_rate, int energy) {
        if (coord.length != 2) throw new IllegalArgumentException("L'array deve avere 2 elementi ma ne sono stati dati "+coord.length);
        if (coord[0] < 0) throw new IllegalArgumentException("L'array non può avere coordinate negative.");
        if (coord[1] < 0) throw new IllegalArgumentException("L'array non può avere coordinate negative.");
        this.coord = coord;
        this.energy = Math.max(0, Math.min(energy, 100));
        this.reproductive_rate = Math.max(0.1f, Math.min(reproductive_rate, 1.0f));
    }

    public int getCoord(int x){
        if (x<0 || x>1) throw new ArrayIndexOutOfBoundsException("Indice fuori dai limiti");
        return coord[x];
    }

    public int getEnergy(){
        return energy;
    }


    public void incrementEnergy(int energy){
        this.energy = Math.max(0, Math.min(this.energy+energy, 100));
        return;
    }
    
    public boolean isFullEnergy(){
        if (energy == 100) return true;
        else return false;
    }

    public boolean isAlive(){
        if (energy>0) return true;
        else return false;
    }

    public float getReproductiveRate(){
        return reproductive_rate;
    }

    // Increment or decrement reproductive_rate according to percentage_change_rate: float% e.g 10% -20%
    public void setPercentageReproductiveRate(float percentage_change_rate){
        reproductive_rate = reproductive_rate*(1+percentage_change_rate/100);
        return;
    }
   

    // Daily updater: which parameters?
    public abstract void dailyUpdate();

    public abstract Entity reproduce();

    
}