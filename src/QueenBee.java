/**
 * Implements the Queen Bee piece
 */
public class QueenBee extends Insect {

    public QueenBee(Colour colour){
        super(colour);
    }

    @Override
    public boolean movePiece(Tile tile) {
        if (!tile.isEmpty())
            return false;
        return true;
    }
}
