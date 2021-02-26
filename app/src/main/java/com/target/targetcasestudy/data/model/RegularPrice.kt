package com.target.targetcasestudy.data.model

import com.google.gson.annotations.SerializedName

data class RegularPrice(

	@field:SerializedName("amount_in_cents")
	val amountInCents: Int? = null,

	@field:SerializedName("currency_symbol")
	val currencySymbol: String? = null,

	@field:SerializedName("display_string")
	val displayString: String? = null
)