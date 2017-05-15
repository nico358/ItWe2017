package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP{
	
	public ServerTCP(){
		server();
	}
	
	private void server(){
		//create server socket with PORT Nr
		try(ServerSocket servSock = new ServerSocket(8080)){
			System.out.println("Server listens...");
			//continuous listening for incoming calls
			while(true){
					//do not use try with resources     try(...){...}
				    //otherwise the socket will be closed immediately after passing to the threaded class
				    //causes socket exception
					try{
						//create client socket for handling an incoming call, accept() provides a socket object
						Socket socket = servSock.accept();
						System.out.println("Server accepted...");
						// instantiate new ClientThread object and passes the socket object
						ClientThread ct = new ClientThread(socket);
						// create new Thread for ClientThread obj and start
						new Thread(ct).start();
					}catch(Exception e1){
						e1.printStackTrace();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
