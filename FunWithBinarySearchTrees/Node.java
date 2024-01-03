public class Node
{
	public int time;
	public Request req;
	public Node left;
	public Node right;
	//public int data;

	public Node(int time, Request req)
	{
		this.time = time;
		this.req = req;
		left = right = null;
		
	}




	public String toString()
	{
		return time + " " + req.airline;
	}
}