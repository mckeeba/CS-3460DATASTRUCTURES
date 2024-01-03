


public class IntStack
{
	// declare your private fields here
	
	private int countItems;
	private int stackElements[];
	/**
	 * Create an empty stack.
	 * 
	 */
	public IntStack()
	{
		stackElements = new int[100];
		
		countItems = 0;
	
	}

	/** 
	 * Pushes an item onto the top of this stack.
	 * 
	 */
	public void push(int x)
	{
		stackElements[countItems] = x;
		countItems++;
	}

	
	/** 
	 * Removes the object at the top of this stack and returns that object as the value of this function.
	 * int The value removed from the stack. If empty, returns -1
	 */
	public int pop()
	{
		if(countItems == 0)
		{
		return -1;
		}
		else
		{
			countItems --;
			return stackElements[countItems];
		}
	}

	public boolean isEmpty() {
		if(countItems>0)
		return false;
		else{
			return true;
		}

	}

     public int peek() 
	{
		if(countItems == 0) // returns -1 if stack is empty
		{
			return -1;
		}

		else
		{
			return stackElements[countItems - 1]; //returns whats on top of stack
		}
	} 
}
