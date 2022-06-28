package tecsup.edu.poketinder.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import tecsup.edu.poketinder.domain.model.MyPokemon
import tecsup.edu.poketinder.domain.usecase.DeleteAllMyPokemonsUseCase
import tecsup.edu.poketinder.domain.usecase.GetMyPokemonsUseCase
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getMyPokemonsUseCase: GetMyPokemonsUseCase,
    private val deleteAllMyPokemonsUseCase: DeleteAllMyPokemonsUseCase
): ViewModel() {
    val myPokemonList = MutableLiveData<List<MyPokemon>>()
    val isLoading = MutableLiveData<Boolean>()
    val isLDeleteAllPokemon = MutableLiveData<Boolean>()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getMyPokemonsUseCase()
            //Se comentó debido a que almacenda el valor anterior
            //a pesar que se borró
            //if (result.isNotEmpty()){
            myPokemonList.postValue(result)
            isLoading.postValue(false)
            //}
        }
    }

    fun deleteAllPokemon(){
        viewModelScope.launch {
            val result = deleteAllMyPokemonsUseCase()
            //deleteAllMyPokemonsUseCase()
            //isLDeleteAllPokemon.postValue(true)
        }
    }
}