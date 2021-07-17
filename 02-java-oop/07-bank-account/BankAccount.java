import java.util.Arrays;
import java.util.Random;
import java.util.Arrays;

public class BankAccount {
    private String acc_num = "";
    private double chk_bal = 0;
    private double sav_bal = 0;
    private static int acc_created = 0;
    private static double total_money = 0;
    
    private String RanAccNum(){      //This is creating an array of 10 numbers, need to find a way to create a single 10 digit string.
        Random r = new Random();
        int[] acc = new int[10];
        for(int i=0; i<10; i++){
            int rnum = r.nextInt(10);
            acc[i] = rnum;
        }
        return Arrays.toString(acc);
    }
//--------- Initialize Bank Account------------//
    public BankAccount(){
        this.acc_num = RanAccNum();
        chk_bal = 0;
        sav_bal = 0;
        total_money = 0;
        acc_created++;
    }
//------------ Getters ------------------------//
    public double getChkBal(){
        return chk_bal;
    }
    public double getSavBal(){
        return sav_bal;
    }
    public double getPersonalTotal(){
        double total = this.chk_bal + this.sav_bal;
        return total;
    }
    public String getAccNum(){
        return acc_num;
    }
    public static int howMany(){
        return acc_created;
    }
    public static double totalAmt(){
        return total_money;
    }
//------------ Setters ------------------------//
    public void addSav(double money){
        this.sav_bal += money;
        total_money += money;
    }
    public void addChk(double money){
        this.chk_bal += money;
        total_money += money;
    }

    public void wdrawSav(double money){
        if(money >= this.sav_bal){
            this.sav_bal -= money;
            total_money -= money;
            System.out.println("User withdraw $" + money + " dollar from Saving account, the current balance is " + getSavBal());
        }
        else{
            System.out.println("Error! Insufficient saving balance!");
        }
    }

    public void wdrawChk(double money){
        if(money >= this.chk_bal){
            this.chk_bal -= money;
            total_money -= money;
            System.out.println("User withdraw $" + money + " dollar from Checking account, the current balance is " + getChkBal());
        }
        else{
            System.out.println("Error! Insufficient checking balance!");
        }
    }
}
