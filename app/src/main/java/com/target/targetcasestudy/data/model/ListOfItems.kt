package com.target.targetcasestudy.data.model

import com.google.gson.annotations.SerializedName

data class ListOfItems(

	@field:SerializedName("products")
	val products: List<ProductsItem?>? = null
)