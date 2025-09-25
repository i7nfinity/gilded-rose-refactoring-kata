package com.gildedrose.kotlin

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class GildedRoseTest {
//    @Test
//    fun foo() {
//        val items = listOf(Item("foo", 0, 0))
//        val app = GildedRose(items)
//        app.updateQuality()
//        assertEquals("fixme", app.items[0].name)
//    }

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

    @Test
    fun testItemToString() {
        val item1 = Item("foo", 0, 0)
        assertEquals("foo, 0, 0", item1.toString())

        val item2 = Item("Aged Brie", 2, 50)
        assertEquals("Aged Brie, 2, 50", item2.toString())

        val item3 = Item("Backstage passes to a TAFKAL80ETC concert", -5, 25)
        assertEquals("Backstage passes to a TAFKAL80ETC concert, -5, 25", item3.toString())

        val item4 = Item("Sulfuras, Hand of Ragnaros", 10, 80)
        assertEquals("Sulfuras, Hand of Ragnaros, 10, 80", item4.toString())

        // Test with negative values
        val item5 = Item("Test Item", -10, -5)
        assertEquals("Test Item, -10, -5", item5.toString())
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
                // Regular items - basic cases
                Arguments.of(
                    names[0], // "foo"
                    0,
                    0,
                    names[0],
                    -1,
                    0
                ),
                Arguments.of(
                    names[6], // "+5 Dexterity Vest" - normal quality decrease
                    10,
                    20,
                    names[6],
                    9,
                    19
                ),
                Arguments.of(
                    names[5], // "Conjured Mana Cake" - behaves like regular item
                    3,
                    6,
                    names[5],
                    2,
                    5
                ),
                
                // Regular items - after sell date (double degradation)
                Arguments.of(
                    names[0], // "foo" - after sell date, quality > 1
                    -1,
                    5,
                    names[0],
                    -2,
                    3
                ),
                Arguments.of(
                    names[6], // "+5 Dexterity Vest" - after sell date, quality = 1
                    -1,
                    1,
                    names[6],
                    -2,
                    0
                ),
                Arguments.of(
                    names[0], // "foo" - quality cannot go below 0
                    5,
                    0,
                    names[0],
                    4,
                    0
                ),
                
                // Aged Brie - basic cases
                Arguments.of(
                    names[1], // "Aged Brie" - normal quality increase
                    2,
                    0,
                    names[1],
                    1,
                    1
                ),
                Arguments.of(
                    names[1], // "Aged Brie" - after sell date, double increase
                    -1,
                    10,
                    names[1],
                    -2,
                    12
                ),
                Arguments.of(
                    names[1], // "Aged Brie" - quality cannot exceed 50
                    5,
                    50,
                    names[1],
                    4,
                    50
                ),
                Arguments.of(
                    names[1], // "Aged Brie" - after sell date, quality limit 50
                    -1,
                    49,
                    names[1],
                    -2,
                    50
                ),
                
                // Backstage passes - all time ranges
                Arguments.of(
                    names[2], // ">10 days" - quality increases by 1
                    15,
                    20,
                    names[2],
                    14,
                    21
                ),
                Arguments.of(
                    names[2], // "11 days" - boundary case, quality increases by 1
                    11,
                    20,
                    names[2],
                    10,
                    21
                ),
                Arguments.of(
                    names[2], // "10 days" - quality increases by 2
                    10,
                    20,
                    names[2],
                    9,
                    22
                ),
                Arguments.of(
                    names[4], // "10 days" - quality near limit
                    10,
                    49,
                    names[4],
                    9,
                    50
                ),
                Arguments.of(
                    names[2], // "6 days" - boundary case, quality increases by 2
                    6,
                    20,
                    names[2],
                    5,
                    22
                ),
                Arguments.of(
                    names[2], // "5 days" - quality increases by 3
                    5,
                    20,
                    names[2],
                    4,
                    23
                ),
                Arguments.of(
                    names[4], // "5 days" - quality near limit
                    5,
                    48,
                    names[4],
                    4,
                    50
                ),
                Arguments.of(
                    names[2], // "1 day" - quality increases by 3
                    1,
                    20,
                    names[2],
                    0,
                    23
                ),
                Arguments.of(
                    names[2], // "After concert" - quality becomes 0
                    0,
                    30,
                    names[2],
                    -1,
                    0
                ),
                Arguments.of(
                    names[4], // "After concert" - quality becomes 0
                    -1,
                    50,
                    names[4],
                    -2,
                    0
                ),
                
                // Sulfuras - legendary item, never changes
                Arguments.of(
                    names[3], // "Sulfuras" - basic case
                    0,
                    80,
                    names[3],
                    0,
                    80
                ),
                Arguments.of(
                    names[3], // "Sulfuras" - different sellIn value
                    10,
                    80,
                    names[3],
                    10,
                    80
                ),
                Arguments.of(
                    names[3], // "Sulfuras" - negative sellIn
                    -5,
                    80,
                    names[3],
                    -5,
                    80
                ),
                Arguments.of(
                    names[3], // "Sulfuras" - different quality (shouldn't happen but test behavior)
                    5,
                    100,
                    names[3],
                    5,
                    100
                )
            )

        }
    }
}


