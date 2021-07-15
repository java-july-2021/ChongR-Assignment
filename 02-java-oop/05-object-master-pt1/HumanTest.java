public class HumanTest {
    public static void main(String[] args) {
        Human Wizard = new Human();
        System.out.println(Wizard.getHealth());

        Human Ninja = new Human();

        Wizard.attack(Ninja);
        System.out.println(Wizard.health);
        System.out.println(Ninja.health);
    }
}
