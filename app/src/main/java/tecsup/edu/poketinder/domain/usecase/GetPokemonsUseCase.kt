package tecsup.edu.poketinder.domain.usecase

import tecsup.edu.poketinder.data.PokemonRepository
import tecsup.edu.poketinder.domain.model.Pokemon
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(
    private val repository:PokemonRepository){

    suspend operator fun invoke():List<Pokemon>{

        val myPokemonList = repository.getMyPokemonsFromDatabase()

        val allPokemon = repository.getAllPokemonFromApi()

        val myPokemonListIds = myPokemonList.map{it.idPokemon}

        //return repository.getAllPokemonFromApi()
        return allPokemon.filter{it.getPokemonId() !in myPokemonListIds}
    }
}