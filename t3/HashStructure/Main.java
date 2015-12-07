import java.io.*;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Collections;

public class Main
{
	public static void main(String[] args)
	{
		for(int i=0; i<=0; i++)
		{
			System.out.println("====== Test " + i + " ======");
			// Start counting time
			long startTime = System.nanoTime();

			// Parse strucure
			Structure s = parseStructureFile("../testes/teste" + i);

			// Get balanced arms list
			LinkedList<Arm> balancedArms = s.getBalancedArms();
	    	
	    	// Get end time
			long estimatedTime = System.nanoTime() - startTime;
			double time = (double)estimatedTime / 1000000000.0;
			System.out.println("Time: " + time + " seconds");

			// Sort balanced arms
			Collections.sort(balancedArms);
			System.out.println("Balanced arms: ");
			for(Arm a : balancedArms)
			{
				System.out.print(a.getName() + " ");
			}
			System.out.println();
			System.out.println("====================");
		}
	}

	private static Structure parseStructureFile(String fileName)
	{
		// Final structure we will return
		Structure structure = new Structure();

		// Surround with try-catch 
		// for exception handling when opening/reading file
		try
		{

			// Open file
			BufferedReader br = new BufferedReader(new FileReader(fileName));

			// Auxiliary string
			String line;

			// Get the number of arms (always in first line)
			line = br.readLine();
			int numArms = Integer.parseInt(line);

			// While there are still unread lines
			while((line = br.readLine()) != null)
			{
				// The information is split by spaces
				String[] parts = line.split(" ");
				// The first info is the arm's name
				String armName = parts[0];
				// The second info is the number of sockets 
				int numSockets = Integer.parseInt(parts[1]);

				// Create new arm
				Arm a = new Arm(armName);

				// Get middle socket position
				int middle = (numSockets/2);

				// Socket distance
				// Negative for left sockets
				// Positive for right rockets
				// Initialize with left-most distance
				int socketDist = -middle;

				// Iterate through arm's sockets
				// Start at 2 (- arm name & num of sockets)
				for(int i=2; i<parts.length; i++)
				{
					// Auxiliary socket
					Socket s;
					
					// Socket value
					int val = 0;

					// Socket position
					SocketPosition pos = SocketPosition.MIDDLE;
					if(socketDist < 0)
						pos = SocketPosition.LEFT;
					else if(socketDist == 0)
						pos = SocketPosition.MIDDLE;
					else if(socketDist > 0)
						pos = SocketPosition.RIGHT;

					// Calculate socket distance multiplier
					// (distance multiplier is always positive)
					int distMult = Math.abs(socketDist);

					// If the socket is terminal (is a value)
					if(IsInt(parts[i]))
					{
						// Get the socket data
						val = Integer.parseInt(parts[i]);
						// Create new socket
						s = new Socket(val, distMult, pos);
					}
					// The socket isn't terminal (is a name)
					else
					{
						// Create new socket with a name
						s = new Socket(val, distMult, pos, parts[i]);
					}

					// Add socket to arm
					a.addSocket(s);

					// Update socket distance
					// (we read from left to right)
					socketDist += 1;
				}

				// Add arm to structure
				structure.addArm(a);
			}

			// Close file
			br.close();
		}
		// Throw any exceptions we might have
		catch(Exception e) {
			e.printStackTrace();
		}

		// Return the parsed structure
		return structure;
	}

	private static boolean IsInt(String str)
 	{
		try
		{
			Integer.parseInt(str);
			return true;
		}
		catch(NumberFormatException nfe)
		{
			return false;
		}
 	}

}