import java.awt.*;

public class Ant extends Insect{
    public Ant(Colour colour, Point pos) {
        super(colour, pos);
    }

    @Override
    public boolean movePiece(Tile tile) {
        return false;
    }

}
