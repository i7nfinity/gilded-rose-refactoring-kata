import com.gildedrose.kotlin.UpdatableItem

class SulfurasItem(
    name: String,
    sellIn: Int,
    quality: Int,
) : UpdatableItem(
    name,
    sellIn,
    quality
) {
    override fun updateQuality() {
        // do nothing
    }
}