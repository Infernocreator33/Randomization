
package countersort;
import java.util.*;
/**
 *
 * @author zs087
 */
public class CounterSort {
    //make array that will hold 100000 integers
    static int[] numbers = new int[100000];
    public static void main(String[] args) {
        //loop 1000 times 
        for(int i = 0; i < 1000; i++)
        {
          //instance of random 
           Random rand = new Random();

          //loop 100,000 times to get all the random integers into the array
        for(int j = 0; j < 100000; j++)
        {
            //each random is an integer between 0 and 999 
            int random = rand.nextInt(1000);
            //number at index is equal to random provided
            numbers[j] = random;
        } 
            long startTime = System.currentTimeMillis();
            checkSort(numbers);
            System.out.println("Array number: " + i +" is sorted move on");
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            System.out.println("\nRuntime:  " + runTime + "\n");
            
        }
    }
  
    public static int [] counterSort(int[] array)
    {
        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();
        int range = max - min + 1;
        int [] counter = new int[range];
        int [] sortedArray = new int[array.length];
        for(int i = 0; i < array.length;i++)
        {
            counter[array[i] - min]++;
        }
        for(int i = 1; i < counter.length;i++)
        {
            counter[i] += counter[i - 1];
        }
        for(int i = array.length - 1; i >= 0; i--)
        {
            sortedArray[counter[array[i] - min] - 1] = array[i]; 
            counter[array[i] - min]--; 
        }
    
        for(int i = 0; i < array.length; i++) 
        { 
            array[i] = sortedArray[i]; 
        }
        return sortedArray;
    }
    static void checkSort(int [] array)
    {
        
        array = counterSort(numbers);
        //bubble sort to determine if array is not sorted
        boolean needNextPass = true;
        for(int k = 1; k < array.length && needNextPass; k++)
        {
            needNextPass = false;
            for(int i = 0; i < array.length - k; i++)
            {
                if(array[i] > array[i + 1])
                {
                    int temp;
                    temp = array[i];
                    array[i] = array[i + 1]; 
                    array[i + 1] = temp;
                    needNextPass = true;
                    if(needNextPass = true)
                    {
                       System.out.println("Array is not sorted");
                       break;
                    }
            }
        }
            
        }
    }
    static void printArray(int[] array)  
    { 
        for (int i = 0; i < array.length; i++)  
        { 
            System.out.print(array[i] + " ");
            if(i % 100 == 0)
            {
                System.out.println(array[i] + "");
            }
        }
        System.out.println(""); 
    } 
}
