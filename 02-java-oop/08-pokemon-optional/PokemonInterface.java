public interface PokemonInterface {
    Pokemon createPokemon(String name, float health, String type);

    String pokemonInfo(Pokemon pokemon);

    void listPokemon();
}
