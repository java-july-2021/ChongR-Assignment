public class Bat extends Mammal {
    // public int energyLevel = 300;

    public void fly(){
        if (this.energyLevel < 50){
            System.out.println("There's not enough energy for the bat to do so!");
        }
        else{
            this.energyLevel = this.energyLevel - 50;
        System.out.println("SQUEAK! \n The energy level of bat decreased 50!");
        displayEnergy();
        }
    }

    public void eatHumans(){
        this.energyLevel = this.energyLevel + 25;
        System.out.println("AHHHHHHHHH!!! \n The giant bat ate a human, and his energy level increased 25!");
        displayEnergy();
    }

    public void attackTown(){
        if (this.energyLevel < 100){
            System.out.println("There's not enough energy for the bat to do so!");
        }
        else{
            this.energyLevel = this.energyLevel - 100;
            System.out.println("Giant bat attacked a town, leaves fire blazing all over the town");
            displayEnergy();
        }
    }
}
