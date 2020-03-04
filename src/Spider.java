import java.awt.*;

public class Spider extends Insect {
    public Spider(Colour colour, Point pos) {
        super(colour, pos);
    }

    @Override
    public boolean movePiece(Tile tile) {
        return false;
    }
}
