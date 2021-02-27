package com.target.targetcasestudy.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.target.targetcasestudy.data.repository.MainRepo
import com.target.targetcasestudy.utils.Resource
import kotlinx.coroutines.Dispatchers

class DealListViewModel(private val mainRepo: MainRepo) : ViewModel() {

    fun getListOfItems() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepo.getListOfItems().body()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}