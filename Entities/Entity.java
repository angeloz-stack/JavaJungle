/*
x: int, x coordinate of the entity
y: int, y coordinate of the entity
energy: int, energy of the entity; entity is alive if energy > 0
age: int, age of the entity
reproductive_rate: int, reproductive rate of the entity; (0,1]
*/

public abstract class Entity {
    protected int x;
    protected int y;
    protected int energy;
    protected int age;
    protected float reproductive_rate;

    // Generic constructor: it will be called by super() in subclasses
    public Entity(int x, int y, float reproductive_rate) {
        this.x = x;
        this.y = y;
        this.energy = 80;
        this.age = 0;
        this.reproductive_rate = reproductive_rate;
    }

    // Daily updater: which parameters?
    public abstract void dailyUpdate();

    public abstract Entity reproduce();

    public void setReproductiveRate(float percentage_change_rate){
        reproductive_rate = reproductive_rate*(1-(percentage_change_rate/100));
    }
}