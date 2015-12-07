import java.util.HashMap;
import java.util.LinkedList;

public class Structure
{

	private HashMap<String, Arm> arms;

	public Structure()
	{
		arms = new HashMap<String, Arm>();
	}

	public void addArm(Arm a)
	{
		arms.put(a.getName(), a);
	}

	public boolean hasArm(String armName)
	{
		return arms.containsKey(armName);
	}

	public int getNumArms()
	{
		return arms.size();
	}

	public LinkedList<Arm> getBalancedArms()
	{
		LinkedList<Arm> balanced = new LinkedList<Arm>();
		for (HashMap.Entry<String, Arm> a : arms.entrySet())
		{
			Arm arm = a.getValue();
			if(isArmBalanced(arm.getName()))
			{
				balanced.add(arm);
			}
		}

		return balanced;
	}

	public String getLog()
	{
		String msg = "";
		msg += "Structure:";
		msg += "\n";
		for (HashMap.Entry<String, Arm> a : arms.entrySet())
		{
			Arm arm = a.getValue();
			msg += "===== ARM =====";
			msg += "\n";
			msg += a;
			msg += "\n";
			msg += "Total weight: ";
			msg += calculateArmWeight(arm.getName());
			msg += "\n";
			msg += "Balanced: ";
			msg += isArmBalanced(arm.getName());
			msg += "\n";
			msg += "===============";
			msg += "\n";
		}

		return msg;
	}

	private boolean isArmBalanced(String armName)
	{
		// If we have an arm with this name
		if(hasArm(armName))
		{
			// Get arm reference
			Arm a = arms.get(armName);
			// Get socket list
			LinkedList<Socket> sockets = a.getSocketList();

			int leftValue = 0;
			int middleValue = 0;
			int rightValue = 0;

			// For each socket
			for(Socket s : sockets)
			{
				// Socket value
				int val = s.getValue();

				// If the socket is named, this is a reference
				if(s.isNamed())
				{
					// Check if reference exists
					if(hasArm(s.getName()))
					{
						// Get arm weight
						val = calculateArmWeight(s.getName());
						//val = calculateArmValue(s.getName());
					}
					// Reference doesn't exist
					else return false;

				}
				// Assign values correctly
				switch(s.getPosition())
				{
					case LEFT:
						leftValue += val * s.getDistanceMultiplier();
						break;

					case MIDDLE:
						middleValue += val;
						break;

					case RIGHT:
						rightValue += val * s.getDistanceMultiplier();
						break;
				}
			}

			int total = leftValue + middleValue + rightValue;
			return (leftValue - rightValue) == 0;
		}
		// Reference doesn't exist
		return false;
	}

	private int calculateArmWeight(String armName)
	{
		// If we have an arm with this name
		if(hasArm(armName))
		{
			// Get arm reference
			Arm a = arms.get(armName);
			// Get socket list
			LinkedList<Socket> sockets = a.getSocketList();

			int leftValue = 0;
			int middleValue = 0;
			int rightValue = 0;

			// For each socket
			for(Socket s : sockets)
			{
				// Socket value
				int val = s.getValue();

				// If the socket is named, this is a reference
				if(s.isNamed())
				{
					// Check if reference exists
					if(hasArm(s.getName()))
					{
						// Get arm weight
						val = calculateArmWeight(s.getName());
					}
					// Reference doesn't exist
					else return -1;

				}
				// Assign values correctly
				switch(s.getPosition())
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

			return (leftValue + middleValue + rightValue);
		}
		// Reference doesn't exist
		return -1;
	}

	public String toString()
	{
		String msg = "";
		msg += "Structure:";
		msg += "\n";
		msg += "Number of arms: ";
		msg += getNumArms();
		msg += "\n";
		for (HashMap.Entry<String, Arm> a : arms.entrySet())
		{
			Arm arm = a.getValue();
			msg += "===== ARM =====";
			msg += "\n";
			msg += a;
			msg += "\n";
			msg += "===============";
			msg += "\n";
		}

		return msg;
	}

}