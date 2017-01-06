/*The following code is an example of a class that generates an array
of twenty random integers and calculates the mean of those numbers.*/
package numberaverage;

/*Import the full Java utilities library.  Contains a random number
library, an arrays class, and also an appendable ArrayList class.*/
import java.util.*;

/*This is the StatsUtils library from the apache commons math library package.
It has a lot of useful statistical functions in it, including calculating 
means.  The JAR library files had to be downloaded and then added to the project
path using the Properties tab on the project in NetBeans itself.  The StatUtils
library was then imported directly into this class file.*/
import org.apache.commons.math3.stat.StatUtils;

/*Main class definition to generate an array of random number data and
then calculate the mean of the data in the array.*/
public class NumberAverage 
{
    
    /*Set the size of the number array to contain 20 elements in this case.
    This variable had to be made static because its original value will be 
    used again in a subclass used to calculate the mean of only the even
    numbers in the array.*/
    static int array_size = 20;
    
    //Generate a random number variable.
    Random rand = new Random();
  
    /*Create an array two store twenty integers.  This array also must be
    static since its values will be used again in a subclass to pick out
    only the even numbers from the array and calculate their mean.*/
    static int num_array[] = new int[array_size];
    
    //Class variable to store the mean value of the array elements.
    double array_mean;
    
    //Class method to initialize the array with random numbers between 1 and 20.
    void NumArrayInitialize()
    {
        for(int i = 0; i < array_size; ++i )
        {
            num_array[i] = rand.nextInt(20)+1;
        }
        
        //Sort the array in ascending order.
        Arrays.sort(num_array);
    }
    
    //Class method to print out each element of the array sequentially.
    void NumArrayPrint()
        {
        System.out.println("All numbers in the array:");   
        for(int i = 0; i < array_size; ++i )
            {
            System.out.println(num_array[i]);
            }
        }
    
    /*Class method to calculate and print out the mean value of all the 
    elements in the array.*/
    void ArrayMean()
        {
            
            /*Convert the integer array to an array of doubles in order to
            be able to calculate the mean value of the array.*/
            double[] array_double = 
                    Arrays.stream(num_array).asDoubleStream().toArray();
            
            //Calculate the mean value of the array.
            array_mean = StatUtils.mean(array_double);
            
            //Print out the mean value of the array 
            System.out.println("Mean of all numbers: "
                            + array_mean);
        }
    
    
    /*The main method is located in the main class of the project.  In this
    case, a NumberAverage object is created, it's array member is initialized
    with random numbers between 1 and 20, each element of the array is printed
    and the mean value of the array is calculated and printed using the
    class methods.  Subsequently, a new object is created to take the original
    array, select out only the even numbers and calculate their mean.*/
    public static void main(String[] args) 
    {
        NumberAverage Numberlist = new NumberAverage();
        Numberlist.NumArrayInitialize();
        Numberlist.NumArrayPrint();
        Numberlist.ArrayMean();
        
        EvenAverage Evenlist = new EvenAverage();
        Evenlist.EvenArrayPopulate();
        Evenlist.EvenArrayPrint();
        Evenlist.EvenArrayMean();        
    }
}
