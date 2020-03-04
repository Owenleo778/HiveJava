public class Spider extends Insect {
    public Spider(Colour colour) {
        super(colour);
    }

    @Override
    public boolean movePiece(Tile tile) {
        return false;
    }
}
