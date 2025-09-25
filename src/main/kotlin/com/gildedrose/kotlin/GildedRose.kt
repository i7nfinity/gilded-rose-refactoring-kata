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
            // TODO много if
            if (items[i].name != "Aged Brie" && items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                if (items[i].quality > 0) {
                    // TODO магическая строчка
                    if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                        // TODO изменять в Item
                        items[i].updateQuality(-1)
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].updateQuality(1)

                    if (items[i].name == "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].sellIn < 11) {
                            // TODO дублирование
                            if (items[i].quality < 50) {
                                items[i].updateQuality(1)
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].updateQuality(1)
                            }
                        }
                    }
                }
            }

            if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                // TODO изменять в Item
                items[i].updateSellIn(-1)
            }

            if (items[i].sellIn < 0) {
                if (items[i].name != "Aged Brie") {
                    if (items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].quality > 0) {
                            if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                                items[i].updateQuality(-1)
                            }
                        }
                    } else {
                        items[i].setQuality(0)
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].updateQuality(1)
                    }
                }
            }
        }
    }

}

