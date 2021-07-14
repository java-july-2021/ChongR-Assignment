public class Mammal {
    protected int energyLevel = 100;

    public int displayEnergy(){
        // private int energyLevel = 100;
        System.out.println("His energy level is: " + this.energyLevel);
        return this.energyLevel;
    }
}