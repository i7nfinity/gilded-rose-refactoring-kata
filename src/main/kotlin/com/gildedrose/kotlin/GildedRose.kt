package com.gildedrose.kotlin

class GildedRose(val items: List<Item>) {
    
    val MAX_QUALITY = 50
    val BACKSTAGE_BRIE_DAYS_THRESHOLD_LATER = 11
    val BACKSTAGE_BRIE_DAYS_THRESHOLD_LATEST = 6

    fun updateQuality() {
        for (i in items.indices) {
            val item = items[i]

            changeQuality(item)
            changeSellIn(item)
            processNegativeSellIn(item)
        }
    }
    
    private fun changeQuality(item: Item, diff: Int) {
        item.quality += diff
        if (item.quality < 0) {
            item.quality = 0
        }

        if (item.quality > MAX_QUALITY) {
            item.quality = MAX_QUALITY
        }
    }

    private fun changeBackstageBrieQuality(item: Item, threshold: Int) {
        if (item.sellIn < threshold) {
            if (item.quality < MAX_QUALITY) {
                changeQuality(item, 1)
            }
        }
    }

    private fun changeQuality(item: Item) {
        when(item.type) {
            ItemType.BRIE -> {
                changeQuality(item, 1)
            }
            ItemType.BACKSTAGE -> {
                changeQuality(item, 1)
                changeBackstageBrieQuality(item, BACKSTAGE_BRIE_DAYS_THRESHOLD_LATER)
                changeBackstageBrieQuality(item, BACKSTAGE_BRIE_DAYS_THRESHOLD_LATEST)
            }
            ItemType.SULFURAS -> Unit
            ItemType.COMMON -> changeQuality(item, -1)
        }
    }

    private fun changeSellIn(item: Item) {
        when(item.type) {
            ItemType.BRIE,
            ItemType.BACKSTAGE,
            ItemType.COMMON -> item.sellIn -= 1
            ItemType.SULFURAS -> Unit
        }
    }

    // TODO: rename
    private fun processNegativeSellIn(item: Item) {
        if (item.sellIn >= 0) {
            return
        }
        when(item.type) {
            ItemType.BRIE -> {
                if (item.quality < MAX_QUALITY) {
                    changeQuality(item, 1)
                }
            }
            ItemType.BACKSTAGE -> item.quality = 0
            ItemType.SULFURAS -> Unit
            ItemType.COMMON ->  changeQuality(item, -1)
        }

    }
}

