package tecsup.edu.poketinder.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import tecsup.edu.poketinder.data.model.PokemonDetailModel
import tecsup.edu.poketinder.domain.usecase.GetMyPokemonDetailUseCase
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel@Inject constructor(
    private val getMyPokemonDetailUseCase: GetMyPokemonDetailUseCase
): ViewModel(){
    val pokemonDetailModel= MutableLiveData<PokemonDetailModel>()
    val isLoading = MutableLiveData<Boolean>()
    //val pokemon = MutableLiveData<PokemonDetail>()
    fun onCreate(idPokemon: String){
        viewModelScope.launch{
            isLoading.postValue(true)
            val result=getMyPokemonDetailUseCase.invoke(idPokemon)
            pokemonDetailModel.postValue(result)
            isLoading.postValue(false)
        }
    }
}