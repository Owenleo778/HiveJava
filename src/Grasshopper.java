import java.awt.*;

public class Grasshopper extends Insect{
    public Grasshopper(Colour colour, Point pos) {
        super(colour, pos);
    }

    @Override
    public boolean movePiece(Tile tile) {
        return false;
    }
}
