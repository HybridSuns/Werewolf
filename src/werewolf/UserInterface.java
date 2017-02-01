package werewolf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserInterface extends JFrame{
	public UserInterface(){
		setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
		
		add(new JLabel("玩家人数： "));
		JTextField jtfPNum = new JTextField(8);
		add(jtfPNum);
		JButton jbtStart = new JButton("开始");
		jbtStart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				ShowGame(jtfPNum);
				
			}
		});
		add(jbtStart);
		
	}
	private void ShowGame(JTextField jtfPNum){
		PerformGame frame = new PerformGame(jtfPNum);
		frame.setTitle("狼人杀");
		frame.setSize(720, 820);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		this.setVisible(false);
	}
	
	public static void main(String[] args){
		UserInterface frame = new UserInterface();
		frame.setTitle("初始化狼人杀");
		frame.setSize(200, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
