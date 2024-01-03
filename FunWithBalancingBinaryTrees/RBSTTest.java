import java.util.Random;
import java.util.Scanner;
import java.io.*;

import java.lang.reflect.Field; 

public class RBSTTest
{
	public static void main(String [] args)
	{
		int[] arr = new int[120];
		Random rand = new Random();
		rand.setSeed(100);

		Scanner scan;
		int N = 100;
		int count;
		double total = 0;
		
		// Create a random array of numbers between 0 and 99.
		arr[0] = 0;
		for (int i = 1; i < N; i++)
		{
			int loc = rand.nextInt(i);
			arr[i] = arr[loc];
			arr[loc] = i;
		}

		// Insert the array into a RBST. Since the rank is between 1 and n instead of 0 and n-1, we need to add 1 to i to get the actual rank.
		RBST tree = new RBST();
		for (int i = 0; i < N; i++)
			tree.insertFast(arr[i], i+1);

		count = 0;
		scan = new Scanner(treePrintToString(tree));
		for (int i = 0; i < N && scan.hasNext(); i++)
			if (arr[i] == scan.nextInt()) count++;
		for (; scan.hasNext(); scan.next(), count--);
		System.out.printf("%-30s %d/%d (%.1f%%)\n", "insert + print", count, N, 100.0*count/N);
		total += (double)count/N;

		// Insert a bunch of 100s at 10 random locations, both in the array and the RBST.
		for (int i = 0; i < 10; i++)
		{
			int loc = rand.nextInt(N+1);
			for (int j = N; j > loc; j--)
				arr[j] = arr[j-1];
			arr[loc] = 100;
			tree.insertFast(100, loc+1);
			N++;
		}

		count = 0;
		scan = new Scanner(treePrintToString(tree));
		for (int i = 0; i < N && scan.hasNext(); i++)
			if (arr[i] == scan.nextInt()) count++;
		for (; scan.hasNext(); scan.next(), count--);
		System.out.printf("%-30s %d/%d (%.1f%%)\n", "insert middle", count, N, 100.0*count/N);
		total += (double)count/N;
				
		// Insert 5 200s at the beginning.
		for (int i = 0; i < 5; i++)
		{
			for (int j = N; j > 0; j--)
				arr[j] = arr[j-1];
			arr[0] = 200;	
			tree.insertFast(200, 1);
			N++;
		}

		// Insert 5 300s at the end.
		for (int i = 0; i < 5; i++)
		{
			int loc = N;
			arr[N] = 300;	
			tree.insertFast(300, tree.getSize()+1);
			N++;
		}

		count = 0;
		scan = new Scanner(treePrintToString(tree));
		for (int i = 0; i < N && scan.hasNext(); i++)
			if (arr[i] == scan.nextInt()) count++;
		for (; scan.hasNext(); scan.next(), count--);
		System.out.printf("%-30s %d/%d (%.1f%%)\n", "insert start and end", count, N, 100.0*count/N);
		total += (double)count/N;

		count = 0;
		for (int i = 0; i < N; i++)
		{
			Node node = tree.select(i+1);
			if (node != null && arr[i] == node.value) count++;
		}
		System.out.printf("%-30s %d/%d (%.1f%%)\n", "select", count, N, 100.0*count/N);
		total += (double)count/N;

		// test splits only count as one point apiece
		total += testSplit(tree, 50, arr, N, "split(50)");
		total += testSplit(tree, 25, arr, N, "split(25)");
		total += testSplit(tree, 1, arr, N, "split(1)");
		total += testSplit(tree, N-1, arr, N, "split(N-1)");

		// max score is 8, but show it out of 100
		System.out.println("------------------------------------------------");
		System.out.printf("Total score: %.2f%%\n", total*100/8);
	}

	public static double testSplit(RBST tree, int rank, int[] arr, int N, String label)
	{
		double total = 0;

		RBST tree1, tree2;
		Node[] split1, split2;
		Scanner scan1, scan2;
		int count, count1, count2;

		/* Splitting on rank is *slightly* ambiguous, based on whether you think that means splitting 
		 * on rank r should produce trees of either
		 *    size r and size N-r, or
		 *    size r-1 and size N-r+1
		 * 
		 * For this reason, I check both possible interpretations by copying the tree twice, splitting
		 * them on r and r+1, and seeing which one produces a better score. The rest of this code is
		 * handling the two possible outcomes.
		*/
		tree1 = copyTree(tree);
		tree2 = copyTree(tree);
		split1 = tree1.split(rank);
		split2 = tree2.split(rank+1);

		count1 = count2 = 0;
		scan1 = new Scanner(treePrintToString(new RBST(split1[0])));
		scan2 = new Scanner(treePrintToString(new RBST(split2[0])));
		for (int i = 0; i < rank && scan1.hasNext(); i++)
			if (arr[i] == scan1.nextInt()) count1++;
		for (; scan1.hasNext(); scan1.next(), count1--);
		for (int i = 0; i < rank && scan2.hasNext(); i++)
			if (arr[i] == scan2.nextInt()) count2++;
		for (; scan2.hasNext(); scan2.next(), count2--);
		count = Math.max(count1, count2);
		System.out.printf("%-30s %d/%d (%.1f%%)\n", label+" left half", count, rank, 100.0*count/rank);
		total += (double)count/rank;

		count1 = count2 = 0;
		scan1 = new Scanner(treePrintToString(new RBST(split1[1])));
		scan2 = new Scanner(treePrintToString(new RBST(split2[1])));
		for (int i = rank; i < N && scan1.hasNext(); i++)
			if (arr[i] == scan1.nextInt()) count1++;
		for (; scan1.hasNext(); scan1.next(), count1--);
		for (int i = rank; i < N && scan2.hasNext(); i++)
			if (arr[i] == scan2.nextInt()) count2++;
		for (; scan2.hasNext(); scan2.next(), count2--);
		count = Math.max(count1, count2);
		System.out.printf("%-30s %d/%d (%.1f%%)\n", label+" right half", count, (N-rank), 100.0*count/(N-rank));
		total += (double)count/(N-rank);

		return total/2.0;
	}
	
	public static String treePrintToString(RBST tree)
	{
		// redirect output to parse it as a string for correctness
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream realOut = System.out;
		System.setOut(ps);
		tree.print(); // <-- print the tree
		System.out.flush();
		System.setOut(realOut);
		return baos.toString();
	}

	public static Node copyNode(Node node)
	{
		// recursively copy a node to make a tree copy
		if (node == null) return null;
		return new Node(node.value, copyNode(node.left), copyNode(node.right));
	}

	public static RBST copyTree(RBST tree)
	{
		try
		{
			// the only way to duplicate the tree is to duplicate the root node
			// but the root node is private, so reflection gives us access.
			// if one of my students reads this, please don't write code like this
			Field f = RBST.class.getDeclaredField("root");
			f.setAccessible(true);
			return new RBST(copyNode((Node)f.get(tree)));
		}
		catch (Exception e)
		{ return null; }
	}
}
