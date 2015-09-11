package windows;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.*;

import windowsElements.*;

public class LoginWin implements KeyListener, FocusListener{
	
	static int defaultPort = 15000;
	static String defaultServer = "localhost";
	
	ChatWin main;
	Window win = null;
	JLabel lnick = null;
	JLabel lip = null;
	JLabel lport = null;
	JTextField nick = null;
	JTextField ip = null;
	JTextField port = null;
	JButton logbut = null;
	
	public LoginWin(ChatWin m) {
		
		main = m;
		
		win = new Window("Login");
		win.setBounds(50, 50, 200, 200);
		win.setLayout(new FlowLayout());
		win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		lnick = new JLabel("Nickname: ");
		lip = new JLabel("Server's ip: ");
		lport = new JLabel("Server's port: ");
		
		ip = new JTextField();
		ip.setText(defaultServer);
		ip.addKeyListener(this);
		ip.setColumns(10);
		ip.addFocusListener(this);
		port = new JTextField();
		port.setText("" + defaultPort);
		port.setColumns(10);
		port.addFocusListener(this);
		logbut = new JButton("Login");
		logbut.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae) {
				connectToServer();
			}
			
		});
		
		win.add(lip);
		win.add(ip);
		win.add(lport);
		win.add(port);
		win.add(logbut);
		
		win.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		int cmd = ke.getKeyCode();
		if (cmd == KeyEvent.VK_ENTER){
			connectToServer();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent ke) {
				
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		
	}
	
	private void connectToServer(){
		String i = ip.getText();
		int p = Integer.parseInt(port.getText());
		win.dispose();
		this.main.connect(i, p);
		
	}

	@Override
	public void focusGained(FocusEvent fe) {
		((JTextField) fe.getSource()).setText(null);
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
