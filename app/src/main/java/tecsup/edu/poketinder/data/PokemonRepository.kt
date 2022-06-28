package tecsup.edu.poketinder.data

import tecsup.edu.poketinder.data.database.dao.PokemonDao
import tecsup.edu.poketinder.data.database.entities.MyPokemonEntity
import tecsup.edu.poketinder.data.model.PokemonDetailModel
import tecsup.edu.poketinder.data.model.PokemonListModel
import tecsup.edu.poketinder.data.model.PokemonModel
import tecsup.edu.poketinder.data.network.PokemonService
import tecsup.edu.poketinder.domain.model.MyPokemon
import tecsup.edu.poketinder.domain.model.Pokemon
import tecsup.edu.poketinder.domain.model.toDomain
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonService: PokemonService,
    private val pokemonDao: PokemonDao
) {
    suspend fun getAllPokemonFromApi(): List<Pokemon>{
        val listResponse: PokemonListModel=pokemonService.getPokemons()
        val response: List<PokemonModel> = listResponse.results
        return response.map {it.toDomain()}
    }

    suspend fun getPokemonDetailFromApi(idPokemon:String): PokemonDetailModel{
        //val response =pokemonService.getPokemonsById(idPokemon)
        //return response.map {it.toDomain()}
        return pokemonService.getPokemonById(idPokemon)
    }

    suspend fun getMyPokemonsFromDatabase():List<MyPokemon>{
        val response:List<MyPokemonEntity> = pokemonDao.getAllPokemons()
        return response.map{it.toDomain()}
    }

    suspend fun insertMyPokemon(myPokemon:MyPokemonEntity){
        pokemonDao.insert(myPokemon)
    }

    suspend fun deleteAllMyPokemon(){
        pokemonDao.deleteTable()
    }

}