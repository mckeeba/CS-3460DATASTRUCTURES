import java.util.Scanner;

public class Median
{
	public static void main(String[] args)
	{
		BinaryHeap small = new BinaryHeap();
		BinaryHeap large = new BinaryHeap();
		Scanner scan = new Scanner(System.in);

		int m = 0, v = 0;
		while (scan.hasNext())
		{
			char command = scan.next().charAt(0);
			if (command == 'i')
			{
				v = scan.nextInt();
				// TODO: insert value v into the dataset
				if(v > small.find_min())
				{
					large.insert(v);

				}

				else
				{
					small.insert(-1 * v);
				}

				if(small.size() > large.size() + 1)
				{
					int rmv = small.remove_min();

					large.insert(rmv * -1);
				}

				else if(small.size() + 1 < large.size())
				{
					int rmv = large.remove_min();
					small.insert(rmv * -1);
				}
			}
			else if (command == 'q')
			{
				// TODO: calculate the median, store it in m

				if(small.size() > large.size())
				{
					m = -1 * small.find_min();

				}

				else if(small.size() < large.size())
				{
					m = large.find_min();

				}
				
				else
				{
					m = ((small.find_min() * -1) + large.find_min())/ 2;
				}




				System.out.println(m);
			}
			else break;
		}
	}
}
