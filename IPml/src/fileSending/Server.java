package fileSending;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server implements Runnable{
	
	ServerSocket serverSocket = null;
	Socket socket = null;
	
	public Server(int portNumber) {
		
		try {
			this.serverSocket = new ServerSocket(portNumber);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run() {
		
		try{
			System.out.println("Waiting for the connection... ");
			socket = serverSocket.accept();
			System.out.println("Connection Accepted : " + socket);
			
			String SaveAs = "";
			Receiver.receiveFile(socket,SaveAs);
			socket.close();
			serverSocket.close();
		}
		
		catch (Exception e) {
			System.out.println("Error in Server!");
			System.out.println(e.getMessage());
		}
	}
	public static void main(String args[])  {
		int portNumber = 6666;
		new Thread(new Server(portNumber)).start();
	}
}
	

