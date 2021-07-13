public class projectTest {
    public static void main(String[] args) {
        
        // project elevatorPitch = new project("elevatorPitch");
        project elevatorPitch = new project("ElevatorPitch", "Description of this project");

        String name = elevatorPitch.getName();
        System.out.println("The project name is: " + name);
        //The project name is: elevatorPitch

        String desc = elevatorPitch.getDescription();
        System.out.println("The project description is: " + desc);
        // The project description is: Description of this project



        // project test = new project();
        project pj1 = new project("pj01", "dc01");
        System.out.println(pj1.getName());
        System.out.println(pj1.getDescription());
    }
}
