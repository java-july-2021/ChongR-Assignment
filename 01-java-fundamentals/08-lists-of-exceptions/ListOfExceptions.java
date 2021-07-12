import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;


public class ListOfExceptions {
    
    public void testt(){
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");
        
        for(int i = 0; i < myList.size(); i++) {
            try{
                Integer castedValue = (Integer) myList.get(i);   
            }
            catch(ClassCastException e){
                System.out.println("Index of error: " + i);
                System.out.println("Value of error: " + myList.get(i));
                System.out.println("*****" + e + "*****");
            }
        }
    }
}

// Only index2 is an integer, all other indexes will return error
