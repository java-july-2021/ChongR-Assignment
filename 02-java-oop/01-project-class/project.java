public class project {
    private String name;
    private String description;

    public project(String name){
        this.name = name;
    }

    public project(String name, String description){
        this.name = name;
        this.description = description;
        // System.out.println(name);
        // System.out.println(description);
    }

    

    public void showProject() {
        System.out.println("Project name: " + name);
        System.out.println("Description: " + description);
    }
    
    
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    // do we need to write these getName/getDescription functions?
}
