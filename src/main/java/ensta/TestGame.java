package ensta;

import ensta.ship.*;
import java.util.ArrayList;
import java.util.List;

/**
 * TestGame BattleShipsAI
 */
public class TestGame{
    /**
    *Attributs
    */


    /**
     * board
     */
    Board board;
    /**
     * number of ship sunk
     */
    int shipsCounter;

    /**
     * List of ships
     */
    Destroyer ship1;
    Submarine ship2;
    Submarine ship3;
    Battleship ship4;
    Carrier ship5;

    List<AbstractShip> shipsList;

    /**
     * AI player instance
     */
    BattleShipsAI ai;

    /**
     * Constructor
     */
    public TestGame(){
        this.board = new Board("Test BattleShipsAI");
        this.board.print();
        this.shipsCounter = 0;
        

        this.shipsList = new ArrayList<AbstractShip>();

        this.ship1 = new Destroyer('D', "Destroyer 1", 2, Orientation.NORTH);
        shipsList.add(ship1);
        this.ship2 = new Submarine('S', "Submarine 1", 3, Orientation.NORTH);
        shipsList.add(ship2);
        this.ship3 = new Submarine('S', "Submarine 2", 3, Orientation.NORTH);
        shipsList.add(ship3);
        this.ship4 = new Battleship('B', "Battleship 1", 4, Orientation.NORTH);
        shipsList.add(ship4);
        this.ship5 = new Carrier('C', "Carrier 1", 5, Orientation.NORTH);
        shipsList.add(ship5);

 

        //Pour le test on joue sur le même board
        this.ai = new BattleShipsAI(board, board);
        AbstractShip[] objects = new AbstractShip[shipsList.size()];
        objects  = shipsList.toArray(objects); 
        ai.putShips(objects);
        board.print();

    }

        /**
         * Testing the game 
         */
    public void gameRun(){
        String alp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";       
        do {
            System.out.println("----------------------------------");
            int[] hitCoords = new int[2];
            Hit hit = ai.sendHit(hitCoords);
            System.out.println("Tir sur : " + alp.charAt(hitCoords[1]) + hitCoords[0]);
            System.out.println("Resultat : " + hit.toString());
            if (board.getNavires()[hitCoords[0]][hitCoords[1]].getIsShip())
                if(board.getNavires()[hitCoords[0]][hitCoords[1]].isSunk()){
                    ++shipsCounter;
                }
           
            board.print();
        } while (shipsCounter != 5);
        System.out.println("Test finished successfully ! ");

    }
}