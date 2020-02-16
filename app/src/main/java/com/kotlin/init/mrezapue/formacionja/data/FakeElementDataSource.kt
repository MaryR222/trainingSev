package com.kotlin.init.mrezapue.formacionja.data

import androidx.paging.ItemKeyedDataSource
import com.kotlin.init.mrezapue.formacionja.model.Element

class FakeElementDataSource : ItemKeyedDataSource<Int, Element>() {
    private var lastPosition = 0

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Element>
    ) {
        val elements = (lastPosition until lastPosition + AMOUNT).map {
            Element(name = "Initial $it")
        }
        lastPosition += AMOUNT

        callback.onResult(elements)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Element>) {
        val startPosition = params.key
        lastPosition = startPosition + AMOUNT

        val elements = (startPosition until lastPosition).map {
            Element(name = "After $it")
        }

        callback.onResult(elements)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Element>) {
        val startPosition = params.key
        lastPosition = startPosition + AMOUNT

        val elements = (startPosition until lastPosition).map {
            Element(name = "Before $it")
        }

        callback.onResult(elements)
    }

    override fun getKey(item: Element): Int = lastPosition

    companion object {
        private const val AMOUNT = 10
    }
}