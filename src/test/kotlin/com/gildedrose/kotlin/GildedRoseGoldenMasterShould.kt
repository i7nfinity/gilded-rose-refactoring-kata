package com.gildedrose.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GildedRoseGoldenMasterShould {

    @Test
    fun `define quality of all items within 5 days`() {
        val items = listOf(
            Item("+5 Dexterity Vest", 10, 20),

            Item("Aged Brie", 2, 0),
            Item("Aged Brie", 0, 49),

            Item("Elixir of the Mongoose", 5, 7),

            Item("Sulfuras, Hand of Ragnaros", 0, 80),
            Item("Sulfuras, Hand of Ragnaros", -1, 80),

            Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            Item("Backstage passes to a TAFKAL80ETC concert", 0, 49),
        )

        val app = GildedRose(items)

        val days = 6
        val actual = StringBuilder()
        for (i in 0..<days) {
            actual.append("-------- day $i --------\n")
            actual.append("name, sellIn, quality\n")
            for (item in items) {
                actual.append(item)
                actual.appendLine()
            }
            actual.appendLine()
            app.updateQuality()
        }

        val expected = this::class.java.getResource("/golden-master-test-expected.txt")?.readText()
        assertThat(actual.toString()).isEqualTo(expected)
    }
}