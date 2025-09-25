package com.gildedrose.kotlin

class RegularItem(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun updateQuality() {
        decreaseQuality()
        if (sellIn < 0) {
            decreaseQuality()
        }
    }
}