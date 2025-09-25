package com.gildedrose.kotlin

class GildedRose(val items: List<UpdatableItem>) {

    fun updateQuality() {
        items.forEach { it.updateQuality() }
    }
}

