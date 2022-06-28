package tecsup.edu.poketinder.domain.model

import tecsup.edu.poketinder.data.model.PokemonDetailModel

data class PokemonDetail(
    val id: Int,
    val base_experience: Int,
    val height: Int,
    val weight: Int,
    val stats: List<PokemonDetailModel.Stats>,
    val types: List<PokemonDetailModel.Types>,
    val abilities: List<PokemonDetailModel.Abilities>
) {


    fun PokemonDetailModel.toDomain() = PokemonDetail(
        id = id,
        base_experience = base_experience,
        height = height,
        weight = weight,
        stats = stats,
        types = types,
        abilities = abilities
    )
}