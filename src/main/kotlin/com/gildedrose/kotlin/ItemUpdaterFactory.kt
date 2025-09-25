package com.gildedrose.kotlin

/**
 * Фабрика для создания подходящей стратегии обновления предмета
 */
object ItemUpdaterFactory {
    
    private const val AGED_BRIE = "Aged Brie"
    private const val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
    private const val SULFURAS = "Sulfuras, Hand of Ragnaros"
    
    /**
     * Возвращает подходящую стратегию обновления для данного предмета
     */
    fun getUpdater(item: Item): ItemUpdater {
        return when (item.name) {
            AGED_BRIE -> AgedBrieUpdater()
            BACKSTAGE_PASSES -> BackstagePassUpdater()
            SULFURAS -> SulfurasUpdater()
            else -> StandardItemUpdater()
        }
    }
}
