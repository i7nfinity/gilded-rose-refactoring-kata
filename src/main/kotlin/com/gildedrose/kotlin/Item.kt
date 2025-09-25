package com.gildedrose.kotlin

abstract class Item(protected val name: String, protected var sellIn: Int, protected var quality: Int) {
    open fun updateSellInAndQuality() {
        decreaseSellIn()
        updateQuality()
    }

    protected open fun decreaseSellIn() {
        sellIn -= 1
    }

    protected abstract fun updateQuality()

    protected fun decreaseQuality() {
        if (quality > MIN_QUALITY) {
            quality -= 1
        }
    }

    protected fun increaseQuality() {
        if (quality < MAX_QUALITY) {
            quality += 1
        }
    }

    override fun toString(): String = "$name, $sellIn, $quality"

    companion object {
        const val MIN_QUALITY = 0
        const val MAX_QUALITY = 50
    }
}