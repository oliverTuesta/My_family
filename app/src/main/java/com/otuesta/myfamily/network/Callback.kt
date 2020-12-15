package com.otuesta.myfamily.network

interface Callback<T> {

    fun onSucces(result: T?)

    fun onFail(exception: Exception)

}