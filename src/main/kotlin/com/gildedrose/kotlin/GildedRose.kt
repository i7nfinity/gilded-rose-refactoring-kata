package com.gildedrose.kotlin

// TODO: Разбить класс - слишком много ответственности (SRP violation)
class GildedRose(val items: List<Item>) {

    companion object {
        // Константы для backstage passes
        const val DAYS_TO_DOUBLE_INCREASE = 11
        const val DAYS_TO_TRIPLE_INCREASE = 6
    }

    fun updateQuality() {
        for (item in items) {
            // Обновляем качество до истечения срока
            when {
                item.isAgedBrie() -> updateAgedBrie(item)
                item.isBackstagePasses() -> updateBackstagePasses(item)
                else -> updateRegularItem(item)
            }

            // Уменьшаем sellIn (кроме Sulfuras)
            if (!item.isSulfuras()) {
                item.decreaseSellIn()
            }

            // Обновляем качество после истечения срока
            if (item.isExpired()) {
                updateExpiredItem(item)
            }
        }
    }

    // Вспомогательные методы для разных типов предметов
    private fun updateRegularItem(item: Item) {
        if (!item.hasMinQuality() && !item.isSulfuras()) {
            item.decreaseQuality()
        }
    }

    private fun updateAgedBrie(item: Item) {
        if (!item.hasMaxQuality()) {
            item.increaseQuality()
        }
    }

    private fun updateBackstagePasses(item: Item) {
        if (item.hasMaxQuality()) return

        val qualityIncrease = when {
            item.sellIn < DAYS_TO_TRIPLE_INCREASE -> 3
            item.sellIn < DAYS_TO_DOUBLE_INCREASE -> 2
            else -> 1
        }

        item.increaseQuality(qualityIncrease)
    }

    private fun updateExpiredItem(item: Item) {
        when {
            item.isAgedBrie() -> {
                if (!item.hasMaxQuality()) {
                    item.increaseQuality()
                }
            }
            item.isBackstagePasses() -> {
                item.resetQuality()
            }
            !item.isSulfuras() && !item.hasMinQuality() -> {
                item.decreaseQuality()
            }
        }
    }

}
