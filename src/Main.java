public class Main {

    public static void main(String[] args) {
        Tile t = new Tile();
        Insect a = new Ant(Insect.Colour.White);
        t.addInsect(a);
        t.getTile(1).addInsect(a);
        t.getTile(0).addInsect(a);

        for (int dir = 0; dir < 6; dir++){
            System.out.println(t.getTile(dir).id() + ", " + t.getTile(1).getTile(dir).id() + ", " + t.getTile(0).getTile(dir).id());
        }
    }
}
