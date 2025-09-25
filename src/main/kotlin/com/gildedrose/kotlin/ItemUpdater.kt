package com.gildedrose.kotlin

/**
 * Базовый интерфейс для стратегий обновления предметов
 */
interface ItemUpdater {
    fun updateItem(item: Item)
}

/**
 * Обновляет обычные предметы
 * - Качество уменьшается на 1 каждый день
 * - После истечения срока продажи качество уменьшается в 2 раза быстрее
 * - Качество не может быть отрицательным
 */
class StandardItemUpdater : ItemUpdater {
    override fun updateItem(item: Item) {
        decreaseSellIn(item)
        decreaseQuality(item, if (item.sellIn < 0) 2 else 1)
    }
}

/**
 * Обновляет Aged Brie
 * - Качество увеличивается на 1 каждый день
 * - После истечения срока продажи качество увеличивается в 2 раза быстрее
 * - Качество не может превышать 50
 */
class AgedBrieUpdater : ItemUpdater {
    override fun updateItem(item: Item) {
        decreaseSellIn(item)
        increaseQuality(item, if (item.sellIn < 0) 2 else 1)
    }
}

/**
 * Обновляет Backstage passes
 * - Качество увеличивается по сложным правилам в зависимости от количества дней до концерта:
 *   * Более 10 дней: +1 качество
 *   * 6-10 дней: +2 качество  
 *   * 1-5 дней: +3 качество
 *   * После концерта (sellIn < 0): качество = 0
 * - Качество не может превышать 50
 */
class BackstagePassUpdater : ItemUpdater {
    override fun updateItem(item: Item) {
        decreaseSellIn(item)
        
        when {
            item.sellIn < 0 -> item.quality = 0
            item.sellIn < 5 -> increaseQuality(item, 3)
            item.sellIn < 10 -> increaseQuality(item, 2)
            else -> increaseQuality(item, 1)
        }
    }
}

/**
 * Обновляет Sulfuras - легендарные предметы
 * - Никогда не изменяются: качество и sellIn остаются постоянными
 */
class SulfurasUpdater : ItemUpdater {
    override fun updateItem(item: Item) {
        // Sulfuras никогда не изменяется
    }
}

// Вспомогательные функции для работы с качеством и сроком продажи
private fun decreaseSellIn(item: Item) {
    item.sellIn--
}

private fun decreaseQuality(item: Item, amount: Int) {
    item.quality = maxOf(0, item.quality - amount)
}

private fun increaseQuality(item: Item, amount: Int) {
    item.quality = minOf(50, item.quality + amount)
}
