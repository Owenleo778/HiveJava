import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Board {

    public static Map<Point, Tile> tiles = new HashMap<>(); // A hashmap of tiles

    public static boolean tileExists(int q, int r){
        return tiles.containsKey(new Point(q,r));
    }

    public static Tile getTile(int q, int r){
        if (tileExists(q, r))
            return tiles.get(new Point(q, r));
        return null;
    }

}
