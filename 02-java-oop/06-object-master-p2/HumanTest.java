public class HumanTest {
    public static void main(String[] args) {
        Wizard w1 = new Wizard();
        Ninja n1 = new Ninja();
        Samurai s1 = new Samurai();
        Samurai s2 = new Samurai();

        System.out.println(w1.getHealth());
        System.out.println(n1.getHealth());
        System.out.println(s1.getHealth());
        System.out.println(s2.getHealth());

        //System.out.println(Samurai.howMany());  //should it be Samurai.howmany or s1.howmany?

        s1.howMany();


        s1.deathBlow(n1);
        System.out.println(s1.getHealth());
        s1.meditate();
        System.out.println(s1.getHealth());
        System.out.println(n1.getHealth());
    }
}
`