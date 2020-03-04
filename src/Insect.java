/**
 * Implements the insects of the game (the pieces)
 */
public abstract class Insect {

    //public final static int id = 0;
    private Colour colour;

    public Insect(Colour colour){
        this.colour = colour;
    }

    public Colour colour(){
        return colour;
    }

    /**
     * Moves the piece to the specified tile if it can
     * @param tile the tile to move to
     * @return returns false if it cannot move here, true otherwise
     */
    public abstract boolean movePiece(Tile tile);



    public enum Colour{
        Black,
        White
    }
}
