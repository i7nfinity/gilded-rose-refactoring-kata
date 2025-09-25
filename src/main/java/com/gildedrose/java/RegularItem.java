package com.gildedrose.java;

public class RegularItem extends Item {
    public RegularItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        decreaseQuality();
        if (sellIn < 0) {
            decreaseQuality();
        }
    }
}