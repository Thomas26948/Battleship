package ensta;
import java.io.Serializable;
import java.util.List;
import ensta.ship.*;


public class AIPlayer extends Player {
    /* **
     * Attribut
     */
    private BattleShipsAI ai;

    /* **
     * Constructeur
     */
    public AIPlayer(Board ownBoard, Board opponentBoard, List<AbstractShip> ships) {
        super(ownBoard, opponentBoard, ships);
        ai = new BattleShipsAI(ownBoard, opponentBoard);
         AbstractShip[] objects = new AbstractShip[ships.size()];
        objects  = ships.toArray(objects); 
        ai.putShips(objects);
    }

    // TODO AIPlayer must not inherit "keyboard behavior" from player. Call ai instead.



    public Hit sendHit(int[] coords) {
    

        return ai.sendHit(coords);
    }





}
