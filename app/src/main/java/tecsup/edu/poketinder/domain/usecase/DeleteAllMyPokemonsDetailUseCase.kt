package tecsup.edu.poketinder.domain.usecase

import tecsup.edu.poketinder.data.PokemonRepository
import javax.inject.Inject

class DeleteAllMyPokemonsUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke(){
        pokemonRepository.deleteAllMyPokemon()
    }
}