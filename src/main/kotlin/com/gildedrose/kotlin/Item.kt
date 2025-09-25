package com.gildedrose.kotlin

import SulfurasItem

abstract class UpdatableItem(
    protected var name: String,
    protected var sellIn: Int,
    protected var quality: Int,
) {
    override fun toString(): String = "$name, $sellIn, $quality"

    abstract fun updateQuality()

    companion object {
        const val AGED_BRIE = "Aged Brie"
        const val BACKSTAGE_PASSES_TO_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert"
        const val SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros"

        fun of(name: String, sellIn: Int, quality: Int): UpdatableItem {
            return when (name) {
                AGED_BRIE -> AgedBrieItem(name, sellIn, quality)
                BACKSTAGE_PASSES_TO_TAFKAL80ETC_CONCERT -> BackstagePassesItem(name, sellIn, quality)
                SULFURAS_HAND_OF_RAGNAROS -> SulfurasItem(name, sellIn, quality)
                else -> DefaultItem(name, sellIn, quality)
            }
        }
    }
}

fun Item(name: String, sellIn: Int, quality: Int): UpdatableItem = UpdatableItem.of(name, sellIn, quality)
