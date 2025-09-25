package com.gildedrose.kotlin

class BackstagePassesItem(
    name: String,
    sellIn: Int,
    quality: Int,
) : UpdatableItem(
    name,
    sellIn,
    quality
) {
    override fun updateQuality() {
        when {
            quality < 50 -> quality++
        }
        if (sellIn < 11 && quality < 50) quality++
        if (sellIn < 6 && quality < 50) quality++
        sellIn--
        if (sellIn < 0) quality = 0
    }
}