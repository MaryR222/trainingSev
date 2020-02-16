package com.kotlin.init.mrezapue.formacionja.data

import com.kotlin.init.mrezapue.formacionja.model.Element


class ElementRepository {
    fun getElements(): List<Element> {
        return (0 until 50).map {
            Element(name = "Element $it")
        }
    }

    fun addElement(): List<Element> {
        return (0 until 50).map {
            if (it in 6..9) {
                Element(name = "Hi $it")
            } else {
                Element(name = "Element $it")
            }
        }
    }
}