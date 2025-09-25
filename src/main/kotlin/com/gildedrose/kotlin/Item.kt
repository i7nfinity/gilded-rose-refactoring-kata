package com.gildedrose.kotlin

// TODO леньтяй
open class Item(
    // TODO var -> val
    var name: String,
    var sellIn: Int,
    var quality: Int,
) {
    override fun toString(): String = "$name, $sellIn, $quality"
}