package com.gildedrose.kotlin

open class Item(
    var name: String,
    var sellIn: Int,
    var quality: Int,
) {
    val type = when {
        name == "Aged Brie" -> ItemType.BRIE
        name == "Backstage passes to a TAFKAL80ETC concert" -> ItemType.BACKSTAGE
        name == "Sulfuras, Hand of Ragnaros" -> ItemType.SULFURAS
        else -> ItemType.COMMON
    }

    override fun toString(): String = "$name, $sellIn, $quality"
}

enum class ItemType {
    BRIE,
    BACKSTAGE,
    SULFURAS,
    COMMON,
}