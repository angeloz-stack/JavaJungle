
public class Pianta {
    private boolean Poisonusus;
    private float reproductive_rate; // (0,1]
    private int energy; 
    //costruttore 
    public Pianta (boolean Poisonusus, float reproductive_rate, int energy){
        this.Poisonusus=Poisonusus;
        this.reproductive_rate=Math.max(Float.MIN_VALUE, Math.min(reproductive_rate, 1.0f)); 
        // fa si che il tasso sia sempre tra (0,1] se è <0 lo setta a MIN_VALUE= 1.4E-45
        this.energy=energy;



    }



}







