package threads;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import main.Client;
import windows.ChatWin;

public class ClientThread implements Runnable {
	
	ChatWin chat = null;
	
	public ClientThread () {

	}

	@Override
	public void run() {
		chat = new ChatWin(this);
	}
	
	
	
}
