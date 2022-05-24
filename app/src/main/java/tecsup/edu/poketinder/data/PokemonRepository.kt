package tecsup.edu.poketinder.data

import tecsup.edu.poketinder.data.model.PokemonListModel
import tecsup.edu.poketinder.data.model.PokemonModel
import tecsup.edu.poketinder.data.network.PokemonService
import tecsup.edu.poketinder.domain.model.Pokemon
import tecsup.edu.poketinder.domain.model.toDomain
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonService: PokemonService
) {
    suspend fun getAllPokemonFromApi(): List<Pokemon>{
        val listResponse: PokemonListModel =pokemonService.getPokemons()
        val response: List<PokemonModel> = listResponse.results
        return response.map {it.toDomain()}
    }
}