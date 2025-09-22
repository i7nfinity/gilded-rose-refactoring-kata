package com.gildedrose.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        com.gildedrose.java.Item[] items = new com.gildedrose.java.Item[] { new Item("foo", 0, 0) };
        com.gildedrose.java.GildedRose app = new com.gildedrose.java.GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

}
