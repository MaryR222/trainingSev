package com.kotlin.init.mrezapue.formacionja.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.kotlin.init.mrezapue.formacionja.data.ElementRepository
import com.kotlin.init.mrezapue.formacionja.domain.AddElement
import com.kotlin.init.mrezapue.formacionja.domain.GetElement
import com.kotlin.init.mrezapue.formacionja.model.Element


class MainViewModel : ViewModel() {
    private val repository = ElementRepository()
    private val getElement = GetElement(repository = repository)
    private val addElement = AddElement(repository = repository)

    val stateTitle = liveData {
        emit("Elements")
    }

    private val _stateList: MutableLiveData<List<Element>> = MutableLiveData()
    val stateList: LiveData<List<Element>>
        get() = _stateList

    fun getElements() {
        _stateList.value = getElement()
    }

    fun addElement() {
        _stateList.value = addElement.invoke()
    }
}