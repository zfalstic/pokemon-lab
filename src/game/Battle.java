package game;

public class Battle {
	private Pokemon p1;
	private Pokemon p2;
	
	public Battle(Pokemon p1, Pokemon p2) {
		this.p1 = p1;
		this.p2 = p2;

        System.out.println(this.p1);
        System.out.println(this.p2);
	}
	
	public void playRound() {
		this.getP1().attack(this.getP2());
		if(this.getP2().getHealth() == 0) {
			System.out.println(this.getP2().getName() + " has fainted. " + this.getP1().getName() + " has gained 40 exp.");
			return;
		}
		
		this.getP2().attack(this.getP1());
		if(this.getP1().getHealth() == 0) {
			System.out.println(this.getP1().getName() + " has fainted. " + this.getP2().getName() + " has gained 40 exp.");
			return;
		}
	}

    public void playRound(Boolean AI) {
        if(!AI) {
            this.playRound();
            return;
        }

		this.getP1().attack(this.getP2());
		if(this.getP2().getHealth() == 0) {
			System.out.println(this.getP2().getName() + " has fainted. " + this.getP1().getName() + " has gained 40 exp.");
			return;
		}
        
        this.getP2().attack(this.getP1(), true);
		if(this.getP1().getHealth() == 0) {
			System.out.println(this.getP1().getName() + " has fainted. " + this.getP2().getName() + " has gained 40 exp.");
			return;
		}
	}
	
	public void playBattle() {
		if(this.getP1().getHealth() == 0) {
			return;
		}
		if(this.getP2().getHealth() == 0) {
			return;
		}
		this.playRound();
		this.playBattle();
	}

    public void playBattle(Boolean AI) {
		if(this.getP1().getHealth() == 0) {
			return;
		}
		if(this.getP2().getHealth() == 0) {
			return;
		}
        if(!AI) {
            this.playRound();
		    this.playBattle();
            return;
        }
		this.playRound(AI);
		this.playBattle(AI);
	}
	
	public Pokemon getP1() {
		return this.p1;
	}
	
	public void setP1(Pokemon p1) {
		this.p1 = p1;
	}
	
	public Pokemon getP2() {
		return this.p2;
	}
	
	public void setP2(Pokemon p2) {
		this.p2 = p2;
	}
	
	public String toString() {
		return this.getP1().toString() + "\n" + this.getP2().toString();
	}
}
