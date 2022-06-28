package tecsup.edu.poketinder.domain.usecase

import tecsup.edu.poketinder.data.PokemonRepository
import tecsup.edu.poketinder.domain.model.MyPokemon
import javax.inject.Inject

class GetMyPokemonsUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke():List<MyPokemon>{
        return pokemonRepository.getMyPokemonsFromDatabase()
    }
}