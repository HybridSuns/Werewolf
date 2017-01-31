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
			players[i] = new Player(i, true, "Player");
			System.out.printf("第%d 玩家加入\n", i);
		}
	
		// 狼人面板
		JPanel pWolfs = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
		pWolfs.add(new JLabel("狼人杀的玩家："));
		JTextField jtfToKill = new JTextField(2);
		pWolfs.add(jtfToKill);
		
		JButton jbtKill = new JButton("确定");
		pWolfs.add(jbtKill);
		
		jbtKill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WolfKill(jtfToKill,players);
				System.out.println(Integer.parseInt(jtfToKill.getText())+"玩家的状态是"+players[Integer.parseInt(jtfToKill.getText())].isAlive());
			}
		});
		pWolfs.setBorder(new TitledBorder("狼人面板"));
		
		// 女巫面板
		JPanel pWitch = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
		pWitch.add(new JLabel("女巫救人"));
		JCheckBox jcbSave = new JCheckBox("救人");
		pWitch.add(jcbSave);
		jcbSave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(jcbSave.isSelected()){
					WitchSave(jtfToKill,players);
					System.out.println(Integer.parseInt(jtfToKill.getText())+"玩家的状态是"+players[Integer.parseInt(jtfToKill.getText())].isAlive());	
				}
				else{
					WolfKill(jtfToKill,players);
					System.out.println(Integer.parseInt(jtfToKill.getText())+"玩家的状态是"+players[Integer.parseInt(jtfToKill.getText())].isAlive());	
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
		jbtPoison.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				WitchPoison(jtfToPoison,players);
				System.out.println(Integer.parseInt(jtfToPoison.getText())+"玩家的状态是"+players[Integer.parseInt(jtfToPoison.getText())].isAlive());
			}
		});
		pWitch.setBorder(new TitledBorder("女巫面板"));

		// 预言家面板
		JPanel pSeer = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
		pSeer.add(new JLabel("要验的玩家："));
		JTextField jtfNumToSee = new JTextField(2);
		pSeer.add(jtfNumToSee);
		JButton jbtSee = new JButton("验");
		pSeer.add(jbtSee);
		JLabel seeRes = new JLabel("");
		pSeer.add(seeRes);
		jbtSee.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int numToSee = Integer.parseInt(jtfNumToSee.getText());
				String seeJob = players[numToSee].getJob();
				System.out.println(numToSee+"号玩家的职业是："+seeJob);
				if(seeJob.equals("Wolf")){
					seeRes.setText("他是狼人");
				} else{
					seeRes.setText("他是好人");
				}
			}
		});
		setLayout(new GridLayout(3,1,5,5));
		add(pWolfs);
		add(pWitch);
		add(pSeer);
	}

	private void WolfKill(JTextField jtfToKill, Player[] players) {
		int numToKill=Integer.parseInt(jtfToKill.getText());
		players[numToKill].setAlive(false);
		if(players[numToKill].isInLove())
			players[numToKill].getLover().setAlive(false);
	}
	
	private void WitchPoison(JTextField jtfToPoison, Player[] players){
		int numToPosion = Integer.parseInt(jtfToPoison.getText());
		players[numToPosion].setAlive(false);
		if(players[numToPosion].isInLove())
			players[numToPosion].getLover().setAlive(false);
	}
	
	private void WitchSave(JTextField jtfToKill, Player[] players){
		int numToSave = Integer.parseInt(jtfToKill.getText());
		players[numToSave].setAlive(true);
		if(players[numToSave].isInLove())
			players[numToSave].getLover().setAlive(true);
	}
}
