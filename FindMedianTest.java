import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdRandom;
import java.util.*;
public class FindMedianTest {
    public static void main (String [] args) throws Throwable    {
        double result;
        int[] size = {10, 50, 10000, 5000000};
        // Sort and print a few small arrays to make certain the sort works
        SortandMedian(size[0], size[1], 10);
        // Sort and time larger arrays
        SortandMedian(size[2], size[3], 1000000);
        // Sort and time larger arrays
        SortandMedian(size[2]+1, size[3]+1, 1000000);
    }
    public static void SortandMedian(int start, int end, int inc) throws Throwable
        {
        double result;
        for (int size = start; size<=end; size+=inc) {
            int [] array = createRandomArray(size);
            System.gc();
            long startTime = System.nanoTime();
            //Instructor's implementation of sort
           // Arrays.sort(array); // You will call findMedian method from FindMedian class
            FindMedian.findMedian(array);


            result = array[array.length/2];

//            if (array.length % 2  == 0) {
//                int resultEven1 = array[(array.length / 2) - 1];
//                int resultEven2 = array[(array.length / 2)];
//                result = ((resultEven1 + resultEven2)/2) ;
//            }
//            else {
//                result = array[(array.length / 2)];
//            }
//            int result2 = array[(array.length/2) + 1] ;


//            int s1 = (array.length/2);
//            int s2= (array.length/2) - 1 ;

            long endTime = System.nanoTime();

//            System.out.println(result);
//            System.out.println(result2);

//            System.out.println(array[s1]);
//            System.out.println(array[s2]);

            System.out.println ("Array size = " + size +
                    "\tMedian = " + result +
                    "\tSearch time = " +
                    (endTime-startTime)/1000000000.0 + " seconds");
        }
    }
    // This method reads creates an array of random integers
    public static int[] createRandomArray(int size) throws Throwable    {
        Random r = new Random(50);
        int [] array = new int [size];
        for (int i=0; i<size; i++)  {
            array[i] = StdRandom.uniform(100000);
        }
        return array;
    }
}
