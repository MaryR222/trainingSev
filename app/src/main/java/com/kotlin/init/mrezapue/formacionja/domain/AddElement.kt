package com.kotlin.init.mrezapue.formacionja.domain


import com.kotlin.init.mrezapue.formacionja.data.ElementRepository
import com.kotlin.init.mrezapue.formacionja.model.Element

class AddElement(private val repository: ElementRepository) {
    operator fun invoke(): List<Element> = repository.addElement()
}