package com.gildedrose.kotlin

class GildedRose(private val items: List<Item>) {

    fun updateQuality() {
        for (item in items) {
            item.updateSellInAndQuality()
        }
    }
}