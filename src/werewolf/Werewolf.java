package werewolf;

import java.util.*;
import java.io.*;

public class Werewolf {
	// static ArrayList<Player> array = new ArrayList<Player>();

	public static void main(String[] args) {
		Hashtable<Integer, Player> table = new Hashtable<>();
		// 分配职业
		System.out.println("输入狼人玩家编号：");
		for (String f : input()) {
			int number = Integer.parseInt(f);
			table.put(number, new Wolf(number, true));
		}

		System.out.println("输入丘比特玩家编号：");
		int num = Integer.parseInt(input()[0]);
		Cupid cupid = new Cupid(num, true);
		table.put(num, cupid);

		System.out.println("输入女巫玩家编号：");
		num = Integer.parseInt(input()[0]);
		Witch witch = new Witch(num, true);
		table.put(num, witch);

		System.out.println("输入与预言家玩家编号：");
		num = Integer.parseInt(input()[0]);
		Seer seer = new Seer(num, true);
		table.put(num, seer);

		System.out.println("输入猎人玩家编号：");
		num = Integer.parseInt(input()[0]);
		Hunter hunter = new Hunter(num, true);
		table.put(num, hunter);

		System.out.println("输入村民玩家编号：");
		for (String f : input()) {
			int number = Integer.parseInt(f);
			table.put(number, new Citizen(number, true));
		}

		// 第一晚上
		System.out.println("\n丘比特连人");
		String[] lovers = input();
		Player p1 = table.get(Integer.parseInt(lovers[0]));
		Player p2 = table.get(Integer.parseInt(lovers[1]));
		cupid.connect(p1, p2);

		String goon = "yes";
		while (goon.equals("yes")) {
			System.out.println("当前在场玩家：");
			for(Map.Entry<Integer, Player> entry:table.entrySet()){
				if(entry.getValue().isAlive()){
					System.out.println(entry.getKey()+"号"+entry.getValue().getJob());
				}
			}
			night(witch, seer, hunter, table);
			System.out.println("继续游戏请输入yes\n\n");
			goon = input()[0];
		}

	}

	public static void night(Witch witch, Seer seer, Hunter hunter, Hashtable<Integer, Player> table) {
		ArrayList<Integer> dieList = new ArrayList<>();
		System.out.println("狼人杀人");
		int numberKilled = Integer.parseInt(input()[0]);
		Player killed = table.get(numberKilled);

		int poisonNumber = 0;
		String save = "";
		if (witch.isAlive() || numberKilled == witch.getNumber()) {
			System.out.println("女巫救人吗? (yes/no)");
			save = input()[0];
			if (save.equals("yes")) {
				witch.save(killed);
			}
			System.out.println("女巫杀人吗? (yes/no)");
			String poison = input()[0];

			if (poison.equals("yes")) {
				System.out.println("输入毒死的号码");
				poisonNumber = Integer.parseInt(input()[0]);
			}
		}

		if (seer.isAlive() || numberKilled == seer.getNumber()) {
			System.out.println("预言家请验人");
			if (seer.see(table.get(Integer.parseInt(input()[0])))) {
				System.out.println("他是狼人");
			} else {
				System.out.println("他是好人");
			}
		}
		if (!save.equals("yes")){
			kill(killed, dieList);
			if(numberKilled==hunter.getNumber())
				hunter.setShot(true);
		}
		if (poisonNumber != 0)
			kill(table.get(poisonNumber), dieList);

		System.out.println("天亮了，昨天晚上死的是：");
		for (int i : dieList) {
			System.out.print(i + ", ");
		}

		if (hunter.isShot()) {
			System.out.println("猎人杀人");
			kill(table.get(Integer.parseInt(input()[0])), dieList);
		}
	}

	public static String[] input() {
		String s = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			s = (String) br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s.split(",");
	}

	public static void kill(Player player, ArrayList<Integer> dieList) {

		player.setAlive(false);
		dieList.add(player.getNumber());
		if (player.isInLove()) {
			player.getLover().setAlive(false);
			dieList.add(player.getLover().getNumber());
		}

	}

}
