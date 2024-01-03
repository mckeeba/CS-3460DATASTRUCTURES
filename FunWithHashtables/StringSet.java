
// a class for The Hashtable
public class StringSet {
	private static class Node
	{
		public String data;
	
		public Node next;

		public Node(String data, Node next)
		{
			this.data = data;
			this.next = next;
			
		}
	}

	private Node[] table;
	private int size;

	public StringSet()
	{
		size = 0;
		table = new Node[100];
		
	}

	public void insert(String key)
	{
		if (size == table.length)
		{
			// TODO: expand the hash table and rehash its contents

		//keeping track of the old table
		Node[] oldTable = table;

		//modifying table to be double its size *note that to modify the size of an array we use .length
		table = new Node[table.length * 2];

		//Loop through our old table
			for(int i = 0; i < oldTable.length; i++)
			{
				//loop through our old table's linked list- pointing our current node to the head of the list, then traversing it
				for(Node c = oldTable[i]; c!=null; c = c.next)
				{

					//hashing our data
					int h = hash(c.data);
					//then inserting it bnack into our now double sized table
					table[h] = new Node(c.data,table[h]);
				}
			}








		}
		// TODO: code for insert

		int h = hash(key);

		table[h] = new Node(key, table[h]);
		size++;


	}

	public boolean find(String key)
	{
		int h = hash(key);
		// TODO: return true if the key is present, false otherwise

		for(Node c = table[h]; c!=null; c = c.next)
		{
			if(c.data.equals(key))
			{
				return true;
			}
		}


		return false;
	}

	public void print()
	{
		// TODO: print the contents of the hash table

		for(Node head:table)
		{
			for(Node c = head; c!= null; c = c.next)
			{
				System.out.println(c.data);
			}
		}
	}

	public int hash(String key)
	{
		int h = 0;
		// TODO: compute a polynomial hash function for the String k
		// the returned value should be a valid index into the table
		// i.e, in the range [0..n-1] where n = table.length

		int x = 911;

		for(int i = 0; i< key.length(); i++)
		{
			
			h = (h*x+key.charAt(i))%table.length;
		}
		return h;
	}
}
