/*The following subclass takes the randomly generated integers from the
array in the main class, and generates a whole new array of only the even
numbers from the original list.  It then calculates the average of only
the array of even numbers*/ 
package numberaverage;

/*Also need the java utilities library to generate appendable array lists
in this class.  */
import java.util.*;

/*Class definition to calculate the mean numbers of the even values
in the original array.*/
public class EvenAverage extends NumberAverage 
{
    
    /*A new array list to store only even numbers from the original list.  An
    array list had to be used since the number of elements in the array is
    unknown each time the program is run.*/
    ArrayList even_array = new ArrayList();
    
    
    //Mean of the array of even numbers.
    double even_mean;
    
    
    //Class method to populate the array of even numbers from the original 
    //array of numbers.
    void EvenArrayPopulate()
        {
            for(int i = 0; i <array_size; ++i)
            {
                //Check to see if each number in the original array is even.
                if((num_array[i]%2) == 0)
                    even_array.add(num_array[i]);
            }
        }
     
    
    //Class method to print out the even numbered array.
    void EvenArrayPrint()
        {
            
            System.out.println("\nEven numbers only:");
        for(int i = 0; i < even_array.size(); ++i )
            {
            System.out.println(even_array.get(i));
            }
        }
    
    
   /*Class method to calculate the mean of the array of even numbers.  In
    this case, the mean was calculated and written out explicitly.*/
   void EvenArrayMean()
    {
        //Local variable to keep a running some of all the even numbers.
        int sum = 0;
        
        /*Calculate the mean of the array of even numbers explicitly.
        //Casting was used to convert each number in the array list into
        //an integer.*/
        for(int i = 0; i < even_array.size(); ++i )
        {
            sum += (int)even_array.get(i);
        }    
            even_mean = sum/even_array.size();
        
        //Print out the mean value.
        System.out.println("Mean of even numbers: " + even_mean);
        
    }
   
}