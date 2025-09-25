package com.gildedrose.java;

public class AgedBrie extends Item {
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        increaseQuality();
        if (sellIn < 0) {
            increaseQuality();
        }
    }
}