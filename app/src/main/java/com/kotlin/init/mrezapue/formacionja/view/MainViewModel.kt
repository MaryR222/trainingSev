package com.kotlin.init.mrezapue.formacionja.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

import androidx.lifecycle.liveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.kotlin.init.mrezapue.formacionja.data.ElementDataSourceFactory
import com.kotlin.init.mrezapue.formacionja.data.ElementRepository
import com.kotlin.init.mrezapue.formacionja.data.FakeElementDataSource
import com.kotlin.init.mrezapue.formacionja.domain.GetElement
import com.kotlin.init.mrezapue.formacionja.model.Element


class MainViewModel : ViewModel() {
    private val dataSource = FakeElementDataSource()
    private val dataSourceFactory = ElementDataSourceFactory(dataSource = dataSource)
    private val repository = ElementRepository(dataSourceFactory = dataSourceFactory)
    private val getElements = GetElement(repository = repository)

    val stateTitle: LiveData<String> = liveData {
        emit("ELEMENTS")
    }

    val stateList: LiveData<PagedList<Element>>

    init {
        stateList = LivePagedListBuilder(getElements(), 20).build()
    }
}