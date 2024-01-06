import game.*;

public class Runner {
	public static void main(String args[]) {
		Pokemon p1 = new Pokemon("Pikachu", "Electric", 180, new Move("Thunder Shock", 40), new Move("Zap Cannon", 120));
		Pokemon p2 = new Pokemon("Raichu", "Electric", 240, new Move("Thunder Shock", 50), new Move("Zap Cannon", 150));
		
		Battle game = new Battle(p1, p2);
		game.playBattle();
	}
}
