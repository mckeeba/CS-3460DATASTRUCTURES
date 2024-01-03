public class BinaryHeapDriver 
{
   public static void main(String[]args)
   {
    int[] binarHeapArray = {23, 5, 3, 9, 7, 4, 6, 11, 14, 8, 2};
    BinaryHeap bp = new BinaryHeap();

    for(int value: binarHeapArray)
    {
        bp.insert(value);
    }

    System.out.println("Array after insertion:");
    printArray(bp.data);

    

   // bp.data = binarHeapArray;
   // bp.numItems = binarHeapArray.length;

    // int indexToSiftDown = 0;
    // bp.sift_down(indexToSiftDown);

    // System.out.println();
    // System.out.println("Array after sift_down at index " + indexToSiftDown + ":");
    // printArray(bp.data);

   }
    

   private static void printArray(int[] arr) {
    for (int value : arr) {
        System.out.print(value + " ");
    }
    System.out.println();
}
}
