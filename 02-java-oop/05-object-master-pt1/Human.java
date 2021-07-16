public class Human1 {
    public double health = 100;
    public int strength = 3;
    public int intelligence = 3;
    public int stealth = 3;

    public void setHealth(int health){
        this.health = health;
    }

    public float getHealth(){
        return this.health;
    }

    public void attack(Human1 otherHuman){
        int otherHumanHealth = otherHuman.getHealth();
        otherHumanHealth -= strength;
        otherHuman.setHealth(otherHumanHealth);
    }

}
