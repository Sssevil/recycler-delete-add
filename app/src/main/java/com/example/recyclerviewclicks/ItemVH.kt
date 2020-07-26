package com.example.recyclerviewclicks

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view.view.*

class ItemVH(view: View):RecyclerView.ViewHolder(view){
     fun bind(
          item: ItemData
     ){
          itemView.txt1.text=item.title
          itemView.txt2.text=item.title2
     }
}