import java.io.*;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Collections;

public class Main
{
	public static void main(String[] args)
	{
		for(int i=0; i<=10; i++)
		{
			System.out.println("====== Test " + i + " ======");
			// Start counting time
			long startTime = System.nanoTime();

			// Parse strucure
			Tree tree = parseStructureFile("../testes/teste" + i);

			// Get balanced arms list
			LinkedList<Node> balanced = tree.getBalancedNodes();
	    	
	    	// Get end time
			long estimatedTime = System.nanoTime() - startTime;
			double time = (double)estimatedTime / 1000000000.0;
			System.out.println("Time: " + time + " seconds");

			// Sort balanced arms
			Collections.sort(balanced);
			System.out.println("Balanced arms: ");
			for(Node n : balanced)
			{
				System.out.print(n.getName() + " ");
			}
			System.out.println();
			System.out.println("====================");
		}
	}

	private static Tree parseStructureFile(String fileName)
	{

		// HashMap used to store read nodes
		HashMap<String, Node> read = new HashMap<String, Node>();

		// HashMap used to store dependencies
		HashMap<String, Node> deps = new HashMap<String, Node>();

		// Final structure we will return
		Tree tree = new Tree();

		// Check if this is our first time reading
		boolean firstTimeReading = true;

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

				// Declare new arm
				Node arm = null;

				// Check if this node is a dependency
				if(deps.containsKey(armName))
				{
					// Do work on reference of dependency
					arm = deps.get(armName);
				}
				// This node is not a dependency
				// Build it "normally"
				else
				{
					arm = new Node(armName);
				}

				// If this is our first time reading an arm
				// Assign it as the root of our tree
				if(firstTimeReading)
				{
					tree.setRoot(arm);
					firstTimeReading = false;
				}

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
					Node n;
					
					// Socket value
					int val = 0;

					// Socket position
					NodePosition pos = NodePosition.MIDDLE;
					if(socketDist < 0)
						pos = NodePosition.LEFT;
					else if(socketDist == 0)
						pos = NodePosition.MIDDLE;
					else if(socketDist > 0)
						pos = NodePosition.RIGHT;

					// Calculate socket distance multiplier
					// (distance multiplier is always positive)
					int distMult = Math.abs(socketDist);

					// If the socket is terminal (is a value)
					if(IsInt(parts[i]))
					{
						// Get the socket data
						val = Integer.parseInt(parts[i]);
						// Create socket
						n = new Node(val, pos, distMult);
					}
					// The socket isn't terminal (is a name)
					else
					{
						// Check if the socket has already been read
						if(read.containsKey(parts[i]))
						{
							// If it has, simply get that node
							n = read.get(parts[i]);
							// Don't forget to update the node's values!
							n.setPosition(pos);
							n.setDistanceMultiplier(distMult);

							// If the current node was the root
							if(tree.getRoot().getName().equals(n.getName()))
							{
								// Update root
								tree.setRoot(arm);
							}
						}
						// The socket hasn't been read yet
						// This is a new dependency
						else
						{
							// Create new socket with a name
							n = new Node(parts[i]);

							// Set position and distance multiplier
							n.setPosition(pos);
							n.setDistanceMultiplier(distMult);

							// Add it to deps socket list
							deps.put(n.getName(), n);
						}
					}

					// Add socket to arm
					arm.addChild(n);

					// Update socket distance
					// (we read from left to right)
					socketDist += 1;
				}

				// Add socket to read list
				read.put(arm.getName(), arm);
			}

			// Close file
			br.close();
		}
		// Throw any exceptions we might have
		catch(Exception e) {
			e.printStackTrace();
		}

		// Return the parsed structure
		return tree;
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