import java.util.Scanner;
public class Collatz
{

   
    public static void main(String[]args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the range: ");
        
        int a = scanner.nextInt();
    
        int b = scanner.nextInt();


      long result = longestInRange(a, b);

      System.out.println("The number with the greatest Collatz length in this range: " + result);
      System.out.println("The Collatz length of " + result + " is " + collatzLength(result));

        scanner.close();

    }
    
    //Things to note
    //if n is 1 halt
    //if n is even divide by 2
    //if n is odd, 3n+1
   
   
   
    public static long collatzLength(long x)
    {
       long nextNum;
       
       //base case- if x is 1 halt
        if(x == 1)
        {
            return 1;
        }
        
        //if x is even divide it by 2 and assign it
        // to the next number in sequence
        else if(x % 2 == 0)
        {
           nextNum = x/2;
        }

        //else if number is odd multiply x by 3 and add 1, 
        //then assign result to next number in sequence
        
        else
        {
            nextNum = (3*x)+1;
        }

        //recursive call that calculates the length of the sequence
        //for the next number, and adds one to keep track of current number
        //in the sequence
          return collatzLength(nextNum) + 1;
    }

    public static long longestInRange(long a, long b)
    {
       long longestLength = 0;
       
       long value = 0;
    
      //i is equal to the first value, and as long as 
      //that value is less than b, we will iterate through the sequence 
       for(long i = a; i < b;i++)
       {

        //current length  is the calculated collatz length for the number 
        //we are iterating over
        long currentLength = collatzLength(i);

        //if the current length is larger than the longest
        //length assign it to be the greatest length and assign value
        //of i to be the value that has the longest length. 
        if(currentLength > longestLength)
        {
            longestLength = currentLength;
            
            value = i;
        }

       }

        return value;
    }


}