import java.io.*;
import java.net.*;
import java.util.Scanner;

public class FrameClient
{
	public static void main(String [] args)
	{
		final int portNumber = 20100;
		final char delim = '-';

		try(
		Socket socket = new Socket("127.0.0.1", portNumber);
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);)

		{
			Scanner in = new Scanner(System.in);
			String fromUser;
			try
			{
				while(true)
				{
					System.out.print("Enter your message:");
					fromUser = in.nextLine();
					fromUser = fromUser + delim;
					out.println(fromUser);
				}
			}
			catch(Exception ex)
			{
				System.err.println("Something went wrong in sending!");
				System.err.println(ex.getMessage());
			}
		}
		catch(Exception ex)
		{
			System.err.println("Sorry something wrong happened. I need to die");
			ex.printStackTrace();
		}
	}
}
