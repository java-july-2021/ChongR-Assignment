public class Wizard extends Human1{
    public double health = 50.0;
    public int intelligence = 8;

    public void heal(Human1 otherHuman){
        otherHuman.health += this.intelligence;
        System.out.println("Wizard used Heal magic, target's health has increased by: " + this.intelligence);
    }

    public void fireball(Human1 otherHuman){
        otherHuman.health -= 3 * this.intelligence;
        System.out.println("Wizard used Fireball magic, target's health has increased by: " + this.intelligence);
    }
}
