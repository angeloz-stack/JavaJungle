import Entities.Entity;
import Entities.Plant;
import Entities.Prey;

public class Main{
    public static void main(String[] args){
        Entity[][] map = new Entity[10][10];

        Prey preda = new Prey(new int[]{2,2}, 0.7f, 80, false, false);
        Plant pianta = new Plant(new int[]{0,0}, 0.7f, 80, false);
        Plant pianta2 = new Plant(new int[]{3,3}, 0.7f, 80, false);

        System.out.println("Preda:");
        System.out.println(preda.getCoord(0)+" "+preda.getCoord(1));
        System.out.println(preda.getEnergy());
        System.out.println(preda.getReproductiveRate());

        System.out.println("Pianta:");
        System.out.println(pianta.getCoord(0)+" "+pianta.getCoord(1));
        System.out.println(pianta.getEnergy());
        System.out.println(pianta.getReproductiveRate());
        
        map[preda.getCoord(0)][preda.getCoord(1)] = preda;
        map[pianta.getCoord(0)][pianta.getCoord(1)] = pianta;
        map[pianta2.getCoord(0)][pianta2.getCoord(1)] = pianta2;

        int[] coord = preda.search(map,"Plant");
        System.out.println(coord[0]+" "+coord[1]);
        
        return;
    }
}