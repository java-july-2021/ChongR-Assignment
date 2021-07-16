public class Ninja extends Human1{
    public int stealth = 10;

    public void steal(Human1 otherHuman){
        otherHuman.health -= this.stealth;
        this.health += this.stealth;
        System.out.println("Ninja has steal " + this.stealth + " health from target, Ninja's health is: " + this.getHealth());
    }

    public void runAway(){
        this.health -= 10;
        System.out.println("Ninja escaped from battle...");
    }
}
