package com.target.targetcasestudy.ui.main.adapter

import android.text.method.TextKeyListener.clear
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.target.targetcasestudy.R
import com.target.targetcasestudy.data.model.ProductsItem
import java.util.Collections.addAll

class DealItemAdapter(private val itemList: ArrayList<ProductsItem?>) : RecyclerView.Adapter<DealItemViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealItemViewHolder =
    DealItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.deal_list_item, parent, false))

  override fun getItemCount(): Int = itemList.size

  override fun onBindViewHolder(viewHolder: DealItemViewHolder, position: Int) { itemList[position]?.let {
    viewHolder.bind(
      it
    )
  }}
  fun addItems(items: List<ProductsItem?>?) {
    itemList.apply {
      clear()
      items?.let { addAll(it) }
    }
  }
}

class DealItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  fun bind(items: ProductsItem) {
//    itemView.apply {
//      textViewUserName.text = user.name
//      textViewUserEmail.text = user.email
//      Glide.with(imageViewAvatar.context)
//        .load(user.avatar)
//        .into(imageViewAvatar)
//    } set data here
  }

}