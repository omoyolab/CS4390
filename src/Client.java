// A Java program for a Client
import java.net.*;
import java.io.*;

public class Client
{

	public static void main(String args[]) {
		
		
		
        Socket clientSocket;
        String sendingMSG, recievingMSG;
        DataOutputStream dataOutput;
        BufferedReader dataInput, keyboard;
		try {
			// Create client socket ( I have included my second machines IP address)
			clientSocket = new Socket("192.168.1.166", 5022);
			
			// to send data to the server
	        dataOutput = new DataOutputStream(clientSocket.getOutputStream());
	  
	        // to read data coming from the server
	        dataInput = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	  
	        // to read data from the keyboard
	        System.out.println("Enter Messages");
	        keyboard = new BufferedReader(new InputStreamReader(System.in));
	        
	        
	  
	        //End loop only is client types "exit or Exit"
	        while (!(sendingMSG = keyboard.readLine()).equals("exit") ) {
	  
	            // Send Message to Server
	            dataOutput.writeBytes(sendingMSG + "\n");
	  
	            // Receive and Print message from Server
	            recievingMSG = dataInput.readLine();
	            System.out.println("Server: " + recievingMSG);
	        }
	  
	        //Close all connections
	        dataOutput.close();
	        dataInput.close();
	        keyboard.close();
	        clientSocket.close();	
		} 
		
		
		catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
		}
  
        
	}
}
