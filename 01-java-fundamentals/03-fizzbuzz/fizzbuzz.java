public class fizzbuzz {

    public String fizzBuzz(int number){
        if(number%3==0 && number%5==0){
            return "FizzBuzz";
        }
        else if(number%3==0){
            return "Fizz"; 
        }
        else if(number%5==0){
            return "Buzz"; 
        }
        else{
            return Integer.toString(number); 
        }
    }

    public void numberfeeder(){
        for(int i=0; i<100; i++){
            String result = fizzBuzz(i);
            System.out.println("Number " + i + " - Result: " + result );
        }
    }
}
