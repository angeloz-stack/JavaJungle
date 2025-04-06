/*
i: int, i coordinate of the entity (rows)
j: int, j coordinate of the entity (columns)
energy: int, energy of the entity; entity is alive if energy > 0
age: int, age of the entity
reproductive_rate: int, reproductive rate of the entity; (0,1]
*/
import java.util.Arrays;
import java.util.Random;



public abstract class Entity {
    protected Integer[] coord;
    protected int energy;
    protected int age;
    protected float reproductive_rate;

    // Generic constructor: it will be called by super() in subclasses
    public Entity(Integer[] coord, float reproductive_rate) {
        coord = new Integer[2];
        this.energy = (int) Math.max(0, Math.min(energy, 100));
        this.reproductive_rate = Math.max(0.1f, Math.min(reproductive_rate, 1.0f));
    }

    public Integer[] getCoord(){
        return coord;
    }

    public int getEnergy(){
        return energy;
    }


    public void incrementEnergy(int energy){
        this.energy = (int) Math.max(0, Math.min(this.energy+energy, 100));
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



  
    public void eat(Entity[][] map, int []eatCoord){
        Integer[] copyCoord = Arrays.copyOf(this.coord, 2);
        for (int i=0;i<=1;i++){
        this.coord[i] = eatCoord[i];
        }
        map[eatCoord[0]][eatCoord[1]] = map[copyCoord[0]][copyCoord[1]];
        map[copyCoord[0]][copyCoord[1]] = null;

    }
    
    public void move(Entity[][] map, int [] newCoord){   
        Integer[] copyCoord = Arrays.copyOf(this.coord, 2);
        if (newCoord[0]==-1 && newCoord[0]==-1){
            int Negative = new Random().nextBoolean() ? -1:1;
            for (int i=0;i<=1;i++){
                newCoord[i] = coord[i] + 1 + Negative*new Random().nextInt(2);
                this.coord[i] = newCoord[i];
            }
            
            // caso in cui esce 0,0:

            if(!(newCoord[0]==copyCoord[0]) || !(newCoord [1]==copyCoord[1])){
                map[newCoord[0]][newCoord[1]] = map[copyCoord[0]][copyCoord[1]];
                map[copyCoord[0]][copyCoord[1]] = null;
            }
            else {
                map[newCoord[0]][newCoord[1]] = map[copyCoord[0]][copyCoord[1]];
            }
        }
        else {
            eat(map, newCoord);
        }
    }
    
}