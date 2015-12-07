public class Socket
{
	// Socket name
	// This can be empty if the socket is terminal
	private String name;
	// Socket value
	// This can be equal to 0 if the socket is terminal
	private int value;
	// Distance from arm's middle socket
	private int distanceMultiplier;
	// Socket position relative to middle socket
	private SocketPosition position;

	public Socket(int value, int distanceMultiplier, SocketPosition position)
	{
		this(value, distanceMultiplier, position, "");
	}

	public Socket(int value, int distanceMultiplier, SocketPosition position, String name)
	{
		this.value = value;
		this.position = position;
		this.distanceMultiplier = distanceMultiplier;
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public int getValue()
	{
		return value;
	}

	public int getDistanceMultiplier()
	{
		return distanceMultiplier;
	}

	public SocketPosition getPosition()
	{
		return position;
	}

	public boolean isNamed()
	{
		return !name.equals("");
	}

	public String toString()
	{
		String msg = "";
		msg += "[";
		if(isNamed())
		{
			msg += name;
		}
		else
		{
			msg += value;
		}
		msg += "]";

		return msg;
	}
}