package com.kotlin.init.mrezapue.formacionja.data

import androidx.paging.DataSource
import com.kotlin.init.mrezapue.formacionja.model.Element


class ElementDataSourceFactory(private val dataSource: DataSource<Int, Element>) :
    DataSource.Factory<Int, Element>() {

    override fun create(): DataSource<Int, Element> = dataSource
}