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

    public boolean canMove(Point p){
        if (Board.getTile(position()).distance(p) > 1)
            return false;
        return true;
    }

    public boolean canMove(Tile tile){
        return canMove(tile.id());
    }
}
