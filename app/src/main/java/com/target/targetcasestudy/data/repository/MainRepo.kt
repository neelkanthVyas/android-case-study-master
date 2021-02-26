package com.target.targetcasestudy.data.repository

import com.target.targetcasestudy.data.api.ApiHelper

class MainRepo(private val apiHelper: ApiHelper) {

    suspend fun getListOfItems() = apiHelper.getListOfItems()
    suspend fun getDetailsOfTheItem() = apiHelper.getDetailsOfTheItem()
}