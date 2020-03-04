import java.awt.*;
import java.util.ArrayList;

/**
 * Implements the insects of the game (the pieces)
 */
public abstract class Insect {

    //public final static int id = 0;
    private Colour colour;
    private Point position; // the (q,r) coordinates of this insect

    public Insect(Colour colour, Point pos){
        this.colour = colour;
        position = pos;
        Board.getTile(pos).addInsect(this);
    }

    public Colour colour(){
        return colour;
    }

    public Point position(){
        return position;
    }

    public int qPos(){
        return position.x;
    }

    public int rPos() {
        return position.y;
    }

    /**
     * Moves the piece to the specified tile if it can
     * @param tile the tile to move to
     * @return returns false if it cannot move here, true if it was successfully moved
     */
    public abstract boolean movePiece(Tile tile);

    /**
     * Checks whether this insect is the top-most insect on it's tile (i.e no insect is on top of it)
     * @return true if no insect is above it, false otherwise
     */
    public boolean isOnTop(){
        return Board.getInsect(position()) == this;
    }

    /**
     * Checks whether this piece would break the hive into two if it were to move
     * @return true if it is illegal to move, false if it is free to move (as long as it satisfies the other conditions)
     */
    public boolean holdsHiveTogether(){
        if (Board.getTile(position).insects() > 1)
            return false;
        ArrayList<Point> insects = Board.insectLocations();
        insects.remove(position); // remove own location, since is the only insect on tile (else it would have returned)
        boolean[] visited = new boolean[insects.size()];

        connected(insects, visited, 0);

        for (boolean visit : visited)
            if (!visit)
                return true;

        return false;
    }

    /**
     * Recursively tries to visit every tile in the list, marking them as visited as it goes along
     * @param insects the list of points relating to the tiles with insects on
     * @param visited an array denoting which indexes of insects have been visited already
     * @param current the current node visited
     */
    private void connected(ArrayList<Point> insects, boolean[] visited, int current){
        visited[current] = true;
        Point[] directions = Tile.directions();
        for (Point direction : directions){
            Point p = new Point(insects.get(current).x + direction.x, insects.get(current).y + direction.y);
            if (insects.contains(p) && !visited[insects.indexOf(p)])
                connected(insects, visited, insects.indexOf(p));
        }
    }

    /**
     * Whether this piece is eligible to move
     * @return true if it can, false otherwise
     */
    public boolean canMove(){
        return isOnTop() && !holdsHiveTogether();
    }

    public enum Colour{
        Black,
        White
    }
}
