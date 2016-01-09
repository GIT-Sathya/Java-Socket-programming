package javasocket.socket;

/**
*
* ClientInfo class contains information about a client, connected to the server.
*/

import java.awt.List;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

public class ClientInfo
{

   public int userID=-1;
   public Socket mSocket = null;
   public ClientListener mClientListener = null;
   public ClientSender mClientSender = null;
}