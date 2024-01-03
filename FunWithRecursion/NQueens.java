import java.util.Scanner;

public class NQueens {

    public static int[][] board; 

    public static void main(String[] args)
{
   Scanner scanner = new Scanner(System.in);
   
   
   System.out.print("Enter the number of queens: ");
    int a = scanner.nextInt();

    int valid = solve(a);

    System.out.println("The number of valid arrangements is " + valid );

    scanner.close();
}


public static int solve(int n)
{
   board = new int[n][n];
    return recSolve(0, n);
    
}

private static int recSolve(int r, int n)
{
     //variable to keep track of the number of solutions
    int numberOfSolutions = 0;

    //base case when r == n, found one correct solution
    //means that we have gone through each row and have a
    //queen at a valid position on each row.
    if(r==n)
    {
        numberOfSolutions++;
    }


    //keep in mind that n not only represents the number of queens
   //it also will dictate the number of rows
   //and also the number of indexes per row

    //loop for each position/index for that specific row
    for(int j = 0; j < n; j++)
    {
       //boolean value that will be used to confirm whether valid queen or not.
       boolean isValid = true;

        
       

        
        //check if valid state
       
      // vertical column above - keep in mind index is in bounds
       for(int x = 0; x< board.length; x++)
       {
        if(board[x][j] == -1)
        {
          // x = r;
        isValid = false;
        break;
        } 
       
       
       }

       // left diagonal above -  keep in mind index is in bounds
       for(int x = 0;  x< board.length; x++)
       {
        int y = j - (r - x);
        
        
            if(y >= 0 && y < board.length && board[x][y] == -1)
            {
            isValid = false;
                break;
            }

         

       
       


       }

       //right diagonal above - keep in mind index is in bounds
       for(int x = 0; x< board.length; x++)
       {
         int y = j + (r - x);

         if(y>= 0 && y < board.length && board[x][y] == -1)
         {
           isValid = false;
           break;
         }

        

        }
       



        if(isValid){
       // board[r][j] has a queen(place queen on board at position), 
        //marking the queen as a -1
         board[r][j] = -1;
         numberOfSolutions +=recSolve(r+1, n);
         board[r][j] = 0;
       }

    }

    return numberOfSolutions;
}




}
