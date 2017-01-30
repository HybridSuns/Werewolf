package werewolf;

/**
 * 狼人对象 number 玩家编号 alive 是死是活
 * 
 * @author litia
 *
 */

public class Wolf extends Player {
	
	
	public Wolf() {

		super();
	}

	public Wolf(int number, boolean alive) {
		super(number, alive,"Wolf");
	}
	
	public void kill(Player playerToKill){
		playerToKill.setAlive(false);
	}
	
	public int vote(Player player){
		//TODO
		return 0;
	}
	
	

}
