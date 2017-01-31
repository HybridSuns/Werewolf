package werewolf;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class PerformGame extends JFrame {
	public PerformGame(JTextField jtfPNum) {
		// setLayout(new FlowLayout(FlowLayout.CENTER,10,20));

		// 狼人面板
		JPanel pWolfs = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
		int number = Integer.parseInt(jtfPNum.getText());
		Player[] players = new Player[number + 1];
		for (int i = 1; i < number + 1; i++) {
			players[i] = new Player(i, true, "Player");
			System.out.printf("第%d 玩家加入\n", i);
		}
		pWolfs.add(new JLabel("狼人杀得玩家："));
		JTextField jtfToKill = new JTextField(2);
		pWolfs.add(jtfToKill);
		pWolfs.setBorder(new TitledBorder("狼人面板"));

		// 女巫面板
		JPanel pWitch = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
		// int numToKill = Integer.parseInt(jtfToKill.getText());
		pWitch.add(new JLabel("女巫救人"));
		JCheckBox jcbSave = new JCheckBox("救人");
		pWitch.add(jcbSave);
		JCheckBox jcbPoison = new JCheckBox("毒人");
		pWitch.add(jcbPoison);
		JTextField jtfToPoison = new JTextField(2);
		jtfToPoison.setEditable(false);
		jtfToPoison.setBackground(Color.gray);
		pWitch.add(jtfToPoison);
		jcbPoison.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jcbPoison.isSelected()) {
					jtfToPoison.setEditable(true);
					jtfToPoison.setBackground(Color.white);
				} else {
					jtfToPoison.setEditable(false);
					jtfToPoison.setBackground(Color.gray);
				}
			}
		});
		
		pWitch.setBorder(new TitledBorder("女巫面板"));

		// 预言家面板

		JButton kill = new JButton("确定");
		kill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// WolfKill(numToKill,players);
			}
		});
		setLayout(new GridLayout(2,1,5,5));
		add(pWolfs);
		add(pWitch);

	}

	private void WolfKill(int numToKill, Player[] players) {

	}
}
