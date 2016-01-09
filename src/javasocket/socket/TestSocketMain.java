package javasocket.socket;

public class TestSocketMain {
	public static void main(String args[])
	{
		InitSocketRunnable threadSocket = new InitSocketRunnable();
		Thread thread = new Thread(threadSocket);
		thread.start();
		if( threadSocket.getsockobj()!=null){
		System.out.println("Reading from all connected clients=" + threadSocket.getsockobj().ReadSocdata());
		System.out.println("Writing to all connected clients");
		threadSocket.getsockobj().WriteSocdata("Run");}
		
	}

}
