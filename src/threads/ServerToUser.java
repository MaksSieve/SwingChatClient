package threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import windowsElements.OutboxArea;

public class ServerToUser implements Runnable {
	public Thread trd = null;
	BufferedReader server = null;
	OutboxArea user = null;
	String message = null;
	int code = 0;
	
	public ServerToUser(InputStream server, OutboxArea user){
		this.server = new BufferedReader(new InputStreamReader(server));
		this.user = user;
		trd = new Thread(this, "ServerToUser");
		trd.start();
	}
		
	@Override
	public void run() {
		try {
			code = listen();
		} catch (IOException e) {
			code = 0;
		}
	}

	private int listen() throws IOException{
		while (true){
			message = server.readLine();
			if (message == "exit") break;
			user.append(message + "\n");
		}
		return 1;
	}
}
