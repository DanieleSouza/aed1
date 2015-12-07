import java.util.LinkedList;

public class Arm implements Comparable<Arm>
{
	// Arm name
	private String name;
	// Socket list
	private LinkedList<Socket> sockets;

	public Arm(String name)
	{
		this.name = name;
		sockets = new LinkedList<Socket>();
	}

	public String getName()
	{
		return name;
	}

	public int getArmWeight()
	{
		int total = 0;
		for(int i=0; i<sockets.size(); i++)
		{
			total += sockets.get(i).getValue();
		}
		return total;
	}

	public void addSocket(Socket socket)
	{
		sockets.add(socket);
	}

	public LinkedList<Socket> getSocketList()
	{
		return sockets;
	}

	public String toString()
	{
		String msg = "";
		msg += "Name: ";
		msg += name;
		msg += "\n";
		msg += "Sockets: ";
		for (int i=0; i<sockets.size(); i++)
		{
			msg += sockets.get(i) + " ";
		}

		return msg;
	}

	public int compareTo(Arm other)
	{
		if(name.length() < other.getName().length()) return -1;
		if(name.length() > other.getName().length()) return 1;
		return name.compareToIgnoreCase(other.getName());
	}
}