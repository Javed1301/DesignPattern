public class WarGame {
    public static void main(String[] args) throws Exception {
        System.out.println("----------------WarGame--------------");
        Character king = new King();
        Character knight = new Knight();
        Character queen = new Queen();
        Character troll = new Troll();

        king.fight();
        knight.fight();
        knight.setWeapon(new BowAndArrow());
        knight.fight();
        queen.fight();
        queen.setWeapon(new KnifeBehavior());
        queen.fight();
        troll.fight();


    }
}
