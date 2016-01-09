package javasocket.socket;

import java.net.*;
 
import java.io.*;
 

public class SocketServer
{
	public ClientSender clientSender;
	public ClientInfo clientInfo;
	public ServerDispatcher serverDispatcher;
 
	ServerSocket serverSocket = null;
	ClientListener cl;
 
	public    int LISTENING_PORT = 32001; 

	public  SocketServer()
	{
		serverSocket = null;
		try 
		{
		 	 serverSocket = new ServerSocket(LISTENING_PORT);
		 
		}
		catch (IOException se) 
		{
 
		  se.printStackTrace();
			System.exit(-1);
		}
		serverDispatcher = new ServerDispatcher();
	}

	public void ClosePort()
	{
		try {
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	
	
	public void checkAcceptConnections() {
		try  
		{
			Socket socket = serverSocket.accept();
			clientInfo = new ClientInfo();
			clientInfo.mSocket = socket;
			clientSender =
				new ClientSender(clientInfo, serverDispatcher);
			clientInfo.mClientSender = clientSender;
			clientSender.start();
			serverDispatcher.addClient(clientInfo);
			ClientListener cl = new ClientListener(clientInfo);
			cl.start();

		}
		catch (IOException ioe) 
		{
			 ioe.printStackTrace();
		}
	}

	public boolean checkconnection()
	{
		try
		{
			if(!Thread.interrupted())
				return true;
			else
				return false;
		}
		catch(Exception ioe)
		{
			return false; 
		}
		 
	}

	public void WriteSocdata(String In_msg)
	{
		serverDispatcher.sendMessageToAllClients(In_msg);
	}
	
	public String ReadSocdata()
	{
		return  serverDispatcher.getMessagefromAllClients();
	}
	
	public void   GetSocddelay()
	{   
		try {
			Thread.sleep(10);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
			 
		}
	}
}