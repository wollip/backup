package internetSnacke;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class internetServer extends Thread{
	private ServerSocket serverSocket;
	   
	   public internetServer(int port) throws IOException
	   {
	      serverSocket = new ServerSocket(port);
	      serverSocket.setSoTimeout(100000);
	   }

	   public void run()
	   {
	      while(true)
	      {
	         try
	         {
	            System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
	            Socket server = serverSocket.accept();
	            System.out.println("Just connected to " + server.getRemoteSocketAddress());
	            
	            //DataInputStream in = new DataInputStream(server.getInputStream());
	            //System.out.println(in.readUTF());
	            
	            DataOutputStream out = new DataOutputStream(server.getOutputStream());	            
	            //out.writeUTF("1010101010");
	            System.out.println("waiting for message");
	            //DataInputStream in = new DataInputStream(server.getInputStream());
	            BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()));
	            String input = reader.readLine();
	            System.out.println(input);
	            
	            out.writeUTF("this is just a message");
	            
	            server.close();
	         }catch(SocketTimeoutException s)
	         {
	            System.out.println("Socket timed out!");
	            break;
	         }catch(IOException e)
	         {
	            e.printStackTrace();
	            break;
	         }
	      }
	   }
	   public static void main(String [] args)
	   {
	      int port = Integer.parseInt(args[0]);
	      try
	      {
	         Thread t = new internetServer(port);
	         t.start();
	      }catch(IOException e)
	      {
	         e.printStackTrace();
	      }
	   }
}
