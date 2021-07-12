import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.List;

public class puzzling {
    Random r = new Random();

    public int Sum(int[] arr){
        int sum = 0;
        for(int number:arr){
            sum+=number;
        }
        return sum;
    } 

    public ArrayList GreaterThan10(int[] arr){
        ArrayList<Integer> res = new ArrayList<>();
        for(int number:arr){
            if(number > 10){
                res.add(number);
            }
        }
        return res;
    }

    public ArrayList NameBook(){
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> longname = new ArrayList<>();
        names.add("Nancy");
        names.add("Jinchi");
        names.add("Fujibayashi");
        names.add("Momochi");
        names.add("Ishikawa");
        Collections.shuffle(names);
        System.out.println("All names: " + names);

        for(String name : names){
            if(name.length()>5){
                longname.add(name);
            }
        }
        return longname;
    }

    public ArrayList Alphabet(){
        ArrayList<Character> alphabet = new ArrayList<>();
        // Random r = new Random();       //moved it to the top
        for(char i='a'; i<='z'; i++){
            alphabet.add(i);
        }
    
        Collections.shuffle(alphabet);
        System.out.println("The first char of the list is " + alphabet.get(0));
        System.out.println("The last char of the list is " + alphabet.get(alphabet.size()-1));

        char[] vowel = {'a', 'e', 'i', 'o', 'u'};
        for(char x:vowel){
            if(x == alphabet.get(0)){
                System.out.println("***The first char in the shuffled alphabet is a vowel***");
                break;
            }
        }

        // int rnum =r.nextInt(26);
        // char rchr = alphabet.get(rnum);
        // System.out.println("The " + rnum + " index random charactor is " + rchr);

        // boolean found = false;
        // for(char x:vowel){
        //     if(x == rchr){
        //         found = true;
        //         break;
        //     }
        // }
        // if(found == true){
        //     System.out.println("The selected random char is a vowel.");
        // }
        
        return alphabet;
    }

    public String TenRandNum(){
        // Random r = new Random();     //Moved it to the top, so we don't need to repeat it in future methods.
    
        int[] arr = new int[10];
        for(int i=0;i<10;i++){
            int rnum = r.nextInt(45) + 55;
            arr[i] = rnum;
        }
        return Arrays.toString(arr);
    }

    public String SortTenNum(){
        int[] arr = new int[10];
        for(int i=0;i<10;i++){
            int rnum = r.nextInt(45) + 55;
            arr[i] = rnum;
        }
        Arrays.sort(arr);
        System.out.println("The minimum value is " + arr[0]);
        System.out.println("The maximum value is " + arr[arr.length-1]);
        return Arrays.toString(arr);
    }

    public String RandomStr(){
        ArrayList<Character> alphabet = new ArrayList<>();
        ArrayList<Character> randchar = new ArrayList<>();
        for(char i='a'; i<='z'; i++){
            alphabet.add(i);
        }
        for(int i=0; i<5;i++){
            int rnum =r.nextInt(26);
            char rchr = alphabet.get(rnum);
            randchar.add(rchr);
        }
        StringBuilder randstring = new StringBuilder();
        for(char x:randchar){
            randstring.append(x);
        }
        return randstring.toString();
    }

    public String[] TenRandomStr(){
        String[] arr = new String[10];
        for(int i=0;i<10;i++){
            arr[i] = RandomStr();
        }
        return arr;     //Need to use Arrays.toString() when calling the method in the puzzlingTest.java in order to translate the address to actual str array
    }
}