
public class BST
{
	public Node root;

	public BST()
	{
		this.root = null;
	}
	
	public void insert(int time, Request rec)
	{
		root = recInsert(time, rec, root);
	}
	//time is our key, both params need to be inserted
	private Node recInsert(int time, Request req, Node root)
	{
		if(root == null)
		{
			root = new Node(time,req);
			return root;
		}

		//values less than root-- left subtree
		if(time < root.time)
		{
			root.left = recInsert(time,req,root.left);
		}
		else
		//values greater than root -- right subtree
		{
			root.right = recInsert(time, req, root.right);
		}
		return root;
	}

	

	public Node pred(int time)
	{
		
		Node node;
		//pred node
		Node pred = null;
		
		
		//assign our traversal node to the root of our binary search tree
		node = root;

		//while the node we are on is not null
		while(node!=null)
		{
			//checks to see if the current node is less than time
			if(node.time < time)
			{
				//the pred is our node
				pred = node;
				//update our node to the node to the right
				node = node.right;
				
			}
			//if node is greater or equal to time we want to go to the left 
			else if(node.time >= time)
			{
				
				node = node.left;
				
			}
				

		}

		return pred;
			
	}
			
			
		
		
	

	public Node succ(int time)
	{
		Node node;
		//succesor node
		Node succ = null;
		
		node = root;
		 
		while(node!=null)
		{
			
			

			
			//if our node is less than time we are going to go to the right
			if(node.time > time)
			{
				succ = node;
				node = node.left;

				
			}


			else
			{
				node= node.right;
				
				
			
			}
				
		}
		return succ;
	}

	//returns smallest value
	public Node min()
	{
		//return null if no root
		if(root == null)
		{
			return null;
		}		
		Node current = root;
		//while there is a node on the left assign our root to the current left node
		//by the end of this iteration our root will be the smallest value
		while(current.left!=null)
		{
			current= current.left;
		}
		return current;
	}

	//returns largest value
	public Node max()
	{
		//returns null if no root
		if(root == null)
		{
			return null;
		}

		Node current = root;
		//while there is a node on the right assign the root to the current right node
		//at the end of the iterations the root will be the largest value
		while(current.right!=null)
		{
			current = current.right;
		}

		return current;
	}

	public void delete(int time)
	{
	   recDelete(root,time);
	}

	private Node recDelete(Node node,int time)
	{
		if (node == null) {
		
			return node;
		}
	
		// If the value to delete is smaller than the current node's value, go left.
		if (time < node.time) 
		{
		node.left = recDelete(node.left, time);

		}
		
		// If the value to delete is greater, go right.
		else if (time > node.time) {
			node.right = recDelete(node.right, time);

		} 


		else {
			// If the current node's time matches the time to be deleted, it's the node to delete.
			if (node.left == null) {
				
				return node.right;
			} else if (node.right == null) {
				return node.left;
			}
	
			// Node with two children, replace it with its successor.
			Node successorNode = succ(node.time);
			node.time = successorNode.time;
			node.right = recDelete(node.right, successorNode.time);
		}
	
		return node;

		

	}

	
	
	//print method
	public void print()
	{
		recPrint(root);
	}
     

	//recursive print method
	private void recPrint(Node root)
	{
		if (root == null) return;
		recPrint(root.left);
        System.out.println(root.time);
        recPrint(root.right);
	}

}

 
