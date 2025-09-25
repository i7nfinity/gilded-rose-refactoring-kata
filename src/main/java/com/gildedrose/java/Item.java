package com.gildedrose.java;

public abstract class Item {
    protected String name;
    protected int sellIn;
    protected int quality;

    public static final int MIN_QUALITY = 0;
    public static final int MAX_QUALITY = 50;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void updateSellInAndQuality() {
        decreaseSellIn();
        updateQuality();
    }

    protected void decreaseSellIn() {
        sellIn -= 1;
    }

    protected abstract void updateQuality();

    protected void decreaseQuality() {
        if (quality > MIN_QUALITY) {
            quality -= 1;
        }
    }

    protected void increaseQuality() {
        if (quality < MAX_QUALITY) {
            quality += 1;
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}