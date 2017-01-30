package werewolf;


/**
 * 普村
 * number 玩家编号
 * alive 是否存活
 * @author litia
 *
 */
public class Citizen extends Player{
	
	public Citizen(){
		super();
	}
	public Citizen(int number,boolean alive){
		super(number,alive,"Citizen");
	}
}
