public class BSTDriver 
{
    public static void main(String[] args) {
        BST bst = new BST();

		Request req1 = new Request('r', 10, "Airline 1", "123", "Source 1", "Destination 1");
        Request req2 = new Request('r', 5, "Airline 2", "456", "Source 2", "Destination 2");
        Request req3 = new Request('r', 15, "Airline 3", "789", "Source 3", "Destination 3");
        Request req4 = new Request('r', 8, "Airline 3", "789", "Source 3", "Destination 3");
        Request req5 = new Request('r', 9, "Airline 3", "789", "Source 3", "Destination 3");
        Request req6 = new Request('r', 7, "Airline 3", "789", "Source 3", "Destination 3");



        // Test the insert method
        bst.insert(10, req1);
        bst.insert(5, req2);
        bst.insert(15, req3);
        bst.insert(8,req4);
        bst.insert(9,req5);
        bst.insert(7,req6);

        System.out.println(" ordered traversal:");
        bst.print();

    int valueToFindPredecessor = 9;
    Node predecessorNode = bst.pred(valueToFindPredecessor);

    int valueToFindSuccessor = 9;
    Node successorNode = bst.succ(valueToFindSuccessor);

    System.out.println("Predecessor is: "+  predecessorNode.time);

     System.out.println("Successor is: "+ successorNode.time);


bst.delete(8);

bst.print();

    }
}
