public class Samurai extends Human1{
    public double health = 150.0;
    public static int count = 0;

    public Samurai(){
        // this.setHealth(200);
        count++;
    }

    public void deathBlow(Human1 otherHuman){
        otherHuman.setHealth(0);
        this.setHealth(this.health/2);
        System.out.println("Samurai used skill DeathBlow, the target's health has dropped to 0, Samurai's heal also down by half");
    }

    public void meditate(){
        // double health = getHealth();
        // this.health = this.health * 1.5;
        // this.setHealth(this.health);
        this.setHealth((this.getHealth())*1.5);
        System.out.println("Samurai used skill Meditate, his health has increased 50% to " + getHealth());
    }

    public static void howMany(){
        System.out.println(count);
        //return count;
    }
}