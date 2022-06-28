package tecsup.edu.poketinder.domain.usecase

import tecsup.edu.poketinder.data.PokemonRepository
import tecsup.edu.poketinder.data.database.entities.toDatabase
import tecsup.edu.poketinder.domain.model.MyPokemon
import javax.inject.Inject

class SaveMyPokemonUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
){
    suspend operator fun invoke(myPokemon: MyPokemon){
        pokemonRepository.insertMyPokemon(myPokemon.toDatabase())
    }
}