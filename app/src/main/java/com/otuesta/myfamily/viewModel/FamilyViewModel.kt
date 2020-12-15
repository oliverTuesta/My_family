package com.otuesta.myfamily.viewModel

import androidx.lifecycle.MutableLiveData
import com.otuesta.myfamily.model.Person
import com.otuesta.myfamily.network.Callback
import com.otuesta.myfamily.network.FirestoreService

class FamilyViewModel {
    val firestoreService = FirestoreService()
    var listFamily: MutableLiveData<List<Person>> = MutableLiveData()
    var isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun refresh(){
        getFamilyfromfirebase()
    }

    private fun getFamilyfromfirebase() {
        firestoreService.getFamily(object : Callback<List<Person>>{
            override fun onSucces(result: List<Person>?) {
                listFamily.postValue(result)
                processFinished()
            }

            override fun onFail(exception: Exception) {
                TODO("Not yet implemented")
                processFinished()
            }
        })
    }
    private fun processFinished() {
        isLoading.value = true
    }

}