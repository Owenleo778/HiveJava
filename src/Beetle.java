import java.awt.*;

public class Beetle extends Insect{
    public Beetle(Colour colour, Point pos) {
        super(colour, pos);
    }

    @Override
    public boolean movePiece(Tile tile) {
        return false;
    }
}
