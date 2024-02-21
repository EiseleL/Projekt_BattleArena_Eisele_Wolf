package BattleArena;

import java.util.Scanner;

public class Arena {
	private FighterCharacter f1;
	private FighterCharacter f2;
	private FighterCharacter Winner;
	private boolean SelectedFighter;

	public Arena(FighterCharacter f1, FighterCharacter f2) {
		super();
		this.f1 = f1;
		this.f2 = f2;
		Winner = null;
		randomFighter();
	}

	public FighterCharacter getF1() {
		return f1;
	}

	public void setF1(FighterCharacter f1) {
		this.f1 = f1;
	}

	public FighterCharacter getF2() {
		return f2;
	}

	public void setF2(FighterCharacter f2) {
		this.f2 = f2;
	}

	public FighterCharacter getWinner() {
		return Winner;
	}

	public void setWinner(FighterCharacter winner) {
		Winner = winner;
	}

	/**
	 * This method randomly decides which Fighter has the first move
	 * 
	 * @return true or false value
	 */
	private boolean randomFighter() {
		double random = Math.random();
		if (random > 0.4) {
			return false;
		} else
			return true;
	}

	/**
	 * This Method will run until the game has detected a winner
	 */
	public void fight() {
		FighterCharacter attacker;
		FighterCharacter victim;
		do {
			if (this.SelectedFighter) {
				attacker = f1;
				victim = f2;
			} else {
				attacker = f2;
				victim = f1;
			}

			simulateCombat(attacker, victim);

			Winner = checkWinner();
			this.SelectedFighter = !this.SelectedFighter;
		} while (Winner == null);
	}

	/**
	 * this Method checks if there is a player witch 0 hearts - if that so the other
	 * player wins
	 * 
	 * @return the player which wins the game - if null there is no winner
	 */
	private FighterCharacter checkWinner() {
		if (f1.getHealth() <= 0) {
			return f2;
		} else if (f2.getHealth() <= 0) {
			return f1;
		} else
			return null;
	}

	/**
	 * 
	 * @param attacker lets the method know that this player is on his move
	 * @param victim   this is the other player which could be attacked by the
	 *                 attacker
	 */
	public void simulateCombat(FighterCharacter attacker, FighterCharacter victim) {
		System.out.println(attacker.getName() + " ist an der Reihe");
		System.out.println("Bitte geben Sie ihren Zug an(1=angreifen, 2=Fähigkeitsstatus umschalten");
		String Input = ConsoleInput();
		switch (Input) {
		case "1": // angreifen
			int value = attacker.attack();
			victim.gotDamage(value);
			break;
		case "2": // togglen
			if (attacker.isSpecialAbilityActive()) {
				attacker.activateAbility();
			} else {
				attacker.activateAbility();
			}

			break;
		}

	}

	/**
	 * This method will create a Scanner an get the String Input from the console
	 * form the user
	 * 
	 * @return the value which was scanned
	 */
	private String ConsoleInput() {
		Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine();
		scanner.close();
		return a;
	}

	/**
	 * This method will print out the Info from the players to the console
	 */
	public void printInfo() {
		System.out.println("Info " + f1.getName() + ": \t" + f1 + "\n");
		System.out.println("Info " + f2.getName() + ": \t" + f2);
	}

}
