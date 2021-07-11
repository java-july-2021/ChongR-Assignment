import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class basic{
    //Q4 Iterating through an array
    public void IteratingArray(int[] x){
        for(int number:x){ 
            System.out.println(number);
        }
    }


    //Q5 Find Max
    public Integer FindMax(int[] arr){
        int res = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i] > res){
                res = arr[i];
            }
        }
        return res;
    }


    //Q6 Get Average
    public double GetAvg(double[] arr){
        double sum = 0;
        for(double number : arr){
            sum += number;
        }
        return sum/arr.length;
    }


    //Q7 Array with Odd Numbers
    //Method 1.
    public void OddArr(){
        ArrayList<Integer> arrli = new ArrayList<Integer>();
        for(int i=0; i<=255; i++){
            if(i%2!=0){
                arrli.add(i);
            }
        }
        System.out.println(arrli);
    }
    //Method 2. returning an arraylist as result
    public ArrayList<Integer> OddArr111(){      
        ArrayList<Integer> arrli = new ArrayList<Integer>();
        for(int i=0; i<=255; i++){
            if(i%2!=0){
                arrli.add(i);
            }
        }
        return arrli;
    }

    //Q8 Greater Than Y
    public int GreaterY(int[] arr, int y){
        int count = 0;
        for(int number:arr){
            if(number > y){
                count++;
            }
        }
        return count;
    }

    //Q9 Square the values
    public String SqrVal(int[] arr){
        for(int i=0; i<arr.length; i++){
            arr[i] = arr[i] * arr[i];
        }
        System.out.println(arr);  //This won't return the numbers in the array but the address where this array is storied

        return Arrays.toString(arr);  
        //need to use Arrays.toString() to transfer the array to String as the signature requires
    }

    //Q10 Eliminate Negative Numbers
    public String NoNegNum(int[] arr){
        for(int i=0; i<arr.length;i++){
            if(arr[i] < 0){
                arr[i] = 0;
            }
            // for(int number:arr){         //For each doesn't work 
            //     if(number < 0){
            //         number = 0;
            //     }
            // }
        }
        return Arrays.toString(arr);
    }

    //Q11  Max, Min, and Average
    public String MMA(int[] arr){
        int sum = 0;
        int max = arr[0];
        int min = arr[0];
        
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            if(arr[i]>max){
                max = arr[i];
            }
            if(arr[i]<min){
                min = arr[i];
            }
        }

        double[] res = {max, min, sum/arr.length};
        return Arrays.toString(res);
    }

    //Q12 Shifting the Values in the Array
    public String ShiftArr(int[] arr){
        for(int i=0; i<arr.length-1;i++){
            arr[i]=arr[i+1];
        }
        arr[arr.length-1]=0;
        return Arrays.toString(arr);
    } 

}