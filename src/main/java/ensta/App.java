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

        TestGame testgame = new TestGame();
        testgame.gameRun();

        
        // Board perso_board = new Board("My board",9);
        // Board oppo_board = new Board("Opponent board",9);

        // System.out.println(perso_board.getName());
        // perso_board.print();

        // List<AbstractShip> ships=new ArrayList<AbstractShip>();
        // Destroyer ship1 = new Destroyer('D', "Destroyer 1", 2, Orientation.NORTH);
        // ships.add(ship1);
        // Submarine ship2 = new Submarine('S', "Submarine 1", 3, Orientation.NORTH);
        // ships.add(ship2);
        // Submarine ship3 = new Submarine('S', "Submarine 2", 3, Orientation.NORTH);
        // ships.add(ship3);
        // Battleship ship4 = new Battleship('B', "Battleship 1", 4, Orientation.NORTH);
        // ships.add(ship4);
        // Carrier ship5 = new Carrier('C', "Carrier 1", 5, Orientation.NORTH);
        // ships.add(ship5);

        // // System.out.print(ColorUtil.colorize("Hello world wwi oaho", ColorUtil.Color.RED));

        // Player player1 = new Player(perso_board,oppo_board,ships);
        // player1.putShips();
        // Player player2 = new Player(oppo_board,perso_board,ships);
        // player2.putShips();
        // int[] coords = new int[2];

        // while(true){
        // 	player1.sendHit(coords);
        // perso_board.print();
        // oppo_board.print();
        // }
        
        
    }
}
