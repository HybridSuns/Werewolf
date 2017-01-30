package werewolf;

/**
 * 猎人 
 * number 玩家编号
 * alive 是否存活
 * 
 * @author litia
 *
 */
public class Hunter extends Player{
	
	private boolean shot=false;
	
	public Hunter() {
		super();
	}

	public Hunter(int number, boolean alive) {
		super(number,alive,"Hunter");
	}
	
	public void kill(Player playerToKill){
		playerToKill.setAlive(false);
	}

	public boolean isShot() {
		return shot;
	}

	public void setShot(boolean shot) {
		this.shot = shot;
	}

}
