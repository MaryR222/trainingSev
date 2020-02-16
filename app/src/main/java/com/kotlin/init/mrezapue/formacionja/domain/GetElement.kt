package com.kotlin.init.mrezapue.formacionja.domain


import androidx.paging.DataSource
import com.kotlin.init.mrezapue.formacionja.data.ElementRepository
import com.kotlin.init.mrezapue.formacionja.model.Element

class GetElement(private val repository: ElementRepository) {
    operator fun invoke(): DataSource.Factory<Int, Element> = repository.getElements()
}