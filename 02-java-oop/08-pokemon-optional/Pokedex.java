import java.util.ArrayList;

public class Pokedex extends AbstractPokemon{
    public static void main(String[] args) {
        Pokemon Pikachu = new Pokemon("Pikachu", 100, "Electric");
        Pokemon Lapras = new Pokemon("Lapras", 180, "Water");

        System.out.println(createPokemon("Raichu", 140, "Electric" ));


        // public ArrayList<String> myPokemons(Pokemon pokemon){
        //     ArrayList<Spring> list = new ArrayList<String>();
        //     list.add(pokemon);
        //     return list;
        // }

        // System.out.println();
        Pikachu.attackPokemon(Lapras);
        // System.out.println(Lapras.health);
    }
}
