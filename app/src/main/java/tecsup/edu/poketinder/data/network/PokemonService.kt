package tecsup.edu.poketinder.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import tecsup.edu.poketinder.data.model.PokemonListModel
import javax.inject.Inject

class PokemonService @Inject constructor(private val pokemonApi: PokemonApi) {
    suspend fun getPokemons():PokemonListModel{
        return withContext(Dispatchers.IO){
            val res: Response<PokemonListModel> =pokemonApi.getPokemons()
            res.body()!!
        }
    }
}