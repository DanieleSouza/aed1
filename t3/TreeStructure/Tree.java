import java.util.LinkedList;

public class Tree 
{
	private Node root;

	public Tree()
	{
		root = null;
	}

	public Node getRoot()
	{
		return root;
	}

	public void setRoot(Node n)
	{
		this.root = n;
	}

	public LinkedList<Node> getBalancedNodes()
	{
		LinkedList<Node> balanced = new LinkedList<Node>();
		
		return getBalancedNodesAux(root, balanced);
	}

	private LinkedList<Node> getBalancedNodesAux(Node n, LinkedList<Node> bList)
	{
		if(n.isNamed() && n.isBalanced()) bList.add(n);

		for(Node child : n.getChildren())
		{
			getBalancedNodesAux(child, bList);
		}
		return bList;
	}

	public String print()
	{
		return print(root);
	}

	private String print(Node n)
	{
		String msg = "";
		msg += "(";
		msg += n;
		for(Node child : n.getChildren())
		{
			msg += print(child);
		}
		msg += ")";

		return msg;
	}
}