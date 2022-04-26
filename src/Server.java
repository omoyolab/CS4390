import java.net.*;
import java.io.*;

public class Server {

	public static void main(String[] args) {
		 
		Socket socket;
        ServerSocket serverSocket;
        String sendingMSG, recievingMSG;
        PrintStream dataOutput;
        BufferedReader dataInput, keyboard;
        
		try {
			// Create a server Socket
			serverSocket = new ServerSocket(5020);
			System.out.println("Waiting for a client to connect ...");
			
			// Connect to Client Socket
	        socket = serverSocket.accept();
	        System.out.println("Connection established With Client");
	  
	        //For sending data to Client
	        dataOutput = new PrintStream(socket.getOutputStream());
	  
	        // Read Incoming message
	        dataInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	  
	        // Read from Keyboard
	        keyboard = new BufferedReader(new InputStreamReader(System.in));
	        
	        
	        while (true) {
	        	
	            // Read message from Client
	            while ((recievingMSG = dataInput.readLine()) != null) {
	                System.out.println("Client: " +recievingMSG);
	                sendingMSG = keyboard.readLine();
	  
	                // Send message to Client
	                dataOutput.println(sendingMSG);
	            }
	  
	            // Close all connection and exit program
	            dataOutput.close();
	            dataInput.close();
	            keyboard.close();
	            serverSocket.close();
	            socket.close();
	  
	            System.exit(0);
	            System.out.println("Connection has been terminated by the Client");
	        }
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
		}
  
        
	}

}
