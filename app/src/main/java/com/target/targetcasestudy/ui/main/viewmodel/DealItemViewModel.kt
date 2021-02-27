package com.target.targetcasestudy.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.target.targetcasestudy.data.repository.MainRepo
import com.target.targetcasestudy.utils.Resource
import kotlinx.coroutines.Dispatchers

class DealItemViewModel(private val mainRepo: MainRepo) : ViewModel() {

    fun getDetailsOfTheItem(id: Int?) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepo.getDetailsOfTheItem(id).body()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}