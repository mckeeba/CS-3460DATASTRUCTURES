import java.util.Scanner;

public class RunwayReservation
{
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt(); // The total number of requests.
		int k = kb.nextInt(); // Grace time between requests.

		// Variables for getting the input.
		char cmd;
		int time;
		int curtime = 0; // Current time, initialized to 0.

		// An array of requests. This is the data stored outside of our binary search tree.
		Request[] reqs = new Request[n];
		int i = 0;

		// Reading the input. All requests are read from the input file and stored in array reqs.
		while(kb.hasNext())
		{
			cmd = kb.next().charAt(0);
			time = kb.nextInt();

			if (cmd == 'r')
			{
				String flightname = kb.next();
				String flightnumber = kb.next();
				String source = kb.next();
				String destination = kb.next();

				reqs[i++] = new Request('r', time, flightname, flightnumber, source, destination);
			}
			else
			{
				reqs[i++] = new Request('t', time);
			}
			kb.nextLine();
		}

		// TODO: Complete the runway reservation system.

		BST bst = new BST();

		//for each request iterate through the reqs array..
		for(int j = 0; j < n; j++)
		{
			Request rq = reqs[j];
			int timeChkP = 0;
			int timeChkS = 0;
			Node valueInP = null;

			Node valueInS = null;
			
			//if command r 
			if( rq.command == 'r')
			{
			//is there a predecessor, if there is we want to subtract its int value from the requests time
				//if the value happens to be less than five(k) we don't want to insert it into the BST
				//if it is we want to insert it
				
					
				valueInP= bst.pred(rq.time);
				valueInS = bst.succ(rq.time);
				
				if(valueInP != null)
				{
					timeChkP = valueInP.time - rq.time;
					if(timeChkP >=k)
					{
						bst.insert(rq.time,rq);
					}
				
				}
				

				else if(valueInS != null)
				{
					timeChkS = valueInS.time - rq.time;
					if(timeChkS>=k)
					{
						bst.insert(rq.time, rq);
					}

				}

				//(timeChkP >= k && timeChkS >= k)||
				else if( valueInP == null && valueInS == null)
				{
					bst.insert(rq.time, rq);
					
				}
			

				
	
				

					
					
			
					
				
				
		
			}

			else
			{

				curtime += rq.time;

				System.out.println("Current time = "+curtime+ " units");
				
				

				
				while(bst.min() <= curtime)
				{
				System.out.println(rq.airline);
				//bst.delete(rq.time);
				}
				
			}
		}











	}
}
