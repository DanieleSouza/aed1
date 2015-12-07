import java.util.LinkedList;

public class Node implements Comparable<Node>
{
	private String name;
	private int data; 
	private NodePosition position;
	private int distanceMultiplier;
	private LinkedList<Node> children;

	public Node(String name)
	{
		this(0,NodePosition.MIDDLE, 1, name);
	}

	public Node(int data, NodePosition position, int distanceMultiplier) 
	{
		this(data, position, distanceMultiplier, "");
	}

	public Node(int data, NodePosition position, int distanceMultiplier, String name)
	{
		this.data = data;
		this.position = position;
		this.distanceMultiplier = distanceMultiplier;
		this.name = name;
		this.children = new LinkedList<Node>();
	}

	public LinkedList<Node> getChildren()
	{
		return children;
	}

	public void addChild(Node n)
	{
		children.add(n);
	}

	public String getName()
	{
		return name;
	}

	public boolean isNamed()
	{
		return !name.equals("");
	}

	public int getData()
	{
		return data;
	}

	public NodePosition getPosition()
	{
		return position;
	}

	public void setPosition(NodePosition position)
	{
		this.position = position;
	}

	public int getDistanceMultiplier()
	{
		return distanceMultiplier;
	}

	public void setDistanceMultiplier(int value)
	{
		this.distanceMultiplier = value;
	}

	public boolean isBalanced()
	{
		int leftValue = 0;
		int middleValue = 0;
		int rightValue = 0;

		// For each children node
		for(Node child : children)
		{
			// Child value
			int val = child.getData();

			// If this is not a terminal node
			if(child.isNamed())
			{
				// Get child node weight
				val = child.getNodeWeight();
			}

			switch(child.position)
			{
				case LEFT:
					leftValue += val * child.getDistanceMultiplier();
					break;

				case MIDDLE:
					middleValue += val;
					break;

				case RIGHT:
					rightValue += val * child.getDistanceMultiplier();
					break;
			}
		}
		
		boolean isBalanced = (leftValue - rightValue) == 0;
		return isBalanced;
	}

	public int getNodeWeight()
	{
		int leftValue = 0;
		int middleValue = 0;
		int rightValue = 0;

		// For each children node
		for(Node child : children)
		{
			// Child value
			int val = child.getData();

			// If this is not a terminal node
			if(child.isNamed())
			{
				// Get child node weight
				val = child.getNodeWeight();
			}

			switch(child.position)
			{
				case LEFT:
					leftValue += val;
					break;

				case MIDDLE:
					middleValue += val;
					break;

				case RIGHT:
					rightValue += val;
					break;
			}
		}
		int total = leftValue + middleValue + rightValue;
		return total;
	}

	public String printChildren()
	{
		String msg = "";
		msg += "Children of (" + toString() + "): ";
		for(int i=0; i<children.size(); i++)
		{
			msg += children.get(i);
			msg += " ";
		}
		return msg;
	}

	public String toString()
	{
		String msg = "";
		if(!getName().equals(""))
		{
			msg += getName();
		}
		else
		{
			msg += getData();
		}

		return msg;
	}

	public int compareTo(Node other)
	{
		if(name.length() < other.getName().length()) return -1;
		if(name.length() > other.getName().length()) return 1;
		return name.compareToIgnoreCase(other.getName());		
	}
}