package com.gildedrose.java;

public class Sulfuras extends Item {
    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        // Sulfuras does not change in quality
    }

    @Override
    protected void decreaseSellIn() {
        // Sulfuras does not change sellIn
    }
}