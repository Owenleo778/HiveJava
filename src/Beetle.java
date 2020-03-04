public class Beetle extends Insect{
    public Beetle(Colour colour) {
        super(colour);
    }

    @Override
    public boolean movePiece(Tile tile) {
        return false;
    }
}
