package tecsup.edu.poketinder.domain.usecase

import tecsup.edu.poketinder.data.PokemonRepository
import tecsup.edu.poketinder.domain.model.Pokemon
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(private val repository: PokemonRepository){
    suspend operator fun invoke():List<Pokemon>{
        return repository.getAllPokemonFromApi()
    }
}