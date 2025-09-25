package com.gildedrose.kotlin

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class GildedRoseTest {
    @Test
    fun foo() {
        val items = listOf(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("fixme", app.items[0].name)
    }

    @ParameterizedTest(name = "itemTest {0}")
    @MethodSource("items")
    fun itemTest(
        name: String,
        sellIn: Int,
        quality: Int,
        nameResult: String,
        sellInResult: Int,
        qualityResult: Int
    ) {
        val items = listOf(Item(name, sellIn, quality))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(nameResult, app.items[0].name)
        assertEquals(sellInResult, app.items[0].sellIn)
        assertEquals(qualityResult, app.items[0].quality)
    }

    companion object {
        @JvmStatic
        fun items(): List<Arguments> {
            val names = listOf(
                "foo",
                "Aged Brie",
                "Backstage passes to a TAFKAL80ETC concert",
                "Sulfuras, Hand of Ragnaros",
                "Backstage passes to a TAFKAL80ETC concert",
                "Conjured Mana Cake",
                "+5 Dexterity Vest"
            )

            return listOf(
                Arguments.of(
                    names[0],
                    0,
                    0,
                    names[0],
                    -1,
                    0
                ),
                Arguments.of(
                    names[1],
                    2,
                    0,
                    names[1],
                    1,
                    1
                ),
                Arguments.of(
                    names[2],
                    15,
                    20,
                    names[2],
                    14,
                    21
                ),
                Arguments.of(
                    names[3],
                    0,
                    80,
                    names[3],
                    0,
                    80
                ),
                Arguments.of(
                    names[4],
                    10,
                    49,
                    names[4],
                    9,
                    50
                ),
                Arguments.of(
                    names[5],
                    3,
                    6,
                    names[5],
                    2,
                    5,
                ),
                Arguments.of(
                    names[6],
                    10,
                    20,
                    names[6],
                    9,
                    19
                )
            )
        }
    }
}


