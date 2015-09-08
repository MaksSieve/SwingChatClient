package windows;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.*;

import main.Client;
import threads.ClientThread;
import threads.ServerToUser;
import windowsElements.*;

public class ChatWin implements KeyListener{
	
	ClientThread main = null;
	Window win = null;
	InboxArea inbox = null;
	public OutboxArea outbox = null;
	MainMenuBar mainMenu = null;
	
	Socket serverSocket = null;
	int serverPort = 0;
	InetAddress serverAddr = null;
	OutputStream serverOutput = null;
	
	ServerToUser STU = null;
	
	public ChatWin(ClientThread clientThread) {
		// TODO Auto-generated constructor stub
		main = clientThread;
		
		win = new Window("SwingChat");
		win.setBounds(500, 100, 320, 460);
		win.setLayout(new FlowLayout());
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		inbox = new InboxArea();
		inbox.setText("Enter your message...");
		inbox.setColumns(25);
		inbox.setRows(4);
		inbox.addKeyListener(this);
		
		outbox = new OutboxArea("Welcome to SwingChat by MaksSieve!\n");
		outbox.setEditable(false);
		outbox.setColumns(25);
		outbox.setRows(19);
		//outbox.
		
		JScrollPane inscrl = new JScrollPane(inbox);
		JScrollPane outscrl = new JScrollPane(outbox);
		outscrl.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		mainMenu = new MainMenuBar(this);
	
		win.setJMenuBar(mainMenu);
		win.add(outscrl);
		win.add(inscrl);
		
		win.setResizable(true);
		win.setVisible(true);
	}

	public void connect(String ip, int p){
		int n = 1;
		while(n<=3){
			try{
				serverAddr = serverAddr.getByName(ip);
				serverPort = p;
				serverSocket = new Socket(serverAddr, serverPort);
				serverOutput = serverSocket.getOutputStream();
				outbox.append("Connected to" + serverAddr.getHostAddress() + ":"
						+ serverPort + ".\n");
				break;
			}catch (IOException e){
				this.outbox.append("Cannot connect to " + ip + p + ". Trying again...\n");
				n++;
			}
		}
		if (n>3){
			this.outbox.append("Connection failed try again.");
		}else{
			try{
			STU = new ServerToUser(serverSocket.getInputStream(), outbox);
			}catch(IOException e){
				System.out.println("I/O Exception!");
			}
		}
	}
	
	@Override
	public void keyPressed(KeyEvent ke) {
		int cmd = ke.getKeyCode();
		if (cmd == KeyEvent.VK_ENTER){
			String message = inbox.getText()+"\n";
			inbox.setText(null);
			try {
				if (serverSocket != null){
					serverOutput.write((message).getBytes());
					outbox.append("me ::: " + message);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		
		
	}

}
