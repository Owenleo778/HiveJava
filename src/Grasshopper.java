public class Grasshopper extends Insect{
    public Grasshopper(Colour colour) {
        super(colour);
    }

    @Override
    public boolean movePiece(Tile tile) {
        return false;
    }
}
