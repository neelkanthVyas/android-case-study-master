package com.target.targetcasestudy.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getListOfItems() = apiService.getListOfItems()
    suspend fun getDetailsOfTheItem() = apiService.getDetailsOfTheItem()
}