package functionality;

import java.io.*;
import java.net.*;

public class Server {
	public static void main(String[] args) throws IOException {
		// create server socket on port 8080
	    ServerSocket serverSocket = new ServerSocket(8080);
	    Socket clientSocket;
	
	    // handles client connection
	    while (true) {
	    	try {
	    		System.out.println("Incoming client connection request");
	    		clientSocket = serverSocket.accept();
	    	} catch (IOException e) {
	    		System.out.println("Client failed to connect");
	    		break;
	    	}
			
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String inputLine;
				// handles client command
		    	while ((inputLine = in.readLine()) != null) {
			        System.out.println("Received command: " + inputLine);
			        // terminate if "shutdown" is issued
			        if (inputLine.equals("shutdown")) {
				        serverSocket.close();
				        System.exit(0);
			        }
		    	}
		    in.close();
			clientSocket.close();
	    }
	}
}