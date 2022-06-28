package tecsup.edu.poketinder.ui.view

import android.os.Bundle
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import tecsup.edu.poketinder.databinding.FragmentFavoriteBinding
import tecsup.edu.poketinder.domain.model.MyPokemon
import tecsup.edu.poketinder.ui.adapter.MyPokemonsAdapter
import tecsup.edu.poketinder.ui.viewmodel.FavoriteViewModel

@AndroidEntryPoint
class FavoriteFragment:BaseFragment<FragmentFavoriteBinding>(FragmentFavoriteBinding::inflate) {
    private var listMyPokemon = mutableListOf<MyPokemon>()
    private val adapter by lazy { MyPokemonsAdapter(listMyPokemon)}
    private val viewModel: FavoriteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        viewModel.onCreate()
        binding.rvPokemons.adapter = adapter

        viewModel.myPokemonList.observe(this){

            listMyPokemon.clear()
            listMyPokemon.addAll(it)
            adapter.notifyDataSetChanged()
        }

        /*
        binding.floatingActionDelete.setOnClickListener{
            viewModel.deleteAllPokemon()
            listMyPokemon.clear()
            adapter.notifyDataSetChanged()
            viewModel.onCreate()
        }*/

        viewModel.isLDeleteAllPokemon.observe(this){
            viewModel.onCreate()
        }

    }
}