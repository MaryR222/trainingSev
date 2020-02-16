package com.kotlin.init.mrezapue.formacionja.data
import androidx.paging.DataSource
import com.kotlin.init.mrezapue.formacionja.model.Element

class ElementRepository(private val dataSourceFactory: DataSource.Factory<Int, Element>) {
    fun getElements() : DataSource.Factory<Int, Element> = dataSourceFactory
}