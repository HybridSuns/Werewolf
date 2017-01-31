package werewolf;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class PerformGame extends JFrame {
	public PerformGame(JTextField jtfPNum) {
		// 玩家进入游戏
		int number = Integer.parseInt(jtfPNum.getText());
		Player[] players = new Player[number + 1];
		for (int i = 1; i < number + 1; i++) {
			players[i] = new Player(i, true, "Citizen");
			System.out.printf("第%d玩家加入,他是%s\n",players[i].getNumber() ,players[i].getJob());
		}

		// 分配职业面板
		JPanel pJob = new JPanel(new GridLayout(6, 3, 5, 5));
		// 分配丘比特
		pJob.add(new JLabel("丘比特号码："));
		JTextField jtfCupidPlayer = new JTextField(8);
		pJob.add(jtfCupidPlayer);
		JButton jbtAddCupid = new JButton("分配丘比特");
		pJob.add(jbtAddCupid);
		jbtAddCupid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] str = jtfCupidPlayer.getText().split(",");
				for (String s : str) {
					players[Integer.parseInt(s)].setJob("Cupid");
					System.out.println(s + "号玩家是丘比特");
				}
			}
		});

		// 分配狼人
		pJob.add(new JLabel("狼人号码："));
		JTextField jtfWolfPlayer = new JTextField(8);
		pJob.add(jtfWolfPlayer);
		JButton jbtAddWolf = new JButton("分配狼人");
		pJob.add(jbtAddWolf);
		jbtAddWolf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] str = jtfWolfPlayer.getText().split(",");
				for (String s : str) {
					players[Integer.parseInt(s)].setJob("Wolf");
					System.out.println(s + "号玩家是狼人");
				}
			}
		});

		// 分配女巫
		pJob.add(new JLabel("女巫号码："));
		JTextField jtfWitchPlayer = new JTextField(8);
		pJob.add(jtfWitchPlayer);
		JButton jbtAddWitch = new JButton("分配女巫");
		pJob.add(jbtAddWitch);
		jbtAddWitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] str = jtfWitchPlayer.getText().split(",");
				for (String s : str) {
					players[Integer.parseInt(s)].setJob("Witch");
					System.out.println(s + "号玩家是女巫");
				}
			}
		});

		// 分配预言家
		pJob.add(new JLabel("预言家号码："));
		JTextField jtfSeerPlayer = new JTextField(8);
		pJob.add(jtfSeerPlayer);
		JButton jbtAddSeer = new JButton("分配预言家");
		pJob.add(jbtAddSeer);
		jbtAddSeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] str = jtfSeerPlayer.getText().split(",");
				for (String s : str) {
					players[Integer.parseInt(s)].setJob("Seer");
					System.out.println(s + "号玩家是预言家");
				}
			}
		});

		// 分配猎人
		
		StringBuilder citizens = new StringBuilder("普通村民是：");
		
		pJob.add(new JLabel("猎人号码："));
		JTextField jtfHunterPlayer = new JTextField(8);
		pJob.add(jtfHunterPlayer);
		JButton jbtAddHunter = new JButton("分配猎人");
		pJob.add(jbtAddHunter);
		JLabel jlciti=new JLabel(citizens.toString());
		jbtAddHunter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] str = jtfHunterPlayer.getText().split(",");
				for (String s : str) {
					players[Integer.parseInt(s)].setJob("Hunter");
					System.out.println(s + "号玩家是猎人");
				}
				// 分配村民
				for (int i = 1; i < number + 1; i++) {
					System.out.println("player: "+players[i]);
					if(players[i].getJob().equals("Citizen")){
						citizens.append(players[i].getNumber()+" ");
					}
				}
				jlciti.setText(citizens.toString());
				
				// 分配完职业后该部分变为不可编辑
				jtfCupidPlayer.setEditable(false);
				jtfWolfPlayer.setEditable(false);
				jtfWitchPlayer.setEditable(false);
				jtfSeerPlayer.setEditable(false);
				jtfHunterPlayer.setEditable(false);
				jbtAddCupid.setVisible(false);
				jbtAddWolf.setVisible(false);
				jbtAddWitch.setVisible(false);
				jbtAddSeer.setVisible(false);
				jbtAddHunter.setVisible(false);
				
			}
		});
		pJob.add(jlciti);
		pJob.setBorder(new TitledBorder("分配职业面板"));

		// 丘比特面板
		JPanel pCupid = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
		pCupid.add(new JLabel("丘比特连的人"));
		JTextField jtfLover1 = new JTextField(2);
		JTextField jtfLover2 = new JTextField(2);
		pCupid.add(jtfLover1);
		pCupid.add(jtfLover2);

		JButton jbtConnect = new JButton("确定");
		pCupid.add(jbtConnect);

		jbtConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int lover1 = Integer.parseInt(jtfLover1.getText());
				int lover2 = Integer.parseInt(jtfLover2.getText());
				players[lover1].setLover(players[lover2]);
				players[lover2].setLover(players[lover1]);
			}
		});
		pCupid.setSize(300, 500);
		pCupid.setBorder(new TitledBorder("丘比特面板"));

		// 狼人面板
		JPanel pWolfs = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
		pWolfs.add(new JLabel("狼人杀的玩家："));
		JTextField jtfToKill = new JTextField(2);
		pWolfs.add(jtfToKill);

		JButton jbtKill = new JButton("确定");
		pWolfs.add(jbtKill);

		jbtKill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kill(jtfToKill, players);
				System.out.println(Integer.parseInt(jtfToKill.getText()) + "玩家的状态是"
						+ players[Integer.parseInt(jtfToKill.getText())].isAlive());
			}
		});
		pWolfs.setSize(300, 50);
		pWolfs.setBorder(new TitledBorder("狼人面板"));

		// 女巫面板
		JPanel pWitch = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
		pWitch.add(new JLabel("女巫救人"));
		JCheckBox jcbSave = new JCheckBox("救人");
		pWitch.add(jcbSave);
		jcbSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jcbSave.isSelected()) {
					WitchSave(jtfToKill, players);
					System.out.println(Integer.parseInt(jtfToKill.getText()) + "玩家的状态是"
							+ players[Integer.parseInt(jtfToKill.getText())].isAlive());
				} else {
					kill(jtfToKill, players);
					System.out.println(Integer.parseInt(jtfToKill.getText()) + "玩家的状态是"
							+ players[Integer.parseInt(jtfToKill.getText())].isAlive());
				}
			}
		});
		JCheckBox jcbPoison = new JCheckBox("毒人");
		pWitch.add(jcbPoison);
		JTextField jtfToPoison = new JTextField(2);
		pWitch.add(jtfToPoison);

		jtfToPoison.setEditable(false);
		jtfToPoison.setBackground(Color.gray);
		JButton jbtPoison = new JButton("毒死他！");
		pWitch.add(jbtPoison);
		jbtPoison.setEnabled(false);
		jcbPoison.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jcbPoison.isSelected()) {
					jtfToPoison.setEditable(true);
					jtfToPoison.setBackground(Color.white);
					jbtPoison.setEnabled(true);
				} else {
					jtfToPoison.setEditable(false);
					jtfToPoison.setBackground(Color.gray);
					jbtPoison.setEnabled(false);
				}
			}
		});
		jbtPoison.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kill(jtfToPoison, players);
				System.out.println(Integer.parseInt(jtfToPoison.getText()) + "玩家的状态是"
						+ players[Integer.parseInt(jtfToPoison.getText())].isAlive());
			}
		});
		pWitch.setSize(300, 50);
		pWitch.setBorder(new TitledBorder("女巫面板"));

		// 预言家面板
		JPanel pSeer = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
		pSeer.add(new JLabel("要验的玩家："));
		JTextField jtfToSee = new JTextField(2);
		pSeer.add(jtfToSee);
		JButton jbtSee = new JButton("验");
		pSeer.add(jbtSee);
		JLabel seeRes = new JLabel("");
		pSeer.add(seeRes);
		jbtSee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numToSee = Integer.parseInt(jtfToSee.getText());
				String seeJob = players[numToSee].getJob();
				System.out.println(numToSee + "号玩家的职业是：" + seeJob);
				if (seeJob.equals("Wolf")) {
					seeRes.setText("他是狼人");
				} else {
					seeRes.setText("他是好人");
				}
			}
		});
		pSeer.setSize(300, 50);
		pSeer.setBorder(new TitledBorder("预言家面板"));
		
		

		// 猎人面板
		JPanel pHunter = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
		pHunter.add(new JLabel("带走的玩家："));
		JTextField jtfToShot = new JTextField(2);
		jtfToShot.setEnabled(false);
		jtfToShot.setBackground(Color.gray);
		pHunter.add(jtfToShot);
		JButton jbtShot = new JButton("开枪！");
		pHunter.add(jbtShot);
		
		jbtShot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numKilled = Integer.parseInt(jtfToKill.getText());
				if(players[numKilled].getJob().equals("Hunter") && !players[numKilled].isAlive()){
					kill(jtfToShot,players);
				}
			}
		});
		pHunter.setSize(300, 50);
		pHunter.setBorder(new TitledBorder("猎人面板"));
		
		JTextArea actions = new JTextArea();
		
		
		setLayout(new GridLayout(3, 1, 5, 5));
		add(pJob);
		add(pCupid);
		add(pWolfs);
		add(pWitch);
		add(pSeer);
		add(pHunter);
	}

	private void kill(JTextField jtfToKill, Player[] players) {
		int numToKill = Integer.parseInt(jtfToKill.getText());
		players[numToKill].setAlive(false);
		if (players[numToKill].isInLove())
			players[numToKill].getLover().setAlive(false);
	}

	private void WitchSave(JTextField jtfToKill, Player[] players) {
		int numToSave = Integer.parseInt(jtfToKill.getText());
		players[numToSave].setAlive(true);
		if (players[numToSave].isInLove())
			players[numToSave].getLover().setAlive(true);
	}
}
