package com.gildedrose.kotlin

class BackstagePasses(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun updateQuality() {
        increaseQuality()
        if (sellIn < BACKSTAGE_PASS_QUALITY_INCREASE_10_DAYS_THRESHOLD) {
            increaseQuality()
        }
        if (sellIn < BACKSTAGE_PASS_QUALITY_INCREASE_5_DAYS_THRESHOLD) {
            increaseQuality()
        }
        if (sellIn < 0) {
            quality = MIN_QUALITY
        }
    }

    companion object {
        const val BACKSTAGE_PASS_QUALITY_INCREASE_10_DAYS_THRESHOLD = 10
        const val BACKSTAGE_PASS_QUALITY_INCREASE_5_DAYS_THRESHOLD = 5
    }
}