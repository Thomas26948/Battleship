package ensta;


import java.util.List;
import java.util.ArrayList;

import ensta.ship.*;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Board perso_board = new Board("My board",9);
        Board oppo_board = new Board("Opponent board",9);

        System.out.println(perso_board.getName());
        perso_board.print();

        List<AbstractShip> ships=new ArrayList<AbstractShip>();
        Destroyer ship1 = new Destroyer('D', "D1", 3, Orientation.NORTH);
        ships.add(ship1);
        Submarine ship2 = new Submarine('S', "S1", 3, Orientation.NORTH);
        ships.add(ship2);
        Submarine ship3 = new Submarine('S', "S2", 3, Orientation.NORTH);
        ships.add(ship3);
        Battleship ship4 = new Battleship('B', "B1", 3, Orientation.NORTH);
        ships.add(ship4);
        Carrier ship5 = new Carrier('C', "C1", 3, Orientation.NORTH);
        ships.add(ship5);


        Player player1 = new Player(perso_board,oppo_board,ships);
        player1.putShips();

        // tab.setHit(true, 2,2);
        // tab.setHit(true, 5,4);
        // tab.setHit(true, 8,3);
        // Orientation test = Orientation.WEST;
        // Orientation test2 = Orientation.NORTH;

        // Destroyer ship = new Destroyer('D', "D1", 5, test);
        // Destroyer ship3 = new Destroyer('A', "D1", 4, test2);

        // tab.putShip(ship,3,3);
        // tab.print();
        // tab.putShip(ship3,4,3);
        // tab.print();

    }
}
