import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class basicTest {
    public static void main(String[] args) {
    basic test = new basic();
    
    // Q1 Print 1-255
    for(int i=1; i<=255; i++){
        System.out.println(i);
    }


    // Q2 Print odd in 1-255
    for(int j=0; j<=255; j++){
        if(j%2!=0){
            System.out.println(j);
        }
    }


    // Q3 Print Sum
    for (int i=0; i<=255; i++){
        int sum=0;
        sum+=i;
        System.out.println("New number: " + i + " Sum: " + sum);
    }


    // Q4 Iterating through an array
    int[] arr4 = {1,3,5,7,9,13};
    test.IteratingArray(arr4);


    // Q5 Find Max
    int[] arr5 = {-1, -3, -5, -9};
    System.out.println(test.FindMax(arr5));


    // Q6 Get Average
    double[] arr6 = {2,3,10};
    System.out.println(test.GetAvg(arr6));


    // Q7 Array with Odd Numbers
    test.OddArr(); //Method1, call only, no return from basic.java
    System.out.println(test.OddArr111()); //Method2, getting an arraylist from basic.java and print locally


    // Q8 Greater Than Y
    int[] arr = {1,3,5,7};
    int y = 3;
    System.out.println(test.GreaterY(arr, y));


    // Q9 Square the values
    int[] arr9 = {1,5,10,-2};
    System.out.println(test.SqrVal(arr9));


    // Q10 Eliminate Negative Numbers
    int[] arr10 = {1,-5,10,-2};
    System.out.println(test.NoNegNum(arr10));

    
    // // Q11 Max, Min, Average
    int[] arr11 = {1, 5, 10, -2};
    System.out.println(test.MMA(arr11));

    // Q12 Shifting the Values in the Array
    int[] arr12 = {1, 5, 10, 7, -2};
    System.out.println(test.ShiftArr(arr12));
}   
} 
