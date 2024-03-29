package BattleArena;

import java.util.concurrent.ThreadLocalRandom;

public class Dragon extends FighterCharacter {

	public Dragon(String name) {
		super(name);
		
	}
	
	public String getClassName() {
		return "Dragon";
	}

	/**
	 * Method calculate the attack Number for Dragon
	 */
	public int attack() {
		int attackNumber = ThreadLocalRandom.current().nextInt(20,25+1);
		if(this.isSpecialAbilityActive()) {
			return attackNumber -= ThreadLocalRandom.current().nextInt(5,10+1);
		}else {
			return attackNumber;
		}
	}
	
	/**
	 * Method set ability to true and give 10 bonus health points
	 */
	public boolean activateAbility() {
		this.setSpecialAbilityActive(true);
		this.setBonushealth(getBonushealth()+10);
		return true;
	}
	
	/**
	 * Method set ability to false and removed 10 bonus health points
	 */
	public boolean deactivateAbility() {
		this.setSpecialAbilityActive(false);
		if(((this.getBonushealth() - 10) >= 0)) {
			this.setBonushealth(getBonushealth()-10);
		}else {
			this.setBonushealth(0);
		}
		return true;
	}
}