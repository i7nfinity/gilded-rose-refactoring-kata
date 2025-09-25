package com.gildedrose.kotlin

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun foo() {
        val items = listOf(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("foo", app.items[0].name)
    }

    @Test
    fun testItems() {
        val items = listOf(
            Item("+5 Dexterity Vest", 10, 20), //
            Item("Aged Brie", 2, 0), //
            Item("Elixir of the Mongoose", 5, 7), //
            Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            Item("Sulfuras, Hand of Ragnaros", -1, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            Item("Conjured Mana Cake", 3, 6),
            Item("Backstage passes to a TAFKAL80ETC concert", 7, 48),
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 47),
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 80),
            Item("+5 Dexterity Vest", -10, 20), //
            Item("Aged Brie", -10, 0), //
            Item("Aged Brie", -10, 60), //
            Item("Backstage passes to a TAFKAL80ETC concert", -7, 48),

        )
        val expectedItems = listOf(
            Item("+5 Dexterity Vest", 9, 19), //
            Item("Aged Brie", 1, 1), //
            Item("Elixir of the Mongoose", 4, 6), //
            Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            Item("Sulfuras, Hand of Ragnaros", -1, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 14, 21),
            Item("Backstage passes to a TAFKAL80ETC concert", 9, 50),
            Item("Backstage passes to a TAFKAL80ETC concert", 4, 50),
            // this conjured item does not work properly yet
            Item("Conjured Mana Cake", 2, 5),
            Item("Backstage passes to a TAFKAL80ETC concert", 6, 50),
            Item("Backstage passes to a TAFKAL80ETC concert", 4, 50),
            Item("Backstage passes to a TAFKAL80ETC concert", 4, 80),
            Item("+5 Dexterity Vest", -11, 18), //
            Item("Aged Brie", -11, 2), //
            Item("Aged Brie", -11, 60), //
            Item("Backstage passes to a TAFKAL80ETC concert", -8, 0),
        )
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(expectedItems.toString(), app.items.toString())
    }

}


