package com.target.targetcasestudy.data.api

import com.target.targetcasestudy.data.model.ItemDetails
import com.target.targetcasestudy.data.model.ListOfItems
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/mobile_case_study_deals/v1//deals")
    suspend fun getListOfItems(): Response<ListOfItems>

    @GET("/mobile_case_study_deals/v1//deals/{product_id}")
    suspend fun getDetailsOfTheItem(@Path(value = "product_id")id: Int?): Response<ItemDetails>

}