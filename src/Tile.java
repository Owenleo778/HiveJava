/**
 * An abstract concept in the game, but represents a space that can be held by an insect
 */
public class Tile {

    public static int idCount = 0;
    private final int id = idCount++;


    private Insect insect; // the insect on the tile
    private Tile[] surrounding;

    public Tile(){
        surrounding = new Tile[6]; // (0 represents up, continues clockwise)
        System.out.println("Tile created, id: " + id);
        Board.tiles.put(id(),this);
    }

    /**
     * Called from within tile t, which is from direction dir
     * @param t the tile that created this one
     * @param dir the direction this tile is in respect to t
     */
    public Tile(Tile t, int dir){
        this();
        surrounding[(dir + 3)%6] = t;
    }

    public int id(){
        return id;
    }

    /**
     * Returns true if this tile has no insect on it
     * @return true if no insect, false otherwise
     */
    public boolean isEmpty(){
        return insect == null;
    }

    /**
     * Returns if the tile in the specified direction is empty;
     * @param direction the direction in question
     * @return true if an insect is not residing there
     */
    public boolean isEmpty(int direction){
        return getTile(direction) == null || getTile(direction).isEmpty();
    }

    /**
     * Returns the insect on this tile, or throws an exception if it is empty
     * @return the insect on this tile
     */
    public Insect getInsect(){
        if (isEmpty())
            throw new NullPointerException("No insect is on this tile");
        return insect;
    }

    /**
     * Adds the given insect to this tile
     * @param insect the insect to add
     * @return true if the insect was added, false if not
     */
    public boolean addInsect(Insect insect){
        if (!isEmpty())
            return false;
        this.insect = insect;
        copySurroundingTiles();
        addEmptyTiles();
        return true;
    }

    /**
     * Takes tiles from surrounding tiles that should be connected to this tile
     */
    private void copySurroundingTiles(){
        for (int i = 0; i < 6; i++){
            Tile tile = surrounding[i];
            if (tile != null) {
                addTile(tile.getTile(i + 2), i + 1);
                addTile(tile.getTile(i - 2), i - 1);
            }
        }
    }

    /**
     * Adds an empty tile to remaining empty surrounding tiles
     */
    private void addEmptyTiles(){
        for (int i = 0; i < 6; i++){
            if (surrounding[i] == null)
                addTile(i);
        }
    }

    /**
     * Adds the specified tile to the direction
     * @param tile the tile to add
     * @param direction the direction to add it to
     * @return true if it was added, false if that direction was not empty
     */
    public boolean addTile(Tile tile, int direction){
        if (!isEmpty(direction))
            return false;
        surrounding[direction % 6] = tile;
        return true;
    }

    /**
     * Creates an empty tile to the direction
     * @param direction the direction to add it to
     * @return true if it was added, false if that direction was not empty
     */
    public boolean addTile(int direction){
        return addTile(new Tile(this, direction), direction);
    }

    /**
     * Removes the insect that is currently on this tile
     * @return true if the removal was successful, false if there was no insect here
     */
    public boolean removeInsect(){
        if (isEmpty())
            return false;
        insect = null;
        return true;
    }

    /**
     * Returns the tile from the given direction
     * @param direction the direction of the tile to return
     * @return the tile
     */
    public Tile getTile(int direction){
        return surrounding[direction%6];
    }

    /**
     * Returns true if a piece can slide to the specified direction)
     * (Essentially, returns false if the space is too tight
     * @param direction the direction the insect is moving from
     * @return true if it can, false otherwise
     */
    public boolean canSlideTo(int direction){
        return isEmpty(direction-1) || isEmpty(direction+1);
    }


}
