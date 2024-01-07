package game;

import java.util.Scanner;

public class Pokemon {
	private String name;
	private String type;
	private int health;
	private Move move1;
	private Move move2;
	
	private Scanner scan = new Scanner(System.in);

    public Pokemon() {
        System.out.println("Build your Pokemon!");
        System.out.print("Please enter the name of your Pokemon: ");
        this.name = scan.nextLine();
        System.out.print("Please enter the type of your Pokemon: ");
        this.type = scan.nextLine();
        System.out.print("Please enter the health of your Pokemon: ");
        this.health = Integer.parseInt(scan.nextLine());
        System.out.print("Please enter the name of your Pokemon's first move: ");
        String move1Name = scan.nextLine();
        System.out.print("Please enter the damage of your Pokemon's first move: ");
        int move1Damage = Integer.parseInt(scan.nextLine());
        this.move1 = new Move(move1Name, move1Damage);
        System.out.print("Please enter the name of your Pokemon's second move: ");
        String move2Name = scan.nextLine();
        System.out.print("Please enter the damage of your Pokemon's second move: ");
        int move2Damage = Integer.parseInt(scan.nextLine());
        this.move2 = new Move(move2Name, move2Damage);
        System.out.println();
    }
	
	public Pokemon(String name, String type, int health, Move move1, Move move2) {
		this.name = name;
		this.type = type;
		this.health = health;
		this.move1 = move1;
		this.move2 = move2;
	}
	
	public Pokemon(String name, String type, int health, String move1Name, int move1Damage, String move2Name, int move2Damage) {
		this.name = name;
		this.type = type;
		this.health = health;
		this.move1 = new Move(move1Name, move1Damage);
		this.move2 = new Move(move2Name, move2Damage);
	}
	
	public void attack(Pokemon p) {
		System.out.println(this.name + "! Chose your move:");
		System.out.println("1: " + this.move1);
		System.out.println("2: " + this.move2);
		
		char input = scan.nextLine().charAt(0);
        
        System.out.println();
		
		//System.out.println(input);
		while(input != '1' && input != '2') {
			System.out.println("Invalid Input! Please input a valid move number.\n");
			
			System.out.println(this.name + "! Chose your move:");
			System.out.println("1: " + this.move1);
			System.out.println("2: " + this.move2);
			
			input = scan.nextLine().charAt(0);

            System.out.println();
		}
		
		if(input == '1') {
			this.attack(p, this.getMove1());
		} else {
			this.attack(p, this.getMove2());
		}
	}
	
	public void attack(Pokemon p, Move m) {
		p.takeDmg(m.getDamage());
        System.out.println(this.getName() + " used " + m.getName() + " and dealt " + m.getDamage() + " damage.");
        System.out.println(p.getName() + " is now at " + p.getHealth() + " hp.\n");
	}

    public void attack(Pokemon p, Boolean AI) {
        if(!AI) {
            this.attack(p);
            return;
        }

        int rand01 = (int)(Math.random() * 2);
        if(rand01 == 0) {
            this.attack(p, this.getMove1());
        } else {
            this.attack(p, this.getMove2());
        }
    }
	
	public void takeDmg(int amount) {
		this.setHealth(Math.max(this.getHealth() - amount, 0));
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public Move getMove1() {
		return this.move1;
	}
	
	public void setMove1(Move move1) {
		this.move1 = move1;
	}
	
	public Move getMove2() {
		return this.move2;
	}
	
	public void setMove2(Move move2) {
		this.move2 = move2;
	}
	
	public String toString() {
		return this.getName() + " stats:\n" + 
				"Type: " + this.getType() + "\n" +
				"Health: " + this.getHealth() + "\n" +
				"Move 1: " + this.getMove1() + "\n" +
				"Move 2: " + this.getMove2() + "\n";
	}
}
