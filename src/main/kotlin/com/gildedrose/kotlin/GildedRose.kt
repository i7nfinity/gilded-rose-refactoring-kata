package com.gildedrose.kotlin

/*
длинные методы
класс данных \ ленивый класс
зависть функций
цепочка вызовов
дублирование кода
магические числа
сложность условий
расходящиеся изменения
 */
class GildedRose(private val items: List<Item>) {

    fun updateQuality() { // todo: длинные методы
        for (item in items) {
            if (item.name != "Aged Brie" && item.name != "Backstage passes to a TAFKAL80ETC concert") { // todo: magic numbers
                if (item.quality > 0) {
                    if (item.name != "Sulfuras, Hand of Ragnaros") { // todo: сложность условий
                        item.decrementQuality()
                    }
                }
            } else {
                if (!item.hasMaximalQuality()) {
                    item.incrementQuality()

                    if (item.name == "Backstage passes to a TAFKAL80ETC concert") { // todo: magic numbers, сложность условий
                        if (item.sellIn < 11) { // todo: magic numbers, сложность условий
                            item.incrementQualityIfPossible()
                        }

                        if (item.sellIn < 6) { // todo: magic numbers, сложность условий
                            item.incrementQualityIfPossible()
                        }
                    }
                }
            }

            if (item.name != "Sulfuras, Hand of Ragnaros") { // todo: magic numbers
                item.sellIn = item.sellIn - 1
            }

            if (item.sellIn < 0) { // todo: magic numbers
                if (item.name != "Aged Brie") { // todo: magic numbers
                    if (item.name != "Backstage passes to a TAFKAL80ETC concert") { // todo: magic numbers, сложность условий
                        if (item.quality > 0) { // todo: magic numbers, сложность условий
                            if (item.name != "Sulfuras, Hand of Ragnaros") { // todo: magic numbers, сложность условий
                                item.decrementQuality()
                            }
                        }
                    } else { // todo: сложность условий
                        item.quality = item.quality - item.quality
                    }
                } else { // todo: сложность условий
                    item.incrementQualityIfPossible()
                }
            }
        }
    }
}

