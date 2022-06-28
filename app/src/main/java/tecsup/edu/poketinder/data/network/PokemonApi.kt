package tecsup.edu.poketinder.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import tecsup.edu.poketinder.data.model.PokemonDetailModel
import tecsup.edu.poketinder.data.model.PokemonListModel

interface PokemonApi {
    @GET("?limit=20")
    suspend fun  getPokemons(): Response<PokemonListModel>
    /*
    @GET("{pokemon_id}")
    suspend fun getDetailPokemon(
        @Path("pokemon_id") pokemonId: String
    ): PokemonDetailModel
    */
    @GET("{pokemon_id}")
    suspend fun getDetailPokemon(
        @Path("pokemon_id") pokemonId: String
    ): Response<PokemonDetailModel>
}