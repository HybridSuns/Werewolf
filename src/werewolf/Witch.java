package werewolf;

/**
 * 女巫
 * 
 * @author litia
 *
 */
public class Witch extends Player {
	
	public Witch() {
		super();
	}

	public Witch(int number, boolean alive) {
		super(number, alive,"Witch");
	}

	

	public void save(Player playerToSave) {
		playerToSave.setAlive(true);
		System.out.println("女巫救了" + playerToSave.getNumber() + "号玩家");
	}

}
