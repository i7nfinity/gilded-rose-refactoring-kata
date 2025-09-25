package com.gildedrose.kotlin

class DefaultItem(
    name: String,
    sellIn: Int,
    quality: Int,
) : UpdatableItem(
    name,
    sellIn,
    quality
) {
    override fun updateQuality() {
        if (quality > 0) quality--
        sellIn--
        if (sellIn < 0 && quality > 0) quality--
    }
}