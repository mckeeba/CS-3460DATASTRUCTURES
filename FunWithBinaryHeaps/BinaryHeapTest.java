import java.util.Random;

public class BinaryHeapTest
{
	public static void main(String[] args)
	{
		Random r = new Random();
		BinaryHeap heap = new BinaryHeap();
		int[] arr = new int[10000];

		for (int i = 0; i < arr.length; i++)
			arr[i] = r.nextInt(10000000);
		
		int start = 0;
		for (int n = 0; n < arr.length; n++)
		{
			// insert into the heap
			heap.insert(arr[n]);
			
			// insertion sort
			for (int i = n; i > start; i--)
			{
				if (arr[i] < arr[i-1])
				{ int t = arr[i]; arr[i] = arr[i-1]; arr[i-1] = t; }
			}

			if (n > 0 && n % 100 == 0)
			{
				for (int i = 0; i < 5; i++)
				{
					int amin = arr[start++];
					int hmin = heap.remove_min();
					if (amin != hmin)
						System.out.printf("(%d) array min %d, heap reported %d\n", n, amin, hmin);
				}
			}
		}

		if (heap.size() != arr.length - start)
			System.out.println("wrong size");

		while (start < arr.length)
		{
			int amin = arr[start++];
			int hmin = heap.remove_min();
			if (amin != hmin)
				System.out.printf("array min %d, heap reported %d\n", amin, hmin);
		}
	}
}