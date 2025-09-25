package com.gildedrose.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class GildedRoseShould {
    @ParameterizedTest
    @CsvSource(
        "1, 9, 19",
        "2, 8, 18",
        "3, 7, 17"
    )
    fun `define that regular items decrease quality and sellIn by 1 every day`
                (daysCount: Int, sellIn: Int, quality: Int) {
        val items = listOf(
            RegularItem("+5 Dexterity Vest", 10, 20)
        )
        val app = GildedRose(items)

        repeat(daysCount) {
            app.updateQuality()
        }

        assertThat(items.first().toString()).isEqualTo(RegularItem("+5 Dexterity Vest", sellIn, quality).toString())
    }

    @ParameterizedTest
    @CsvSource(
        "1, -1, 3",
        "2, -2, 1",
        "3, -3, 0",
        "4, -4, 0"
    )
    fun `define that regular items decrease quality and sellIn by 2 every day when sellIn is 0`
                (daysCount: Int, sellIn: Int, quality: Int) {
        val items = listOf(
            RegularItem("Elixir of the Mongoose", 0, 5)
        )
        val app = GildedRose(items)

        repeat(daysCount) {
            app.updateQuality()
        }

        assertThat(items.first().toString()).isEqualTo(RegularItem("Elixir of the Mongoose", sellIn, quality).toString())
    }

    @ParameterizedTest
    @CsvSource(
        "1, 11, 35",
        "2, 10, 36",
        "3, 9, 38",
        "4, 8, 40",
        "5, 7, 42",
        "6, 6, 44",
        "7, 5, 46",
        "8, 4, 49",
        "9, 3, 50",
        "10, 2, 50",
        "11, 1, 50",
        "12, 0, 50",
        "13, -1, 0",
    )
    fun `define that Backstage increase quality by 1, than after 10 by 2, than after 5 by 3`(daysCount: Int, sellIn: Int, quality: Int) {
        val items = listOf(
            BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 12, 34),
        )

        val app = GildedRose(items)

        repeat(daysCount) {
            app.updateQuality()
        }

        assertThat(items.first().toString()).isEqualTo(BackstagePasses("Backstage passes to a TAFKAL80ETC concert", sellIn, quality).toString())
    }

    @ParameterizedTest
    @CsvSource(
        "1, 2, 46",
        "2, 1, 47",
        "3, 0, 48",
        "4, -1, 50",
        "5, -2, 50",
    )
    fun `define that Aged Brie improves quality over time, but not above 50`
                (daysCount: Int, sellIn: Int, quality: Int) {
        val items = listOf(
            AgedBrie("Aged Brie", 3, 45)
        )
        val app = GildedRose(items)

        repeat(daysCount) {
            app.updateQuality()
        }

        assertThat(items.first().toString()).isEqualTo(AgedBrie("Aged Brie", sellIn, quality).toString())
    }

    @ParameterizedTest
    @CsvSource(
        "1, -1, 80",
        "2, -1, 80",
        "3, -1, 80",
        "4, -1, 80",
    )
    fun `define that Sulfuras does not lose quality and sellIn over time`
                (daysCount: Int, sellIn: Int, quality: Int) {
        val items = listOf(
            Sulfuras("Sulfuras, Hand of Ragnaros", -1, 80),
        )
        val app = GildedRose(items)

        repeat(daysCount) {
            app.updateQuality()
        }

        assertThat(items.first().toString()).isEqualTo(Sulfuras("Sulfuras, Hand of Ragnaros", sellIn, quality).toString())
    }
}