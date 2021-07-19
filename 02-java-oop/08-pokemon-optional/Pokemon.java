public class Pokemon {
    public String name = "";
    public float health;
    public String type = "";
    public static int count;


    public Pokemon(String name, float health, String type){
        this.name = name;
        this.health = health;
        this.type = type;
        count++;
    }


    public void attackPokemon(Pokemon pokemon){
        pokemon.health -= 10;
        System.out.println("You attacked " + pokemon.name + ", and its health is decreased by 10.");
    }


    //--------------  Getters  ----------------//
    public static int getCount(){
        return count;
    }

    public String getName(){
        return name;
    }

    public float getHealth(){
        return health;
    }

    public String getType(){
        return type;
    }

    public void getInfo(){
        System.out.println("The " + name + "");
    }


    //----------------  Setters  -----------------//
    public void setName(String name){
        this.name = name;
    }

    public void setHealth(float health){
        this.health = health;
    }

    public void setType(String type){
        this.type = type;
    }
}