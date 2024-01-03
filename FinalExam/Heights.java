import java.io.*;
import java.util.Scanner;

public class Heights {
    
    private static final String HEIGHTS_FILE = "heights-1-in.txt";
    public static void main(String[] args) {

        
        File f = new File(HEIGHTS_FILE);

        Scanner scanner = null;
        try{

            scanner = new Scanner(f);

            // Number of buildings
            int numberOfBuildings = scanner.nextInt();

            // Number of permit requests
            int permitRequests = scanner.nextInt();


            scanner.nextLine();

            //creates a heights table object
            HeightsTable hT = new HeightsTable(numberOfBuildings);

                
            // Read heights for existing buildings, reads through each
            //height value and then inserts that value into the table
            for (int i = 0; i < numberOfBuildings; i++) {
                int n  = scanner.nextInt();
                hT.insert(n);
            }
            
        
            // Process permit requests--
            for (int i = 0; i < permitRequests; i++) {
                int h = scanner.nextInt();
                //cost variable that will get us the cost, which
                //will be the largest value less than h
                int cost = hT.getPermitCost(h);

                //the desired output
                System.out.println(h + " " + cost);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not open the input file." + HEIGHTS_FILE);
            e.printStackTrace();
        }
    }
}

class HeightsTable {
   

    private static class Node {
       public int key;
       public Node next;

       public Node(int key, Node next) {
            this.key = key;
            this.next = next;
        }
    }

     Node[] table;

   public HeightsTable(int size){
    //sets our table size to be the size passed in from main(numberOfBuildings)
        table = new Node[size];
      

    }
   
    // Insert key into the hashtable
 public void insert(int key) {
        
    //hashes the key (n) and then places it at the correct index in the table
        int index = hash(key);
        table[index] = new Node(key, table[index]);
    }

    // Find the cost of a permit
    int getPermitCost(int h) {
        int cost = 0;

        //outer loop for each head node in the table
        for(Node head:table){
        //loop for each node in the linked list
        for (Node current = head; current != null; current = current.next) {
            //checks the current spot we are at to see if its less than our (h- height requested)
            //and is greater than the previous largest value-(will iterate multiple time, changing cost variable)
            if (current.key < h && current.key > cost) {
                cost = current.key;
            }
        }
    }
        return cost;
    }

    //hashes key

    private int hash(int key) {
        
        return key % table.length;
    }
}