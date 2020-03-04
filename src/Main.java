public class Main {

    public static void main(String[] args) {
        Tile[] tiles = {new Tile(0,0), new Tile(-1,0), new Tile(1, 0), new Tile(0, 1),
                new Tile(0, -1), new Tile(-1, 1), new Tile(1, -1), new Tile(-2, 0), new Tile(0, 2)};
        Insect[] insects = new Insect[9];
        for (int i = 0; i < insects.length; i++){
            insects[i] = new QueenBee(Insect.Colour.Black, tiles[i].id());
        }

        for (int i = 0; i < insects.length; i++){
            System.out.println(insects[i].holdsHiveTogether());
        }
    }
}
