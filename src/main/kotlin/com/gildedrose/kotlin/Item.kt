package com.gildedrose.kotlin

class Item(
    val name: String,
    var sellIn: Int,
    quality: Int, // Инициализирующее значение для backing field
) {
    // Свойство quality с проверкой границ
    var quality: Int = quality
        set(value) {
            field = when {
                value < MIN_QUALITY -> MIN_QUALITY
                value > MAX_QUALITY -> MAX_QUALITY
                else -> value
            }
        }

    // Методы для обновления качества
    fun increaseQuality(amount: Int = 1) {
        quality += amount
    }

    fun decreaseQuality(amount: Int = 1) {
        quality -= amount
    }

    fun resetQuality() {
        quality = 0
    }

    fun decreaseSellIn() {
        sellIn--
    }

    // Проверки типов предметов
    fun isAgedBrie(): Boolean = name == AGED_BRIE
    fun isBackstagePasses(): Boolean = name == BACKSTAGE_PASSES
    fun isSulfuras(): Boolean = name == SULFURAS

    // Проверки состояния
    fun isExpired(): Boolean = sellIn < MIN_QUALITY
    fun hasMaxQuality(): Boolean = quality >= MAX_QUALITY
    fun hasMinQuality(): Boolean = quality <= MIN_QUALITY

    // Переопределение equals() и hashCode() для корректного сравнения
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Item) return false

        if (name != other.name) return false
        if (sellIn != other.sellIn) return false
        if (quality != other.quality) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + sellIn
        result = 31 * result + quality
        return result
    }

    override fun toString(): String = "$name, $sellIn, $quality"
}

// Константы для качества
const val MAX_QUALITY = 50
const val MIN_QUALITY = 0

// Названия предметов
const val AGED_BRIE = "Aged Brie"
const val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
const val SULFURAS = "Sulfuras, Hand of Ragnaros"