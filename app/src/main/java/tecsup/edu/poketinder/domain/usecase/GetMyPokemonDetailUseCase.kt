package tecsup.edu.poketinder.domain.usecase

import tecsup.edu.poketinder.data.PokemonRepository
import tecsup.edu.poketinder.data.model.PokemonDetailModel
import javax.inject.Inject

class GetMyPokemonDetailUseCase @Inject constructor(
    private val repository: PokemonRepository
){
    suspend operator fun invoke(idPokemon:String): PokemonDetailModel {
        return repository.getPokemonDetailFromApi(idPokemon)
    }
}