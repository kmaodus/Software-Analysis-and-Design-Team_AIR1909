package com.air.fumic.maodus.persic.poljak.discountlocator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.core.DataClasses.Store
import kotlinx.android.synthetic.main.layout_recycler_list_item.view.*

class StoreRecyclerAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<Store> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       return StoreViewHolder(
           LayoutInflater.from(parent.context).inflate(R.layout.layout_recycler_list_item, parent, false)
       )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is StoreViewHolder ->{
                holder.bind(items.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(storeList: List<Store>){
        items = storeList
    }


    class StoreViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){
        //itemView.ID se odnosi na layout_recycler_list_item
        val storeImage: ImageView = itemView.store_image
        val storeName: TextView = itemView.store_name
        val storeDescription: TextView = itemView.store_description

        fun bind(store: Store){
            storeName.setText(store.name)
            storeDescription.setText(store.description)

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(store.imgUrl)
                .into(storeImage)
        }
    }

}