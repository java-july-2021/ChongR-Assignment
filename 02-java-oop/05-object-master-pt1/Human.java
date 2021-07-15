public class Human {
    public int health = 100;
    public int strength = 3;
    public int intelligence = 3;
    public int stealth = 3;

    public void setHealth(int health){
        this.health = health;
    }

    public int getHealth(){
        return this.health;
    }

    public void attack(Human otherHuman){
        int otherHumanHealth = otherHuman.getHealth();
        otherHumanHealth -= strength;
        otherHuman.setHealth(otherHumanHealth);
    }

}
