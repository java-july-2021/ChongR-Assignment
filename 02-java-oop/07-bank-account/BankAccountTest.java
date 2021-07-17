public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount user1 = new BankAccount();

        System.out.println(user1.getAccNum());

        user1.addChk(100);
        
        user1.addSav(350);

        System.out.println(user1.getPersonalTotal());

        user1.wdrawChk(50);

        user1.wdrawChk(200);
        
        System.out.println(user1.getPersonalTotal());

        System.out.println(BankAccount.howMany());
    }
}
