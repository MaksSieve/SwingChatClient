package windowsElements;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import windows.ChatWin;
import windows.LoginWin;

public class MainMenuBar extends JMenuBar implements ActionListener {
	
	ChatWin win = null;
	
	JMenu Chat = null;
	JMenuItem ChatLogin = null;
	JMenuItem ChatLogout = null;
	JMenuItem ChatClear = null;
	JMenuItem ChatExit = null;
	
	JMenu Help = null;
	JMenuItem HelpAbout = null;
	
	
	public MainMenuBar(ChatWin main) {
		super();
		win = main;
		Chat = new JMenu("Chat");
		ChatLogin = new JMenuItem("Login");
		ChatLogout = new JMenuItem("Logout");
		ChatClear = new JMenuItem("Clear");
		ChatExit = new JMenuItem("Exit");
		ChatClear.addActionListener(this);
		ChatExit.addActionListener(this);
		ChatLogin.addActionListener(this);
		Chat.add(ChatLogin);
		Chat.add(ChatLogout);
		Chat.add(ChatClear);
		Chat.addSeparator();
		Chat.add(ChatExit);
		
		Help = new JMenu("Help");
		HelpAbout = new JMenuItem("About");
		Help.add(HelpAbout);
		
		this.add(Chat);
		this.add(Help);	
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		if (command.equals("Exit")) System.exit(0);
		if (command.equals("Login")) {
			new LoginWin(win);
		}
		if (command.equals("Clear")) win.outbox.setText("");
		
	}

}
