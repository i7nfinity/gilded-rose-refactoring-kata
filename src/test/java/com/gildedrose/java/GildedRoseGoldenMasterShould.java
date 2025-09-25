package com.gildedrose.java;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GildedRoseGoldenMasterShould {

    @Test
    public void defineQualityOfAllItemsWithin5Days() throws IOException {
        var items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Aged Brie", 0, 49),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 49)};

        GildedRose app = new GildedRose(items);

        int days = 6;
        StringBuilder actual = new StringBuilder();
        for (int i = 0; i < days; i++) {
            actual.append("-------- day ").append(i).append(" --------\n");
            actual.append("name, sellIn, quality\n");
            for (Item item : items) {
                actual.append(item).append("\n");
            }
            actual.append("\n");
            app.updateQuality();
        }

        String expected = new String(Files.readAllBytes(Paths.get("src/test/resources/golden-master-test-expected.txt")));
        assertThat(actual.toString()).isEqualTo(expected);
    }
}