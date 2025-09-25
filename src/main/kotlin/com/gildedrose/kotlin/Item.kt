package com.gildedrose.kotlin

open class Item(
    // TODO var -> val
    var name: String,
    var sellIn: Int, // срок годности
    var quality: Int,
) {
    fun updateSellIn(increment: Int) {
        sellIn += increment
    }

    fun updateQuality(increment: Int) {
        quality += increment
    }

    @JvmName("asd")
    fun setQuality(newQuality: Int) {
        quality = newQuality
    }

    override fun toString(): String = "$name, $sellIn, $quality"
}