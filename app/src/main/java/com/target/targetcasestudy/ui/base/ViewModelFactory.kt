package com.target.targetcasestudy.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.target.targetcasestudy.data.api.ApiHelper
import com.target.targetcasestudy.data.repository.MainRepo
import com.target.targetcasestudy.ui.main.viewmodel.DealItemViewModel
import com.target.targetcasestudy.ui.main.viewmodel.DealListViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DealListViewModel::class.java)) {
            return DealListViewModel(MainRepo(apiHelper)) as T
        }
        else if(modelClass.isAssignableFrom(DealItemViewModel::class.java)){
            return DealItemViewModel(MainRepo(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}