import java.awt.*;
import java.util.Stack;

/**
 * An abstract concept in the game, but represents a space that can be held by an insect
 */
public class Tile {

    //https://www.redblobgames.com/grids/hexagons/#map-storage
    // q,r,(s) coordinates from here. Using the axial coordinate system
    private final int q;
    private final int r;

    private Stack<Insect> insect; // the insect(s) on the tile

    public Tile(int q, int r){
        this.q = q;
        this.r = r;
        insect = new Stack<>();
        System.out.println("Tile created, (q,r): (" + getQ() + ", " + getR() + ")");
        Board.tiles.put(new Point(getQ(), getR()),this);
    }

    public int getQ(){
        return q;
    }

    public int getR(){
        return r;
    }

    public int getS(){
        return -getQ()-getR();
    }

    public Point id(){
        return new Point(getQ(), getR());
    }

    /**
     * Returns true if this tile has no insect on it
     * @return true if no insect, false otherwise
     */
    public boolean isEmpty(){
        return insect.empty();
    }

    /**
     *  Returns if the tile in the specified direction is empty;
     * @param dq the q direction
     * @param dr the r direction
     * @return true if an insect is not residing there
     */
    public boolean isEmpty(int dq, int dr){
        Tile t = getTileFrom(dq, dr);
        return t == null || t.isEmpty();
    }

    /**
     * Returns the insect on this tile, or throws an exception if it is empty
     * @return the insect on this tile
     */
    public Insect getInsect(){
        if (isEmpty())
            throw new NullPointerException("No insect is on this tile");
        return insect.peek();
    }

    /**
     * Adds the given insect to this tile
     * @param insect the insect to add
     */
    public void addInsect(Insect insect){
        this.insect.push(insect);
    }

    /**
     * Removes the insect that is currently on this tile
     * @return true if the removal was successful, false if there was no insect here
     */
    public boolean removeInsect(){
        if (!isEmpty()){
            insect.pop();
            return true;
        }
        else return false;
    }

    /**
     * Returns the tile from the given direction
     * @param dq the q direction
     * @param dr the r direction
     * @return the tile
     */
    public Tile getTileFrom(int dq, int dr){
        return Board.getTile(getQ()+dq, getR()+dr);
    }

    /**
     * Returns true if a piece can slide to the specified direction)
     * (Essentially, returns false if the space is too tight)
     * @param dq the q direction
     * @param dr the r direction
     * @return true if it can, false otherwise
     */
    public boolean canSlideTo(int dq, int dr){
        return isEmpty(dr,-dq-dr) || isEmpty(-dq-dr, dq);
    }

    /**
     * Returns true if the direction supplied is adjacent to this tile
     * @param dq the q direction
     * @param dr the r direction
     * @return true if it is adjacent, false otherwise
     */
    public boolean validDirection(int dq, int dr){
        return Math.abs(dq + dr) <= 1;
    }

    /**
     * Checks whether the tile supplied is adjacent to this one
     * @param t the tile to compare to
     * @return true if they are adjacent, false otherwise
     */
    public boolean isAdjacent(Tile t){
        return isAdjacent(t.getQ(), t.getR());
    }

    /**
     * checks if the coordinates q,r are adjacent to this tile
     * @param q the q coordinate
     * @param r the r coordinate
     * @return true if they are adjacent, false otherwise
     */
    public boolean isAdjacent(int q, int r){
        return validDirection(getQ()-q, getR()-r);
    }

}
