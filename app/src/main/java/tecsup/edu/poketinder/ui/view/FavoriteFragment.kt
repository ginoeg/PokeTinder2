package tecsup.edu.poketinder.ui.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import tecsup.edu.poketinder.R
import tecsup.edu.poketinder.databinding.FragmentFavoriteBinding
import tecsup.edu.poketinder.domain.model.MyPokemon
import tecsup.edu.poketinder.ui.adapter.MyPokemonsAdapter
import tecsup.edu.poketinder.ui.viewmodel.FavoriteViewModel

@AndroidEntryPoint
class FavoriteFragment:BaseFragment<FragmentFavoriteBinding>(FragmentFavoriteBinding :: inflate) {
    private var listMyPokemon = mutableListOf<MyPokemon>()
    private val adapter by lazy { MyPokemonsAdapter(listMyPokemon) }
    private val viewModel: FavoriteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.onCreate()
        binding.rvPokemons.adapter = adapter

        viewModel.myPokemonList.observe(this) {
            listMyPokemon.addAll(it)
            adapter.notifyDataSetChanged()

        }
    }
}