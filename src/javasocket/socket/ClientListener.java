package javasocket.socket;


import java.io.*;
import java.net.*;

import javax.swing.SwingUtilities;


public class ClientListener extends Thread {


	private Socket socket=null;
	public  String redDataText = null; 
	public int red = -1;
	public  byte[] redData;
	public ClientListener(ClientInfo aClientInfo) throws IOException {
 
		socket = aClientInfo.mSocket;
		 
	}

	/**
	 * Until interrupted, reads messages from the client socket, forwards them
	 * to the server dispatcher and notifies the server dispatcher.
	 */
	public void run() {	 
		red = -1;  
		final byte[] buffer = new byte[5*1024]; // a read buffer of 5KiB

		try {
			while ((red = socket.getInputStream().read(buffer)) > -1) {

				redData = new byte[red];
				System.arraycopy(buffer, 0, redData, 0, red);
				redDataText = new String(redData,"UTF-8");
				System.out.println("redDataText"+ redDataText);
			}


		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public String getSocketdata(){	 

		return this.redDataText; 
	}
}
