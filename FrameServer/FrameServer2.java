import java.io.*;
import java.net.*;
import java.util.*;

public class FrameServer2
{
	public static void main(String args[])
	{
		final int portNumber = 20100;
		try
		{
			ServerSocket serverSocket = new ServerSocket(portNumber);
			while(true)
			{
				try
				(
				Socket clientSocket = serverSocket.accept();
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
				)
				{ 
					while(true)
					{
						Scanner in = new Scanner ( clientSocket.getInputStream());
						String response = in.next();
						while(response != null)
						{
							System.out.println("Message: "+response);
							response = in.next();
						}
					}
				}
				catch(Exception ex)
				{
					System.err.println("Sorry something wicked happened receiving data"); 
				
				}
			}
		}
		catch(Exception ex)
		{
			System.err.println("Sorry something wicked happened. Need to die");
			ex.printStackTrace();
		}
	}
}
