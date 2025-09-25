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
    fun dexterity_Vest() {
        val items = listOf(Item("Dexterity Vest", 10, 20))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Dexterity Vest", app.items[0].name)
        assertEquals(9, app.items[0].sellIn)
        assertEquals(19, app.items[0].quality)
    }

    @Test
    fun TAFKAL80ETC_15_20() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 10, 20))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name)
        assertEquals(9, app.items[0].sellIn)
        assertEquals(22, app.items[0].quality)
    }

    @Test
    fun TAFKAL80ETC_5_20() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 5, 20))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name)
        assertEquals(4, app.items[0].sellIn)
        assertEquals(23, app.items[0].quality)
    }

    @Test
    fun test_5_20() {
        val items = listOf(Item("test", -1, 20))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("test", app.items[0].name)
        assertEquals(-2, app.items[0].sellIn)
        assertEquals(18, app.items[0].quality)
    }

    @Test
    fun test2_5_20() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", -1, 20))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name)
        assertEquals(-2, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun test3_5_20() {
        val items = listOf(Item("Aged Brie", -1, 20))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Aged Brie", app.items[0].name)
        assertEquals(-2, app.items[0].sellIn)
        assertEquals(22, app.items[0].quality)
    }

}


