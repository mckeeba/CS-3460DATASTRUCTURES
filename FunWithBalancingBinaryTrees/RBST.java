import java.util.Random;

public class RBST {
	private Node root; // Head node of the tree.
	private Random rand; // A random object - required to randomly insert nodes into the tree.

	// Constructors
	public RBST() {
		this(null);
	}

	public RBST(Node root) {
		this.root = root;
		this.rand = new Random();
	}

	public void print() {
		print(root);
		System.out.println();
	}

	private void print(Node node) {
		// implement a recursive in-order traversal

		if (node == null)
			return;
		// will prnt everything to the left if it can go left
		print(node.left);
		// will print the value at that node
		System.out.println(node.value);
		// if it can go to the right it will print every node to the right
		print(node.right);
	}

	public void insertFast(int value, int rank) {
		// recursive call to insert
		root = insertFast(root, value, rank);
	}

	private Node insertFast(Node node, int value, int rank) {
		// base case - inserting into a null tree

		if (node == null) {
			node = new Node(value);
			return node;
		}

		assert (rank >= 1 && rank <= node.size + 1) : "rank should be between 1 and n+1 <" + (node.size + 1) + ">";

		// recursively insert into left subtree if rank <= rank of root. otherwise
		// insert into right subtree.

		
		int r = 1;
		// accounting condition for if left subtree happens to not be null
		// we add the size of the left subtree to 1
		if (node.left != null) {
			r += node.left.size;
		}

		// if rank is less than or equal to r, recursively insert into left subtree
		if (rank <= r) {
			node.left = insertFast(node.left, value, rank);
		}

		// else recursively insert into right subtree
		else {
			node.right = insertFast(node.right, value, rank - r);
		}

	    
		return node; // return the actual resulting tree
	}

	 public Node[] split(int rank) {
	 	return split(root, rank);
	 }

	 private Node[] split(Node T, int rank) {
		Node[] ret = { null, null }; // ret[0] is the root node to the left side of the split, ret[1] is the right
			// side.

		// TODO: your code here for the split method. implement this recursively!
		// your base case will be an empty tree. your recursive case will have three
		// cases -- think
		// what happens if the rank of the root == rank, or if rank is smaller or larger
		// than the rank
		// of the root

		// for rank root
		int r = 1;
		if (T.left != null) {
			r += T.left.size;
		}

		if (rank == r) {
			// assigns the root node of the right side to the
			// right subtree of the current node, and disconnect it
			ret[1] = T.right;
			T.right = null;

			T.size = r -1;
			// then the root node on the left is the current node itself
			ret[0] = T;
		}

		// if rank of current node is greater than the rank, we need to split
		else if (rank < r) {

			// recursive call to split on left subtree
			Node splitted[] = split(T.left, rank);

			// update the left side root node of the split with result of recursive
			// split. Making right subtree become the new left subtree with respect to
			// current node T
			ret[0] = splitted[0];
			T.left = splitted[1];

			T.size = r-1;
			// right side of split is current node
			ret[1] = T;

		}

		// if rank of current node is less than the rank we need to split
		else if (rank > r) {
			// recursive call to split on right subtree
			Node splitted[] = split(T.right, rank - r);

			// update the right side root node of the split with result of recursive
			// split. Making left subtree become the new right subtree in respect to current
			// node T.
			ret[1] = splitted[1];
			T.right = splitted[0];

			T.size = T.right.size + T.left.size + 1;
			// left side of split is current node
			ret[0] = T;
		}
		
	 	return ret;
	}

	// public void insert(int value, int rank)
	// {

	// 	root = insert(root, value, rank);
	//  }

	// private Node insert(Node node, int team, int rank) {
	// 	// base case - inserting into a null tree

	// 	if (node == null) 
	// 	{
	// 		return new Node(team);
	// 	}

	// 	// rank root determine..
	// 	int r = 1;
	// 	if (node.left != null) 
	// 	{
	// 		r = node.left.size + 1;
	// 	}

	// 	assert (rank >= 1 && rank <= node.size + 1) : "rank should be between 1 and n+1 <" + (node.size + 1) + ">";

	// 	// TODO: with probability 1/(node.size + 1), the new node becomes the root
	// 	int prob = node.size + 1;
	// 	if (rand.nextDouble() <= 1.0 / prob)
	//     {
	// 		//split tree at rank - 1
	// 		Node[] splitTree = split(node,rank-1);
	// 		//creating a new node
	// 		Node newRoot = new Node(team);
	// 		//attaching the split left and right to the new root node
	// 		newRoot.left = splitTree[0];
	// 		newRoot.right = splitTree[1];
	// 		newRoot.size = node.size +1;
	// 		return newRoot;


	// 	}

	// 	// otherwise recursively insert into left or right subtree.
	// 	else
	// 	 {
	// 		// Recursively insert into the appropriate subtree(call insertFast this is for
	// 		// regular inserting)
	// 		if (rank <= r) 
	// 		{
	// 			node.left = insert(node.left, team, rank);
	// 		} 
	// 		else 
	// 		{
	// 			node.right = insert(node.right, team, rank - r);
	// 		}
	// 		node.size = node.left.size + node.right.size + 1;

	// 	}
		
	// 	node.size += 1;
	// 	return node; // Return the updated tree
	// }

	public Node select(int rank) {
		return select(root, rank);
	}

	private Node select(Node node, int rank) {
		// base case - return null if the tree is empty

		if (node == null) {
			return null;
		}

		assert (rank >= 1 && rank <= node.size + 1) : "rank should be between 1 and n+1 <" + (node.size + 1) + ">";

		// recursive case. return T if rank is equal to the rank of the root. otherwise,
		// recursively select in either the left tree (rank < rank of root) or the right
		// tree (rank > rank of the root).

		// similar implementation as insert, but with added check

		int r = 1;
		if (node.left != null) {
			r += node.left.size;
		}

		// checks if rank is equal to rank of the root
		if (rank == r) {
			return node;
		} else{
			if (rank < r) {
				 return select(node.left, rank);
			} else {
				return select(node.right, rank - r);
			}
		}
		
		
	}

	public int getSize() {
		return this.root == null ? 0 : this.root.size;
	}
}
