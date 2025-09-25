package com.gildedrose.kotlin

class GildedRose(val items: List<Item>) {

    // TODO: большая вложенность
    // TODO: Item - ленивый класс

    val AGED_BRIE = "Aged Brie"
    val BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert"
    val SULFURAS = "Sulfuras, Hand of Ragnaros"
    val MAX_QUALITY = 50
    val BACKSTAGE_BRIE_DAYS_THRESHOLD_LATER = 11
    val BACKSTAGE_BRIE_DAYS_THRESHOLD_LATEST = 6

    fun updateQuality() {
        for (i in items.indices) {
            val item = items[i]
            // TODO: дублирующийся код
            if (item.name != AGED_BRIE && item.name != BACKSTAGE) {
                changeQualityForSulfuras(item)
            } else {
                if (item.quality < MAX_QUALITY) {
                    changeQuality(item, 1)

                    if (item.name == BACKSTAGE) {
                        changeBackstageBrieQuality(item, BACKSTAGE_BRIE_DAYS_THRESHOLD_LATER)
                        changeBackstageBrieQuality(item, BACKSTAGE_BRIE_DAYS_THRESHOLD_LATEST)
                    }
                }
            }
 
            if (item.name != SULFURAS) {
                item.sellIn = item.sellIn - 1
            }

            if (item.sellIn < 0) {
                if (item.name != AGED_BRIE) {
                    if (item.name != BACKSTAGE) {
                        changeQualityForSulfuras(item)
                    } else {
                        item.quality = 0
                    }
                } else {
                    if (item.quality < MAX_QUALITY) {
                        changeQuality(item, 1)
                    }
                }
            }
        }
    }
    
    private fun changeQuality(item: Item, diff: Int) {
        item.quality += diff
    }

    private fun changeBackstageBrieQuality(item: Item, threshold: Int) {
        if (item.sellIn < threshold) {
            if (item.quality < MAX_QUALITY) {
                changeQuality(item, 1)
            }
        }
    }

    private fun changeQualityForSulfuras(item: Item) {
        if (item.quality > 0) {
            if (item.name != SULFURAS) {
                changeQuality(item, -1)
            }
        }
    }

}

