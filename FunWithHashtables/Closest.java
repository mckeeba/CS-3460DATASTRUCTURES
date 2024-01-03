import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class Closest
{
    //field for the file in question points.txt
    private static final String POINTS_FILE = "points.txt";

    public static void main(String[]args)
    {
        //makes a file object 
        File f = new File(POINTS_FILE);

        Scanner scanner = null;

        try
        {
            //scans through our file *part of the process to load our file
            scanner = new Scanner(f);

            while(scanner.hasNext())
            {
               
              double xIs= scanner.nextDouble();
              double yIs= scanner.nextDouble();

              scanner.next();
              
            }
            
            scanner.close();
            System.out.println("Loaded " + POINTS_FILE);

            class HashMap{
            //a node class that will help us implement a linked list to keep track of points hashed to a specific grid cell
            class Node
            {
                public double x = xIs;
                public double y;
                
                public Integer value;
                public Integer key;
                
                public Node next;
        
                public Node(Integer key, Integer value, Node next)
                {
                    this.x = x;
                    this.y = y;
                    this.value = value;
                    this.next = next;
                    this.key = key;
                }
            }

            //important value that will help determine the grid size
            int b = 0;
            
            //Our two dimensional array sized based off our bxb value
            Node [][] grid= new Node[b][b];

           public int insert(int key)
           {
             int h = hash(key);



           }
            public int hash(int key)
            {
                //polynomial prime value
                int p = 911;
                //our hash value
                int h1 = 0;
                int h2 = 0;
                
                
                    h1 = (h1 * p + key) % grid.length;
                return h;
            }
           

        }

        }


        catch(FileNotFoundException e)
        {
            System.out.println("Could not open file " + POINTS_FILE);
            e.printStackTrace();
        }









    }











}