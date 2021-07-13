import java.util.Random;
import java.util.ArrayList;

public class ExceptionHandling{
    class OutOfGasException extends Exception{}
    class UnreliableFriend {
        public boolean deliverMessage() throws OutOfGasException{
            Random r = new Random();
            boolean hasGas = r.nextBoolean();
            if (hasGas){
                return true;
            }
            throw new OutOfGasException();
        }
    }

    class DeliverMessage{
        public static void main(String[] args){
            UnreliableFriend friend = new UnreliableFriend();
            try{
                friend.deliverMessage();
                System.out.println("The message was delivered!");
            } catch (OutOfGasException e){
                System.out.println("Hey, uh, so, I ran out of gas..");
                // back-up plan here.
            }
        }
    }
}


// public class ExceptionHandling{
//     public static void main(String[] args) {
//         ArrayList<Object> myList = new ArrayList<Object>();
//         myList.add("13");
//         myList.add("hello world");
//         myList.add(48);
//         myList.add("Goodbye World");
        
//         for(int i = 0; i < myList.size(); i++) 
//             try{
//                 Integer castedValue = (Integer) myList.get(i);
//             }
//             catch(ClassCastException e){
//                 System.out.println("*****" + e + "*****");
//                 System.out.println("Index of error: " + i);
//                 System.out.println("Value of error: " + myList.get(i));
//             }
//     }
// }

