public class Node
{
	public int value;
	public int size;
	public Node left;
	public Node right;

	public Node(int value, Node left, Node right)
	{
		this.value = value;
		this.left = left;
		this.right = right;
		this.updateSize();
	}

	public Node(int value)
	{
		this(value, null, null);
	}

	public void updateSize()
	{
		size = 1;
		if (left != null) size += left.size;
		if (right != null) size += right.size;
	}
}
