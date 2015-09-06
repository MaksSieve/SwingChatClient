package main;
import javax.swing.*;

import threads.ClientThread;
import windows.*;

import java.net.*;


public class Client {
		
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new ClientThread());
	}

}
