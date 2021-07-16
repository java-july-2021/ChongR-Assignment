public class Wizard extends Human{
    public int health = 50;
    public int intelligence = 8;

    public void heal(Human otherHuman){
        otherHuman.health += this.intelligence;
        System.out.println("Wizard used Heal magic, target's health has increased by: " + this.intelligence);
    }

    public void fireball(Human otherHuman){
        otherHuman.health -= 3 * this.intelligence;
        System.out.println("Wizard used Fireball magic, target's health has increased by: " + this.intelligence);
    }
}
