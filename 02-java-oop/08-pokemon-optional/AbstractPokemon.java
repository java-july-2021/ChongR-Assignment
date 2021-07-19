public abstract class AbstractPokemon implements PokemonInterface{
    public static Pokemon createPokemon(String name, float health, String type){
        return pokemonInfo(name);
    }

    public String pokemonInfo(Pokemon pokemon){
        return (pokemon.name, pokemon.health, pokemon.type).toString((pokemon.name, pokemon.health, pokemon.type));
        //(pokemon.name, pokemon.health, pokemon.type).toString();
    }
}
