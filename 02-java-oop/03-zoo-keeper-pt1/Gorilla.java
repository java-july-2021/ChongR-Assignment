public class Gorilla extends Mammal{
    public void throwSomething(){
        System.out.println("The gorilla has thrown something");
        energyLevel = energyLevel - 5;
        displayEnergy();
    }

    public void eatBananas(){
        System.out.println("The gorilla is satisfied eating bananas");
        energyLevel += 10;
        displayEnergy();
    }

    public void climb(){
        System.out.println("The gorilla climbed a tree");
        energyLevel -= 10;
        displayEnergy();
    }
}