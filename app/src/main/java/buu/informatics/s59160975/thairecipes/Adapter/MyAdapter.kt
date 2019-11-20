package buu.informatics.s59160975.thairecipes.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import buu.informatics.s59160975.thairecipes.DataClass.recipes
import buu.informatics.s59160975.thairecipes.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item.view.*

class MyAdapter(private val recipes: List<recipes>, private val clickListener: (recipes)
-> Unit): RecyclerView.Adapter<MyAdapter.ViewHolder>(){
    class ViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(item:recipes, clickListener: (recipes) -> Unit){
            itemView.apply {
                nameMenu_text.text = item.name

            }
            Picasso.get().load(item.image).into(itemView.menu_image)
            itemView.setOnClickListener{
                clickListener(item)
            }
        }
    }

    override fun getItemCount(): Int = recipes.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(recipes[position], clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }
}