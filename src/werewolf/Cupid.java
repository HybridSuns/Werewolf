package werewolf;

/**
 * 丘比特
 * @author litia
 *
 */
public class Cupid extends Player{
	public Cupid(){
		super();
	}
	public Cupid(int number, boolean alive){
		super(number, alive,"Cupid");
	}
	public void connect(Player p1, Player p2){
		p1.inLoveWith(p2);
		p2.inLoveWith(p1);
	}
}
