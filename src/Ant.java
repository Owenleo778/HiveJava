public class Ant extends Insect{
    public Ant(Colour colour) {
        super(colour);
    }

    @Override
    public boolean movePiece(Tile tile) {
        return false;
    }

}
