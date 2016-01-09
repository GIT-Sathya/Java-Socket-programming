package javasocket.socket;

 //Socket thread to initiate and accept all client connections using port and IP ref Socket server class.

public class InitSocketRunnable implements Runnable{

	private  SocketServer socserport=null;
  
	 public InitSocketRunnable()
	{
	       this.socserport=new SocketServer();
	}

	@Override
	public void run() {
    
               this.socserport.checkAcceptConnections();
 
	}

	public SocketServer getsockobj() {
		return this.socserport;
	}

}