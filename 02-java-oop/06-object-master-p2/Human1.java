public class Human1 {
    public double health = 100.0;
    public int strength = 3;
    public int intelligence = 3;
    public int stealth = 3;

    public void setHealth(double health){
        this.health = health;
    }

    public double getHealth(){
        System.out.println("The character's hp is " + this.health);
        return this.health;
    }
    
    public int getStrength(){
        return this.strength;
    }

    public int getStealth(){
        return this.stealth;
    }

    public void attack(Human otherHuman){
        int otherHumanHealth = otherHuman.getHealth();
        otherHumanHealth -= strength;
        otherHuman.setHealth(otherHumanHealth);
    }

}
