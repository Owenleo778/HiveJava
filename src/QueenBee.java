import java.awt.*;

/**
 * Implements the Queen Bee piece
 */
public class QueenBee extends Insect {

    public QueenBee(Colour colour, Point pos){
        super(colour, pos);
    }

    @Override
    public boolean movePiece(Tile tile) {
        if (!tile.isEmpty())
            return false;
        return true;
    }

    public boolean canMove(){
        if (!isOnTop())
            return false;

        return true;
    }

}
