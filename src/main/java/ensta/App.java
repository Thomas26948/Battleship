package ensta;

import ensta.ship.AbstractShip;
import ensta.ship.Battleship;
import ensta.ship.Carrier;
import ensta.ship.Destroyer;
import ensta.ship.Orientation;
import ensta.ship.Submarine;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Board tab = new Board("Jeu",9);
        System.out.println(tab.getName());
        tab.print();
        tab.setHit(true, 2,2);
        tab.setHit(true, 5,4);
        tab.setHit(true, 8,3);
        Orientation test = Orientation.WEST;
        Orientation test2 = Orientation.NORTH;

        Destroyer ship = new Destroyer('D', "D1", 5, test);
        Destroyer ship3 = new Destroyer('A', "D1", 4, test2);

        tab.putShip(ship,3,3);
        tab.print();
        tab.putShip(ship3,4,3);
        tab.print();

    }
}
