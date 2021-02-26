package com.target.targetcasestudy.data.model

import com.google.gson.annotations.SerializedName

data class ProductsItem(

	@field:SerializedName("regular_price")
	val regularPrice: RegularPrice? = null,

	@field:SerializedName("image_url")
	val imageUrl: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("aisle")
	val aisle: String? = null,

	@field:SerializedName("sale_price")
	val salePrice: SalePrice? = null
)