package werewolf;

/**
 * 玩家对象 number 玩家编号 alive 是死是活
 * 
 * @author litian
 *
 */
public class Player {
	private int number;
	private boolean alive;
	private boolean inLove;
	private Player lover;
	private boolean isPolice;
	private String job;

	public Player() {
		this.number = -1;
		this.alive = false;
		this.inLove=false;
		this.lover=null;
		this.isPolice=false;
		this.job="N/A";
	}

	public Player(int number, boolean alive,String job) {
		this.number = number;
		this.alive = alive;
		this.inLove=false;
		this.lover=null;
		this.isPolice=false;
		this.job=job;
	}

	/**
	 * 被丘比特连
	 * @param lover
	 */
	public void inLoveWith(Player lover) {
		this.setInLove(true);
		this.setLover(lover);
	}
	
	/**
	 * 获得警徽
	 */
	public void becomePolice(){
		this.setPolice(true);
	}
	
	/**
	 * 给警徽
	 * @param nextPolice
	 */
	public void givePolice(Player nextPolice){
		this.setPolice(false);
		nextPolice.becomePolice();
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public boolean isInLove() {
		return inLove;
	}

	public void setInLove(boolean inLove) {
		this.inLove = inLove;
	}

	public Player getLover() {
		return lover;
	}

	public void setLover(Player lover) {
		this.lover = lover;
	}

	public boolean isPolice() {
		return isPolice;
	}

	public void setPolice(boolean isPolice) {
		this.isPolice = isPolice;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
}
