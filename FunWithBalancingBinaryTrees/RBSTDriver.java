public class RBSTDriver {
    public static void main(String[] args)
    {

        RBST rbst = new RBST();
         // Test the insert method
         rbst.insert(10, 2);
         rbst.insert(6,1);
         rbst.insert(12,3);
          rbst.insert(2,4);
           rbst.insert(14,5);
      
        
         System.out.println(" ordered traversal:");
         rbst.print();

        System.out.println("I have selected: " + rbst.select(2).value);



        
        Node[] splitResult = rbst.split(3);

        System.out.println("Left Subtree: ");
        System.out.println(splitResult[0].value);

        System.out.println("Right Subtree: ");
        System.out.println(splitResult[1].value);



        

    }
}
