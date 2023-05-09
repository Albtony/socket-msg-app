package functionality;

import java.io.*;
import java.net.*;

public class Server {
	public static void main(String[] args) throws IOException {
		// create server socket on port 8080
	    ServerSocket serverSocket = new ServerSocket(8080);
	
	    // handles client connection
	    while (true) {
			Socket clientSocket = serverSocket.accept();
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