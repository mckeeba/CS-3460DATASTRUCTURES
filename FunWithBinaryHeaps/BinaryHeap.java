public class BinaryHeap
{
	public int[] data;   // data array
	public int numItems; // number of items stored in the data array

	public BinaryHeap()
	{
		data = new int[100];
		numItems = 0;
	}

	public void insert(int k)
	{
		// TODO: insert into the binary heap
		// insert at the last location, increment size, and sift-up

		   data[numItems] = k;
		   numItems++;
		  
		   sift_up(numItems-1);
		  

		if(data.length == numItems){
		// might require a resize if heap is full
		int[] newData = new int[data.length * 2];
		data = newData;
		}

	}

	public int remove_min()
	{
		// TODO: return smallest value (stored at root) and remove
		int min = find_min();

		// swap with last location, decrement size, then sift-down the new root
		int p = data[min];
		data[numItems] = p;
		numItems--;
		sift_down(0);
		
		return min;
	}

	public int find_min()
	{
		// TODO: return smallest value (stored at root)
		return data[0];
	}

	public int size()
	{
		return numItems;
	}

	public void sift_up(int i)
	{
		// TODO: fix heap violations at location i by swapping with parent if needed

		//while the current index is greater than the first index 
		while(i > 0)
		{
			//check if the value at our current index is less than the parent index value
			if(data[i] < data[(i-1)/2]){
			
				//if so we want to swap their places
			
			//placeholder
			int p = data[i];
			//assign the element from parent index to the index i- which now holds parent element
			data[i] = data[(i-1)/2];

			//parent index is now assigned the element from index i
			data[(i-1)/2]= p;

			//update index of i to parent index
			i = (i-1)/2;
			}
			else
			{
				break;
			}
		}


	}

	public void sift_down(int i)
	{
		// TODO: fix heap violations at location i by swapping with smallest child
		int leftcIndex = (2*i)+1;
		int rightcIndex = (2*i)+2;

		//while a left child exists(within the bounds of the array)
		while(leftcIndex < numItems)
		{
			//if there is a right child (within bounds of array)
			if(rightcIndex < numItems)
			{
				//compare the elements at the right and left child's indexes
				//see which one contains the smaller value
				if(data[leftcIndex]< data[rightcIndex])
				{
					//in this case its the left so we assign the value at 
					//the left index to be our small value
					int smallerIndex = data[leftcIndex];
					//next we check if that value is smaller than the value at our 
					//current index
					if(smallerIndex < data[i])
					{
						//if it is this is where we do our swapping
						//placeholder for value at current index
						int p = data[i];
						//set our current index value to be the smaller child value
						data[i]= smallerIndex;
						//set the smaller child value to our larger current index value
						data[leftcIndex] = p;

						//update the indexes
						i = leftcIndex;
						leftcIndex = (2*i+1);
						rightcIndex = (2*i+2);
					}
				}
				else
				{
					//means the right index value is the smaller one
					//set the data value from the rightindex to be the small one
					int smalleRIndex = data[rightcIndex];
					//check if that smallest child value is less than the current index value
					 if(smalleRIndex < data[i])
					{	
						//placeholder containing the current value at current index
						int p = data[i];
						//overwriting the value at current index to be smallest value
						data[i]= smalleRIndex;
						//changing smallest value to be the value at current index
						data[rightcIndex] = p;

						//update the indexes
						i = rightcIndex;
						leftcIndex = (2*i+1);
						rightcIndex = (2*i+2);
					}

				}
			}
			//else if in the case that there is no right child
			//just do the swap operation for the existing left child!
			else if(data[leftcIndex] < data[i])
			{
				int p = data[i];
				data[i] = data[leftcIndex];
				data[leftcIndex] = p;

				i = leftcIndex;
				leftcIndex = (2*i+1);
				rightcIndex = (2*i+2);

			}
				
				//break out of the loop if all else falls through
				else
				{
					break;
				}
				
			
		}
	}
}
