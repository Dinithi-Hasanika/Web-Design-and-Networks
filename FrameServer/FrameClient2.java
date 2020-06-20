import java.io.*;
import java.net.*;
import java.util.Scanner;

public class FrameClient2
{
	public static void main(String [] args)
	{
		final int portNumber = 20100;
		final char delim = '-';
		try
		(
		Socket socket = new Socket("127.0.0.1", portNumber);
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		)
		{
			Scanner in = new Scanner(System.in);
			System.out.println("Enter your message part by part. Enter 'End' to end the message and start the next");
			int number = 0;
			int part = 0;
			String fromUser;
			StringBuffer message = new StringBuffer();
			while(true)
			{		
				part=0;	
				while(true)
				{
					System.out.print("Enter your message "+number+" part "+part+":");
					fromUser = in.nextLine();
					if(fromUser.equals("End"))
						break;
					message.append(fromUser);
					message.append('\n');
					part++;
				}
				System.out.println("----------------------");
				System.out.println(message.toString());
				System.out.println("----------------------");
				number++;
				out.println(message.toString());
			}
		}
		catch(Exception ex)
		{
			System.err.println("Sorry something wicked happened and need to die");
		}
	}
}

