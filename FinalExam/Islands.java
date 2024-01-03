import java.util.Scanner;
import java.io.*;

public class Islands {
    
    public static final String ISLANDS_FILE = "map-1-in.txt";
    public static void main(String[] args)
    {
       File f = new File(ISLANDS_FILE);

       Scanner scanner = null;
       try
       {
          scanner = new Scanner(f);

          //size of our grid
          int gridSize = scanner.nextInt();

          scanner.nextLine();
          
          //our nxn 2D grid
          char[][] grid = new char[gridSize][gridSize];

          //visited array for 2D grid
          boolean[][] visited = new boolean[gridSize][gridSize];


        //loop that places our line of characters into each row of the grid
          for(int i = 0; i < gridSize; i++)
          {
            String ch = scanner.nextLine();
            //when we place our string into grid we convert to a char so that each
            //index for our char array contains one character
            grid[i] =ch.toCharArray();
          }

          System.out.println(solveDFS(grid));

       }

        catch(FileNotFoundException e)
        {
          System.out.println("Could not open the input file." + ISLANDS_FILE);
          e.printStackTrace();
        }
       

        


    }

    public static int solveDFS(char[][] grid)
    {
      return recSolveDFS(grid);
    }

    //recursive depth first search, loops through each row and column 
    //to find a section of *, if there is one or more grouped together than its an island
    private static int recSolveDFS(char[][]grid)
    {
      //island count variable
      int count = 0;
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            //if we find a * and it has been visited increment the count
            if (grid[i][j] == '*'/*&& !visited[i][j] */) {
                count++;
               
            }
        }
    }
      return count;
    }

    
}
