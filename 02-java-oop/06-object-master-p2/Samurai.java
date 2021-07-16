public class Samurai extends Human{
    public int health = 200;
    static int count = 0;

    public Samurai(){
        this.setHealth(200);
        count++;
    }

    public void deathBlow(Human otherHuman){
        otherHuman.setHealth(0);
        this.setHealth(this.health/2);
        System.out.println("Samurai used skill DeathBlow, the target's health has dropped to 0, Samurai's heal also down by half");
    }

    public void meditate(){
        int health = getHealth();
        this.health = this.health * 1.5;
        this.setHealth(this.health);
        System.out.println("Samurai used skill Meditate, his health has increased 50% to " + getHealth());
    }

    public void howMany(){
        System.out.println(count);
    }
}
