package tecsup.edu.poketinder.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tecsup.edu.poketinder.R
import tecsup.edu.poketinder.domain.model.MyPokemon
import tecsup.edu.poketinder.ui.holder.MyPokemonsHolder
import tecsup.edu.poketinder.util.inflate

class MyPokemonsAdapter(val list: List<MyPokemon>):
    RecyclerView.Adapter<MyPokemonsHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPokemonsHolder {
        val view = parent.inflate(R.layout.item_pokemon_saved)
        return MyPokemonsHolder(view)
    }

    override fun onBindViewHolder(holder: MyPokemonsHolder, position: Int) {
        val item =list[position]
        holder.bind(item)
    }

    override fun getItemCount():Int = list.size


}