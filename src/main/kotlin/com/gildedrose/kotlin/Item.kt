package com.gildedrose.kotlin

open class Item(
    var name: String,
    var sellIn: Int,
    var quality: Int,
) {
    override fun toString(): String = "$name, $sellIn, $quality"

    fun decrementQuality() {
        this.quality = this.quality.dec()
    }

    fun incrementQuality() {
        this.quality = this.quality.inc()
    }

    fun incrementQualityIfPossible() {
        if (!hasMaximalQuality()) {
            incrementQuality()
        }
    }

    fun hasMaximalQuality(): Boolean = this.quality >= MAX_ITEM_QUALITY

    companion object {
        const val MAX_ITEM_QUALITY = 50
    }
}
