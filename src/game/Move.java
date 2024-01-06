package game;

public class Move {
	private String name;
	private int damage;
	
	public Move(String name, int damage) {
		this.name = name;
		this.damage = damage;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public String toString() {
		return "Move name: " + this.getName() + ", Move damage: " + this.getDamage();
	}
 }