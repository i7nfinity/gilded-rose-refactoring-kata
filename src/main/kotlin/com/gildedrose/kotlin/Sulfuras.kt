package com.gildedrose.kotlin

class Sulfuras(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun updateQuality() {
        // Sulfuras does not change in quality
    }

    override fun decreaseSellIn() {
        // Sulfuras does not change sellIn
    }
}