import java.io.*;
import java.net.*;
import java.util.*;

public class FrameServer
{
	public static void main(String args[])
	{
		final char delim = '-';
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
				Scanner in = new Scanner ( clientSocket.getInputStream() ).useDelimiter(delim+"");
				)
				{
					String message;
					try
					{
						while((message = in.next()) != null)
						{
							System.out.println("message: "+message);
						}
					}
					catch(Exception ex)
					{
						System.err.println("Sorry something wrong happened reading from client");
					}
				}
			}
		}
		catch(Exception ex)
		{
			System.err.println("Sorry something wrong happened. I need to die");
			ex.printStackTrace();
		}
	}
}
