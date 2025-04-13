public abstract class Animal extends Entity {
    protected boolean Herbivore;
    protected boolean Carnivore;

    public Animal(int[] coord, float reproductive_rate, boolean Herbivore, boolean Carnivore){
        super(coord, reproductive_rate);
        this.Herbivore = Herbivore;
        this.Carnivore = Carnivore;
    }
    

    // Reproduction has to be implemented
    @Override
    public Animal reproduce(){
        return null;
    }

    public int[] search(Entity[][] map, Entity EntityToFind){
        /*
        Args:   Entity[][] map -> The matrix in which entities live
                Entity[] EntityToFind -> The Entity to be found; the method looks for the generic type Predator, Prey or Plant, so it can't be used
                                        to find a specific entity in the entire map

        Output: int[] result -> An array containing the coordinates of the nearest entity to be found
        */
        String toFind = EntityToFind.getClass().getSimpleName();
        
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
                if (row == i && col == j) continue;

                if(toFind.equals(map[row][col].getClass().getSimpleName())){
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

    // Moving has to be implemented
    public void move(int[] destination){

    }
    
    // Eating has to be implemented
    public void eat(){}


}