import game.*;

public class Runner {
    public static void main(String args[]) {
        Pokemon p1 = new Pokemon();
        Pokemon p2 = new Pokemon("Charizard (AI)", "Fire", 360, new Move("Dragon Claw", 80), new Move("Flamethrower", 90));

        Battle game = new Battle(p1, p2);
        game.playBattle(true);
    }
}