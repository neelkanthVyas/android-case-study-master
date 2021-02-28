package com.target.targetcasestudy.ui.main.adapter

import com.target.targetcasestudy.data.model.ProductsItem
import com.target.targetcasestudy.ui.main.view.DealListFragment

interface OnRecyclerItemClicked{
    fun clickedItemCallBack(productsItem: ProductsItem?)
}

 interface FragmentCallback {
    fun onClickCell(fragment: DealListFragment?, productsItem: ProductsItem?)
}