import java.util.Scanner;
import java.io.*;

public class Jigsaw
{
   
    //assign the file we want to analyze and read from in our program
    private static final String PUZZLE1_FILE = "puzzle-01-in.txt";

    //main method, here we will scan through our file
    public static void main(String[] args)
    {
        int piecesWeHave;
        int totalPieces;
        //our file object
        File f = new File(PUZZLE1_FILE);

        //PuzzleTable pT = new PuzzleTable(totalPieces, piecesWeHave);
       
        //inital assignment of our scanner
        Scanner scanner = null;

        
        try
        {
        scanner = new Scanner(f);
      
        //on the first line for the first number in our file we will have the number of pieces we currently have
       piecesWeHave = scanner.nextInt();
       
       
       
     


       //Later on the same line we will assign the second number to be the total number of pieces we should have for a complete puzzle
        totalPieces = scanner.nextInt();

       
            //println for our pieces we have and total pieces for a complete puzzle
        System.out.println(piecesWeHave+" "+totalPieces);


     
      
     //will then move us to the next line
       scanner.nextLine();
            //our table object which we will use to pass the numbers 
           //into our table to be hashed and keep track of any duplicates we may encounter
        PuzzleTable pT = new PuzzleTable(totalPieces, piecesWeHave);

            
         //while there is still numbers to go through..
        while(scanner.hasNext())
        {
            //assign the number we are on to an int variable n
            int n = scanner.nextInt();
           
            //prints each n in our file
            System.out.println(n);

            //insert n into our table & hashes it
            pT.insert(n);

        }

        //print our whole table (with no duplicates, because they have been taken care of)
       System.out.println("");
        pT.print();

       
            //pT.count();

       


        
        }

        

        catch(FileNotFoundException e)
        {
            System.out.println("Could not open this file " + PUZZLE1_FILE);
            e.printStackTrace();
        }



    }


}  
class PuzzleTable 
{
    int piecesWeHave;
    int totalPieces;
    private static class Node
    {
        public int key;
        public Node next;

        public Node(int key, Node next)
        {
            this.key = key;
            this.next = next;
        }
    }

    Node[] table;

    public PuzzleTable(int size, int piecesWeHave)
    {
        table = new Node[size];
        this.piecesWeHave = piecesWeHave;
    }

    public Node find(int key)
    {
        int h = hash(key);
        for (Node c = table[h]; c != null; c = c.next)
        {
            if (c.key == key)
                return c;
        }
        return null;
    }

    public void insert(int key)
    {
        if (find(key) != null) return;

        int h = hash(key);
        table[h] = new Node(key, table[h]);
    }

    public void print()
    {
       
        int count = 0;
        for (Node head : table)
        {
            for (Node c = head; c != null; c = c.next){
                //System.out.println(c.key);
                count++;
            }
        }
         //System.out.println(count);
         //System.out.println(piecesWeHave);
       int totalPiecesWeHave = count + piecesWeHave;

       if(totalPiecesWeHave == table.length)
       {
        System.out.println("The puzzle is complete.");
       }
       else
       {
        int missingPieces = table.length - totalPiecesWeHave;
        System.out.println("Missing " +missingPieces+ " jigsaw piece(s).");
       }
    }

    // public void count()
    // {
       
       
    //     int count = 0;
    //     //Jigsaw jig = new Jigsaw();

    //     for(Node head : table)
    //     {
    //         count++;
    //     }
       
    
    // }
    
    private int hash(int key)
    {
        //hashes any duplicates to the specific index in our table
        return (key) % table.length;
    }    
}
