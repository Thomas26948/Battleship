package ensta;
import java.io.Serializable;
import java.util.List;

import ensta.ship.*;


public class Player {
    /* **
     * Attributs
     */
    protected Board board;
    protected Board opponentBoard;
    protected int destroyedCount;
    protected AbstractShip[] ships;
    protected boolean lose;

    /* **
     * Constructeur
     */
    public Player(Board board, Board opponentBoard, List<AbstractShip> ships) {
        this.board = board;
        this.ships = ships.toArray(new AbstractShip[0]);
        this.opponentBoard = opponentBoard;
    }

    /* **
     * Méthodes
     */

    /**
     * Read keyboard input to get ships coordinates. Place ships on given coodrinates.
     */
    public void putShips() {
        boolean done = false;
        int i = 0;

        do {
            AbstractShip s = ships[i];
            String msg = String.format("placer %d : %s(%d)", i + 1, s.getName(), s.getSize());
            System.out.println(msg);
            InputHelper.ShipInput res = InputHelper.readShipInput();

            // TODO set ship orientation
            Orientation input_orientation = getOrientation(res.orientation);
            s.setOrientation(input_orientation);

            // TODO put ship at given position
            if( board.canPutShip(s,res.y+1,res.x) ) {
                board.putShip(s,res.y+1,res.x);
            // TODO when ship placement successful
                ++i;
            }

            done = i == 5;

            board.print();
        } while (!done);
    }

    public Orientation getOrientation(String inp){
        switch (inp) {
            case "w":
                return Orientation.WEST;
            case "s":
                return Orientation.SOUTH;
            case "e":
                return Orientation.EAST;
            default:
                return Orientation.NORTH;
        }
    }

    // public Hit sendHit(int[] coords) {
    //     boolean done;
    //     Hit hit = null;

    //     do {
    //         System.out.println("où frapper?");
    //         InputHelper.CoordInput hitInput = InputHelper.readCoordInput();
    //         // TODO call sendHit on this.opponentBoard

    //         // TODO : Game expects sendHit to return BOTH hit result & hit coords.
    //         // return hit is obvious. But how to return coords at the same time ?
    //     } while (!done);

    //     return hit;
    // }

    public AbstractShip[] getShips() {
        return ships;
    }

    public void setShips(AbstractShip[] ships) {
        this.ships = ships;
    }
}
