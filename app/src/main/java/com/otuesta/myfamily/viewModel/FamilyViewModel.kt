package com.otuesta.myfamily.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.otuesta.myfamily.model.Family
import com.otuesta.myfamily.network.Callback
import com.otuesta.myfamily.network.FirestoreService

class FamilyViewModel: ViewModel() {
    private val firestoreService = FirestoreService()
    var listFamily: MutableLiveData<List<Family>> = MutableLiveData()
    var isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun refresh(){
        getFamilyfromfirebase()
    }

    private fun getFamilyfromfirebase() {
        firestoreService.getFamily(object : Callback<List<Family>> {
            override fun onSucces(result: List<Family>?) {
                listFamily.postValue(result)
                processFinished()
            }

            override fun onFail(exception: Exception) {
                println(exception.message)
                processFinished()
            }
        })
    }
    private fun processFinished() {
        isLoading.value = true
    }

}