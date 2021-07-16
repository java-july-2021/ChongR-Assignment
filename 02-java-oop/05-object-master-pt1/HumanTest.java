public class HumanTest {
    public static void main(String[] args) {
        Human1 Wizard = new Human1();
        System.out.println(Wizard.getHealth());

        Human1 Ninja = new Human1();

        Wizard.attack(Ninja);
        System.out.println(Wizard.health);
        System.out.println(Ninja.health);
    }
}
