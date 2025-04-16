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
    protected float reproductive_rate;
    protected int energy;
    protected int age; // in days
    protected boolean reproduced;
    protected int days_since_reproduction;

    // Generic constructor: it will be called by super() in subclasses
    public Entity(int[] coord, float reproductive_rate, int energy) {
        if (coord.length != 2) throw new IllegalArgumentException("L'array deve avere 2 elementi ma ne sono stati dati "+coord.length);
        if (coord[0] < 0) throw new IllegalArgumentException("L'array non può avere coordinate negative.");
        if (coord[1] < 0) throw new IllegalArgumentException("L'array non può avere coordinate negative.");
        this.coord = coord;
        this.energy = 80;
        this.reproductive_rate = Math.max(0.1f, Math.min(reproductive_rate, 1.0f));
        this.age = 0;
        this.reproduced = false;
        this.days_since_reproduction = 0;
    }

    public int getCoord(int x){
        if (x<0 || x>1) throw new ArrayIndexOutOfBoundsException("Indice fuori dai limiti");
        return coord[x];
    }

    public float getReproductiveRate(){
        return reproductive_rate;
    }

    public int getEnergy(){
        return energy;
    }

    public boolean isFullEnergy(){
        if (energy == 100) return true;
        else return false;
    }

    public boolean isAlive(){
        if (energy>0) return true;
        else return false;
    }

    public boolean hasReproduced(){
        if (reproduced){
            if (days_since_reproduction <= 10) return true;
            else{
                reproduced = false;
                return reproduced;
            }
        }
        else return reproduced;
    }

    public void incrementEnergy(int energy){
        this.energy = Math.max(0, Math.min(this.energy+energy, 100));
        return;
    }
    
    // Increment or decrement reproductive_rate according to percentage_change_rate: float% e.g 10% -20%
    public void setPercentageReproductiveRate(float percentage_change_rate){
        reproductive_rate = reproductive_rate*(1+percentage_change_rate/100);
        return;
    }
        
    public int[] search(Entity[][] map, String EntityToFind){
        /*
        Args:   Entity[][] map -> The matrix in which entities live
                String EntityToFind -> The Entity to be found; the method looks for the generic type Predator, Prey or Plant, so it can't be used
                                        to find a specific entity in the entire map

        Output: int[] result -> An array containing the coordinates of the nearest entity to be found
        */
               
        int n = map.length;
        int i = coord[0];
        int j = coord[1];
        
        if (i < 0 || i >= n || j < 0 || j >= n) {
            throw new IllegalArgumentException("Coordinate non valide");
        }
        
        int[] result = new int[]{-1,-1};
        double MIN_DISTANCE = Double.MAX_VALUE;

        // Every entity has a maximum range of control -> It can't search/move/reproduce out of it
        int startRow = Math.max(0, i-2);
        int startCol = Math.max(0, j-2);
        int endRow = Math.min(n-1, i+2);
        int endCol = Math.min(n-1, j+2);

        for (int row = startRow; row <= endRow; row++){
            for (int col = startCol; col <= endCol; col++){
                if (map[row][col] == null || row == i && col == j) continue;

                if(EntityToFind.equals(map[row][col].getClass().getSimpleName())){
                    // Calculate distance to take the nearest element
                    int deltaRow = row - i;
                    int deltaCol = col - j;
                    double distanceSq = (deltaRow*deltaRow) + (deltaCol*deltaCol);

                    if (distanceSq<MIN_DISTANCE){
                        MIN_DISTANCE = distanceSq;
                        result[0] = row;
                        result[1] = col;
                    }
                }
            }
        }

        return result;
    }

    // Daily updater: which parameters?
    public abstract void dailyUpdate();

    public abstract Entity reproduce();

    
}