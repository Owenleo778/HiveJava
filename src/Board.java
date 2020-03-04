import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Board {

    public static Map<Point, Tile> tiles = new HashMap<>(); // A hashmap of tiles

    public static boolean tileExists(int q, int r){
        return tileExists(new Point(q,r));
    }

    public static boolean tileExists(Point p){
        return tiles.containsKey(p);
    }

    public static Tile getTile(int q, int r){
        return getTile(new Point(q,r));
    }

    public static Tile getTile(Point p){
        if (tileExists(p))
            return tiles.get(p);
        return null;
    }

    public static Insect getInsect(int q, int r){
        return getInsect(new Point(q,r));
    }

    public static Insect getInsect(Point p){
        return getTile(p).getInsect();
    }

    /**
     * Returns a list of points of locations where all insects lie
     * @return the list of coordinates of tiles
     */
    public static ArrayList<Point> insectLocations(){
        ArrayList<Point> insects = new ArrayList<>();
        for (Point p: tiles.keySet()){
            if (getInsect(p) != null){
                insects.add(p);
            }
        }
        return insects;
    }


}
