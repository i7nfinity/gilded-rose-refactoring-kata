package com.gildedrose.kotlin

class AgedBrieItem(
    name: String,
    sellIn: Int,
    quality: Int,
) : UpdatableItem(
    name,
    sellIn,
    quality
) {
    override fun updateQuality() {
        if (quality < 50) quality++
        sellIn--
        if (sellIn < 0 && quality < 50) quality++
    }
}