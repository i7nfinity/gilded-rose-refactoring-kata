package com.gildedrose.java;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GildedRoseShould {

    @ParameterizedTest
    @CsvSource({
            "1, 9, 19",
            "2, 8, 18",
            "3, 7, 17"
    })
    public void defineThatRegularItemsDecreaseQualityAndSellInBy1EveryDay(int daysCount, int sellIn, int quality) {
        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20)
        };
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < daysCount; i++) {
            app.updateQuality();
        }

        Assertions.assertThat(items[0].toString()).isEqualTo(new Item("+5 Dexterity Vest", sellIn, quality).toString());
    }

    @ParameterizedTest
    @CsvSource({
            "1, -1, 3",
            "2, -2, 1",
            "3, -3, 0",
            "4, -4, 0"
    })
    public void defineThatRegularItemsDecreaseQualityAndSellInBy2EveryDayWhenSellInIs0(int daysCount, int sellIn, int quality) {
        Item[] items = new Item[]{
                new Item("Elixir of the Mongoose", 0, 5)
        };
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < daysCount; i++) {
            app.updateQuality();
        }

        Assertions.assertThat(items[0].toString()).isEqualTo(new Item("Elixir of the Mongoose", sellIn, quality).toString());
    }

    @ParameterizedTest
    @CsvSource({
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
    })
    public void defineThatBackstageIncreaseQualityBy1ThanAfter10By2ThanAfter5By3(int daysCount, int sellIn, int quality) {
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 12, 34),
        };

        GildedRose app = new GildedRose(items);

        for (int i = 0; i < daysCount; i++) {
            app.updateQuality();
        }

        Assertions.assertThat(items[0].toString()).isEqualTo(new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality).toString());
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 46",
            "2, 1, 47",
            "3, 0, 48",
            "4, -1, 50",
            "5, -2, 50",
    })
    public void defineThatAgedBrieImprovesQualityOverTimeButNotAbove50(int daysCount, int sellIn, int quality) {
        Item[] items = new Item[]{
                new Item("Aged Brie", 3, 45)
        };
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < daysCount; i++) {
            app.updateQuality();
        }

        Assertions.assertThat(items[0].toString()).isEqualTo(new Item("Aged Brie", sellIn, quality).toString());
    }

    @ParameterizedTest
    @CsvSource({
            "1, -1, 80",
            "2, -1, 80",
            "3, -1, 80",
            "4, -1, 80",
    })
    public void defineThatSulfurasDoesNotLoseQualityAndSellInOverTime(int daysCount, int sellIn, int quality) {
        Item[] items = new Item[]{
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
        };
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < daysCount; i++) {
            app.updateQuality();
        }

        Assertions.assertThat(items[0].toString()).isEqualTo(new Item("Sulfuras, Hand of Ragnaros", sellIn, quality).toString());
    }
}