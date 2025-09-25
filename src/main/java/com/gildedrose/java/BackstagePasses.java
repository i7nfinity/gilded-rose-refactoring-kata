package com.gildedrose.java;

public class BackstagePasses extends Item {
    private static final int BACKSTAGE_PASS_QUALITY_INCREASE_10_DAYS_THRESHOLD = 10;
    private static final int BACKSTAGE_PASS_QUALITY_INCREASE_5_DAYS_THRESHOLD = 5;

    public BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        increaseQuality();
        if (sellIn < BACKSTAGE_PASS_QUALITY_INCREASE_10_DAYS_THRESHOLD) {
            increaseQuality();
        }
        if (sellIn < BACKSTAGE_PASS_QUALITY_INCREASE_5_DAYS_THRESHOLD) {
            increaseQuality();
        }
        if (sellIn < 0) {
            quality = MIN_QUALITY;
        }
    }
}