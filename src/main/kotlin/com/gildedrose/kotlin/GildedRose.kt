package com.gildedrose.kotlin

/**
 * Основной класс системы Gilded Rose.
 * Управляет обновлением качества предметов в магазине.
 */
class GildedRose(val items: List<Item>) {

    /**
     * Обновляет качество всех предметов в соответствии с бизнес-правилами.
     * 
     * Использует паттерн Strategy для применения специфичных правил
     * обновления для каждого типа предмета.
     */
    fun updateQuality() {
        items.forEach { item ->
            val updater = ItemUpdaterFactory.getUpdater(item)
            updater.updateItem(item)
        }
    }
}

