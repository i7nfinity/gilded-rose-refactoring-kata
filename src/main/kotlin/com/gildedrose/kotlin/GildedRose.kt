package com.gildedrose.kotlin

class GildedRose(val items: List<Item>) {

    // TODO декомпозировать
    fun updateQuality() {
        // TODO рефактор
        for (i in items.indices) {
            // TODO много if
            if (items[i].name != "Aged Brie" && items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                if (items[i].quality > 0) {
                    // TODO магическая строчка
                    if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                        // TODO изменять в Item
                        items[i].quality = items[i].quality - 1
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1

                    if (items[i].name == "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].sellIn < 11) {
                            // TODO дублирование
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1
                            }
                        }
                    }
                }
            }

            if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                // TODO изменять в Item
                items[i].sellIn = items[i].sellIn - 1
            }

            if (items[i].sellIn < 0) {
                if (items[i].name != "Aged Brie") {
                    if (items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].quality > 0) {
                            if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                                items[i].quality = items[i].quality - 1
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1
                    }
                }
            }
        }
    }

    fun updateQuality2() {
        // TODO рефактор
        for (i in items.indices) {

            // items with decreasing quality
            if (items[i].name != "Aged Brie"
                && items[i].name != "Backstage passes to a TAFKAL80ETC concert"
                && items[i].name != "Sulfuras, Hand of Ragnaros"
            ) {
                if (items[i].quality > 0) {
                    items[i].updateQuality(-1)
                }
            }

            // items with increasing quality
            if (items[i].name == "Aged Brie"
                || items[i].name == "Backstage passes to a TAFKAL80ETC concert"
            ) {
                updateQualityIfLow(items[i])
                if (items[i].name == "Backstage passes to a TAFKAL80ETC concert") {
                    if (items[i].sellIn < 11) {
                        updateQualityIfLow(items[i])
                    }
                    if (items[i].sellIn < 6) {
                        updateQualityIfLow(items[i])
                    }
                }
            }

            // decrease sellIn if not Sulfuras
            if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                items[i].updateSellIn(-1)
            }

            //increaseQualityForBrieIfExpired(items[i])

            if (items[i].sellIn < 0) {
                if (items[i].name != "Aged Brie") {
                    if (items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].quality > 0) {
                            if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                                items[i].quality = items[i].quality - 1
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1
                    }
                }
            }
        }
    }

    private fun updateQualityIfLow(item: Item) {
        if (item.quality < 50) {
            item.updateQuality(1)
        }
    }

    private fun increaseQualityForBrieIfExpired(item: Item) {
        if (item.name == "Aged Brie") {
            if (item.sellIn < 0) {
                item.updateQuality(1)
            }
        }
    }
}

