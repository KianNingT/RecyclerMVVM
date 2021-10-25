package com.example.recyclermvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recyclermvvm.models.RecyclerList
import com.example.recyclermvvm.network.RetroInstance
import com.example.recyclermvvm.network.RetroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {

    private var _recyclerListLiveData: MutableLiveData<RecyclerList> = MutableLiveData()

    val recyclerListLiveData : LiveData<RecyclerList> get() = _recyclerListLiveData


    fun makeApiCall() {
        //make api call in IO thread instead of main thread
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response = retroInstance.getDataFromApi("leet")
            _recyclerListLiveData.postValue(response)
        }
    }
}