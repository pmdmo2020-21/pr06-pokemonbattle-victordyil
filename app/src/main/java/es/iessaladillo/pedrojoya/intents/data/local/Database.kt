package es.iessaladillo.pedrojoya.intents.data.local

import es.iessaladillo.pedrojoya.intents.data.local.model.Pokemon

// TODO: Haz que Database implemente DataSource
object Database : DataSource {
    private var pokemons: List<Pokemon> = listOf(
        Pokemon(1, "Bulbasur", Pokemon.Tipos.PLANTA, "drawable\\bulbasur.png"),
        Pokemon(2, "Cubone", Pokemon.Tipos.NORMAL, "drawable\\cubone.png"),
    )

    override fun getRandomPokemon(): Pokemon = pokemons.random()

    override fun getAllPokemons(): List<Pokemon> = pokemons.toList()

    override fun getPokemonById(id: Long): Pokemon? = pokemons.find { pokemon -> pokemon.id == id }

}