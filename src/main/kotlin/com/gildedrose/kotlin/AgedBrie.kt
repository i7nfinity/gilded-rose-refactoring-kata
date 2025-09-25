package com.gildedrose.kotlin

class AgedBrie(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun updateQuality() {
        increaseQuality()
        if (sellIn < 0) {
            increaseQuality()
        }
    }
}