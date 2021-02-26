package com.target.targetcasestudy.data.api

import com.target.targetcasestudy.data.model.ItemDetails
import com.target.targetcasestudy.data.model.ListOfItems
import retrofit2.http.GET

interface ApiService {

    @GET()
    suspend fun getListOfItems(): ListOfItems

    @GET()
    suspend fun getDetailsOfTheItem(): ItemDetails

}