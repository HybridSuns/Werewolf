package werewolf;

public class Seer extends Player {
	public Seer() {
		super();
	}

	public Seer(int number, boolean alive) {
		super(number, alive, "Seer");
	}

	public boolean see(Player player) {
		return player.getJob() == "Wolf" ? true : false;
	}
}
