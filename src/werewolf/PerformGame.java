package werewolf;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class PerformGame extends JFrame {
	int round = 1;

	public PerformGame(JTextField jtfPNum) {

		JTextArea actionsRec = new JTextArea();
		JTextField jtfToShot = new JTextField(2); // 猎人要带走的玩家
		JButton jbtShot = new JButton("开枪！"); // 猎人执行开枪
		jtfToShot.setEnabled(false);
		jbtShot.setEnabled(false);

		actionsRec.append("---------第" + round + "晚---------\n\n");

		// 玩家进入游戏
		int number = Integer.parseInt(jtfPNum.getText());
		Player[] players = new Player[number + 1];
		for (int i = 1; i < number + 1; i++) {
			players[i] = new Player(i, true, "Citizen");
			//System.out.printf("第%d玩家加入,他是%s\n\n", players[i].getNumber(), players[i].getJob());
			// actionsRec.append("第%d玩家加入,他是%s\n\n",players[i].getNumber()
			// ,players[i].getJob());
		}
		
		// 玩家状态面板
		JPanel pPlayStat = new JPanel(new FlowLayout(FlowLayout.CENTER,5,5));
		JLabel[] lPlayerSt = new JLabel[number+1];
		for(int i=1;i<number+1;i++){
			lPlayerSt[i] = new JLabel(players[i].getNumber()+": 待定");
			lPlayerSt[i].setBorder(BorderFactory.createEtchedBorder());
			pPlayStat.add(lPlayerSt[i]);
		}
		pPlayStat.setBorder(new TitledBorder("玩家状态"));
		
		
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
					players[Integer.parseInt(s)].setColor(Color.blue);
					lPlayerSt[Integer.parseInt(s)].setForeground(Color.blue);
					lPlayerSt[Integer.parseInt(s)].setText(s+": 丘比特");
					//System.out.println(s + "号玩家是丘比特");
					actionsRec.append(s + "号玩家是丘比特\n\n");
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
					
					players[Integer.parseInt(s)].setColor(Color.red);
					lPlayerSt[Integer.parseInt(s)].setForeground(Color.red);
					lPlayerSt[Integer.parseInt(s)].setText(s+": 狼人");
					//System.out.println(s + "号玩家是狼人");
					actionsRec.append(s + "号玩家是狼人\n\n");
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
					players[Integer.parseInt(s)].setColor(new Color(255,0,255));
					lPlayerSt[Integer.parseInt(s)].setForeground(new Color(255,0,255));
					lPlayerSt[Integer.parseInt(s)].setText(s+": 女巫");
					//System.out.println(s + "号玩家是女巫");
					actionsRec.append(s + "号玩家是女巫\n\n");
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
					players[Integer.parseInt(s)].setColor(Color.orange);
					lPlayerSt[Integer.parseInt(s)].setForeground(Color.orange);
					lPlayerSt[Integer.parseInt(s)].setText(s+": 预言家");
					//System.out.println(s + "号玩家是预言家");
					actionsRec.append(s + "号玩家是预言家\n\n");
				}
			}
		});

		// 分配猎人
		StringBuilder citizens = new StringBuilder("");
		pJob.add(new JLabel("猎人号码："));
		JTextField jtfHunterPlayer = new JTextField(8);
		pJob.add(jtfHunterPlayer);
		JButton jbtAddHunter = new JButton("分配猎人");
		pJob.add(jbtAddHunter);

		JTextField jtfciti = new JTextField(8);
		jtfciti.setEditable(false);
		jbtAddHunter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] str = jtfHunterPlayer.getText().split(",");
				for (String s : str) {
					players[Integer.parseInt(s)].setJob("Hunter");
					players[Integer.parseInt(s)].setColor(Color.green);
					lPlayerSt[Integer.parseInt(s)].setForeground(Color.green);
					lPlayerSt[Integer.parseInt(s)].setText(s+":  猎人");
					//System.out.println(s + "号玩家是猎人");
					actionsRec.append(s + "号玩家是猎人\n\n");
				}
				// 分配村民

				for (int i = 1; i < number + 1; i++) {
					//System.out.println("player: " + players[i]);
					if (players[i].getJob().equals("Citizen")) {
						lPlayerSt[i].setText(i+":  村民");
						citizens.append(players[i].getNumber() + " ");
					}
				}
				jtfciti.setText(citizens.toString());
				actionsRec.append(citizens.toString() + " 号玩家是普通村民\n\n");

				// 分配完职业后该部分变为不可编辑
				jtfCupidPlayer.setEditable(false);
				jtfWolfPlayer.setEditable(false);
				jtfWitchPlayer.setEditable(false);
				jtfSeerPlayer.setEditable(false);
				jtfHunterPlayer.setEditable(false);
				jbtAddCupid.setEnabled(false);
				jbtAddWolf.setEnabled(false);
				jbtAddWitch.setEnabled(false);
				jbtAddSeer.setEnabled(false);
				jbtAddHunter.setEnabled(false);

			}
		});
		pJob.add(new JLabel("普通村民是："));
		pJob.add(jtfciti);
		pJob.setBorder(new TitledBorder("分配职业面板"));

		// 职业操作面板
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
				players[lover1].setInLove(true);
				players[lover2].setLover(players[lover1]);
				players[lover2].setInLove(true);
				//System.out.println("lover1的爱人" + players[lover1].getLover().getNumber());
				jtfLover1.setEditable(false);
				jtfLover2.setEditable(false);
				jbtConnect.setEnabled(false);
				actionsRec.append(lover1 + "号和" + lover2 + "号玩家被丘比特连为情侣\n\n");

			}
		});

		// 狼人面板
		JPanel pWolfs = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
		pWolfs.add(new JLabel("狼人杀的玩家："));
		JTextField jtfToKill = new JTextField(2);
		pWolfs.add(jtfToKill);
		JButton jbtKill = new JButton("确定");
		pWolfs.add(jbtKill);
		jbtKill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = kill(jtfToKill, players);
				lPlayerSt[Integer.parseInt(jtfToKill.getText())].setForeground(Color.gray);
				int hunterNum = Integer.parseInt(jtfHunterPlayer.getText());
				if (Integer.parseInt(jtfToKill.getText()) == hunterNum || n == hunterNum) {
					jtfToShot.setEnabled(true);
					jbtShot.setEnabled(true);
				}
				if (players[Integer.parseInt(jtfToKill.getText())].isInLove()) {
					//System.out.println("情侣死活：" + players[Integer.parseInt(jtfToKill.getText())].getLover().isAlive());
				}
				//System.out.println("n= " + n);
				if (n != 0) {
					lPlayerSt[n].setForeground(Color.gray);
					actionsRec.append(jtfToKill.getText() + "号玩家被狼人杀死。同时" + n + "号玩家殉情\n\n");
				} else {
					actionsRec.append(jtfToKill.getText() + "号玩家被狼人杀死\n\n");
				}
			}
		});

		// 女巫面板
		JPanel pWitch = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
		pWitch.add(new JLabel("女巫救人"));
		JCheckBox jcbSave = new JCheckBox("救人");
		pWitch.add(jcbSave);
		jcbSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jcbSave.isSelected()) {
					int n = WitchSave(jtfToKill, players);
					lPlayerSt[Integer.parseInt(jtfToKill.getText())].setForeground(players[Integer.parseInt(jtfToKill.getText())].getColor());
					int hunterNum = Integer.parseInt(jtfHunterPlayer.getText());
					if (Integer.parseInt(jtfToKill.getText()) == hunterNum || n == hunterNum) {
						jtfToShot.setEnabled(false);
						jbtShot.setEnabled(false);
					}
					if (n != 0) {
						lPlayerSt[n].setForeground(players[n].getColor());
						actionsRec.append(jtfToKill.getText() + "号玩家被女巫救起。同时" + n + "号殉情玩家殉情未遂\n\n");
					} else {
						actionsRec.append(jtfToKill.getText() + "号玩家被女巫救起\n\n");
					}
					jcbSave.setEnabled(false);
					//System.out.println(Integer.parseInt(jtfToKill.getText()) + "玩家的状态是"
							//+ players[Integer.parseInt(jtfToKill.getText())].isAlive());
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
				int n = kill(jtfToPoison, players);
				lPlayerSt[Integer.parseInt(jtfToPoison.getText())].setForeground(Color.gray);
				jtfToPoison.setEditable(false);
				jtfToPoison.setBackground(Color.gray);
				jbtPoison.setEnabled(false);
				int hunterNum = Integer.parseInt(jtfHunterPlayer.getText());
				if (Integer.parseInt(jtfToPoison.getText()) == hunterNum && n != hunterNum) {
					jtfToShot.setEnabled(false);
					jbtShot.setEnabled(false);
				}
				if (n == hunterNum) {
					jtfToShot.setEnabled(true);
					jbtShot.setEnabled(true);
				}
				if (n != 0) {
					lPlayerSt[n].setForeground(Color.gray);
					actionsRec.append(jtfToPoison.getText() + "号玩家被女巫毒死。同时" + n + "号玩家殉情\n\n");
				} else {
					actionsRec.append(jtfToPoison.getText() + "号玩家被女巫毒死\n\n");
				}
			}
		});

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
				actionsRec.append("预言家发现" + jtfToSee.getText() + "号玩家是" + seeJob + "\n\n");
				//System.out.println(numToSee + "号玩家的职业是：" + seeJob);
				if (seeJob.equals("Wolf")) {
					seeRes.setText("他是狼人");
					seeRes.setForeground(Color.red);
				} else {
					seeRes.setText("他是好人");
					seeRes.setForeground(Color.blue);
				}
			}
		});

		// 猎人面板
		JPanel pHunter = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
		pHunter.add(new JLabel("猎人要打死的玩家："));
		pHunter.add(jtfToShot);
		pHunter.add(jbtShot);

		jbtShot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = kill(jtfToShot, players);
				lPlayerSt[Integer.parseInt(jtfToShot.getText())].setForeground(Color.gray);
				if (n != 0) {
					lPlayerSt[n].setForeground(Color.gray);
					actionsRec.append(jtfToShot.getText() + "号玩家被猎人开枪打死。同时" + n + "号玩家殉情\n\n");

				} else {
					actionsRec.append(jtfToShot.getText() + "号玩家被猎人开枪打死\n\n");
				}

			}
		});

		JButton jbtNext = new JButton("下一晚");
		jbtNext.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				round++;
				actionsRec.append("\n\n------------第" + round + "晚------------\n\n");
				StringBuilder sb = new StringBuilder();
				for (int i = 1; i < number + 1; i++) {
					if (players[i].isAlive())
						sb.append(i + " ");
				}
				actionsRec.append("当前存活玩家：" + sb.toString()+"\n\n");
			}
		});
		
		
		
		
		

		actionsRec.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(actionsRec);
		JPanel pActions = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel left = new JPanel(new GridLayout(1, 1, 5, 5));
		JPanel right = new JPanel(new GridLayout(3, 1, 5, 5));

		left.add(scrollPane);
		right.add(pJob);
		right.add(pActions);
		right.add(pPlayStat);
		left.setBorder(new TitledBorder("游戏记录"));
		right.setBorder(new TitledBorder("操作"));

		pActions.add(pCupid);
		pActions.add(new JSeparator(SwingConstants.VERTICAL));
		// pActions.add(new JSeparator());
		pActions.add(pWolfs);
		pActions.add(new JSeparator(SwingConstants.VERTICAL));
		// pActions.add(new JSeparator());
		pActions.add(pWitch);
		pActions.add(new JSeparator(SwingConstants.VERTICAL));
		// pActions.add(new JSeparator());
		pActions.add(pSeer);
		pActions.add(new JSeparator(SwingConstants.VERTICAL));
		// pActions.add(new JSeparator());
		pActions.add(pHunter);
		pActions.add(new JSeparator(SwingConstants.VERTICAL));
		// pActions.add(new JSeparator());
		pActions.add(jbtNext);
		pActions.setBorder(new TitledBorder("职业操作"));

		setLayout(new GridLayout(1, 2, 5, 5));
		add(left);
		add(right);

	}

	private int kill(JTextField jtfToKill, Player[] players) {
		int numToKill = Integer.parseInt(jtfToKill.getText());
		players[numToKill].setAlive(false);
		if (players[numToKill].isInLove()) {
			players[numToKill].getLover().setAlive(false);
			return players[numToKill].getLover().getNumber();
		} else {
			return 0;
		}
	}

	private int WitchSave(JTextField jtfToKill, Player[] players) {
		int numToSave = Integer.parseInt(jtfToKill.getText());
		players[numToSave].setAlive(true);
		if (players[numToSave].isInLove()) {
			players[numToSave].getLover().setAlive(true);
			return players[numToSave].getLover().getNumber();
		} else {
			return 0;
		}
	}
}
