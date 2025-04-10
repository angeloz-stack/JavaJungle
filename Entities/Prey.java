public class Prey extends Animal{
    private boolean mimetic;
    private boolean poisonous;
    public Prey(int[] coord, float reproductive_rate, boolean mimetic, boolean poisonous){
        super(coord, reproductive_rate, true, false);
        this.mimetic = mimetic;
        this.poisonous = poisonous;
    }
    
    public boolean isMimetic(){
        return mimetic;
    }

    public boolean isPoisonous(){
        return poisonous;
    }

    public int[] search(Entity[][] map, Entity AnotherEntity){
        int n = map.length;
        int i = coord[0];
        int j = coord[1];
        
        if (i < 0 || i >= n || j < 0 || j >= n) {
            throw new IllegalArgumentException("Coordinate non valide");
        }
        
        int[] result = null;
        double MIN_DISTANCE = Double.MAX_VALUE;

        int startRow = Math.max(0, i-2);
        int startCol = Math.max(0, j-2);
        int endRow = Math.min(n-1, i+2);
        int endCol = Math.min(n-1, j+2);

        for (int row = startRow; row <= endRow; row++){
            for (int col = startCol; col <= startCol; col++){
                if (row == i && col == j) continue;

                if(map[row][col] != null){
                    int x = 
                }

            }
        }


        return null;
    }


    @Override
    public void dailyUpdate() {
        // To be implemented
    }
}