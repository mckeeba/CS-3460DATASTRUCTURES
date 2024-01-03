import java.util.Scanner;

public class Jugs
{
    static boolean[][] visited;
    static int A,B,C;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
       
        //user input

        System.out.print("Enter A: ");
         A = scanner.nextInt();
        System.out.print("Enter B: ");
         B = scanner.nextInt();
        System.out.print("Enter C: ");
         C = scanner.nextInt();

         
          visited = new boolean[A + 1][B + 1];
        //possible solution and impossible solution

         if (jugDfs(0, 0)) 
         {
            System.out.println("Possible!");
        } else 
        {
            System.out.println("Impossible!");
        }

       

        scanner.close();

        


       



    }

    static boolean jugDfs(int a, int b)
    {
        if (a + b == C) 
        {
           
            return true;
        }

        if (visited[a][b]) 
        {
            return false;
        }

        visited[a][b] = true;

        //A- Fill Jug 1 to A
        if (a < A && jugDfs(A, b)) 
        {
            System.out.println("Fill Jug 1 [a = " + A + ", b = " + b + "]");
            return true;
        }

        //B-  Fill Jug 2 to B
        if (b < B && jugDfs(a, B)) 
        {
            System.out.println("Fill Jug 2 [a = " + a + ", b = " + B + "]");
            return true;
        }

        //C- Empty Jug 1 to 0
        if(a>0 && jugDfs(0,b))
        {
             System.out.println("Empty Jug 1 [a = 0, b = " + b + "]");
             return true;
        }


        //D- Empty Jug 2 to 0
        if (b > 0 && jugDfs(a, 0)) 
        {
            System.out.println("Empty Jug 2 [a = " + a + ", b = 0]");
            return true;
        }

     

        return false;
    }

}


