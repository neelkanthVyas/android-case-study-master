package com.target.targetcasestudy.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.target.targetcasestudy.R
import com.target.targetcasestudy.data.model.ProductsItem
import com.target.targetcasestudy.ui.main.view.DealListFragment
import kotlinx.android.synthetic.main.deal_list_item.view.*

class DealItemAdapter(private val itemList: ArrayList<ProductsItem?>, dealListFragment: DealListFragment) : RecyclerView.Adapter<DealItemAdapter.DealItemViewHolder>() {

    private var onItemClicked:OnRecyclerItemClicked = dealListFragment

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealItemViewHolder =
            DealItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.deal_list_item, parent, false))

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(viewHolder: DealItemViewHolder, position: Int) {
        viewHolder.itemView.setOnClickListener { onItemClicked.clickedItemCallBack(itemList[position]) }
        itemList[position]?.let {
            viewHolder.bind(
                    it
            )
        }
    }

    fun addItems(items: List<ProductsItem?>?) {
        itemList.apply {
            clear()
            items?.let { addAll(it) }
        }
    }

    class DealItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(items: ProductsItem) {
            itemView.apply {
                deal_list_item_title.text = items.title
                deal_list_item_price.text = items.regularPrice?.displayString ?: BASE_VALUE
                Glide.with(deal_list_item_image_view.context)
                        .load(items.imageUrl)
                        .into(deal_list_item_image_view)
            }
        }


        companion object {
            const val BASE_VALUE = "$0.0"
        }
    }

}
