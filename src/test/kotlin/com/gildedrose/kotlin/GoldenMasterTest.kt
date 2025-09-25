package com.gildedrose.kotlin

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled

/**
 * Golden Master Test для GildedRose.
 * Этот тест фиксирует текущее поведение системы как "золотой стандарт",
 * позволяя безопасно рефакторить код при сохранении функциональности.
 */
internal class GoldenMasterTest {
    
    @Test
    fun goldenMasterTest() {
        val items = createTestItems()
        val gildedRose = GildedRose(items)
        
        val result = captureSystemBehavior(gildedRose, days = 3)
        val expected = getExpectedGoldenMasterResult()
        
        assertEquals(expected, result, "Поведение системы изменилось! Если изменения преднамеренные, обновите золотой стандарт.")
    }
    
    /**
     * Создает полный набор тестовых данных для покрытия всех сценариев.
     */
    private fun createTestItems(): List<Item> {
        return listOf(
            // Обычные предметы - различные значения sellIn и quality
            Item("Обычный предмет 1", 10, 20),
            Item("Обычный предмет 2", 5, 10),
            Item("Обычный предмет 3", 1, 5),
            Item("Обычный предмет 4", 0, 10),
            Item("Обычный предмет 5", -1, 15),
            Item("Обычный предмет 6", -5, 25),
            
            // Граничные случаи для обычных предметов
            Item("Обычный предмет - качество 0", 5, 0),
            Item("Обычный предмет - качество 1", 5, 1),
            Item("Обычный предмет - максимальное качество", 5, 50),
            
            // Aged Brie - улучшается со временем
            Item("Aged Brie", 10, 20),
            Item("Aged Brie", 5, 30),
            Item("Aged Brie", 1, 40),
            Item("Aged Brie", 0, 45),
            Item("Aged Brie", -1, 25),
            Item("Aged Brie", -5, 10),
            
            // Aged Brie граничные случаи
            Item("Aged Brie", 5, 0),
            Item("Aged Brie", 5, 49),
            Item("Aged Brie", 5, 50),
            Item("Aged Brie", -1, 49),
            
            // Backstage passes - сложная логика
            Item("Backstage passes to a TAFKAL80ETC concert", 20, 30),
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 25),
            Item("Backstage passes to a TAFKAL80ETC concert", 11, 35),
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 40),
            Item("Backstage passes to a TAFKAL80ETC concert", 6, 45),
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 30),
            Item("Backstage passes to a TAFKAL80ETC concert", 1, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 0, 25),
            Item("Backstage passes to a TAFKAL80ETC concert", -1, 30),
            
            // Backstage passes граничные случаи
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 49),
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 48),
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 47),
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 50),
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 50),
            
            // Sulfuras - легендарный предмет, не изменяется
            Item("Sulfuras, Hand of Ragnaros", 10, 80),
            Item("Sulfuras, Hand of Ragnaros", 5, 80),
            Item("Sulfuras, Hand of Ragnaros", 0, 80),
            Item("Sulfuras, Hand of Ragnaros", -1, 80),
            Item("Sulfuras, Hand of Ragnaros", -10, 80),
            
            // Conjured предметы (текущая реализация)
            Item("Conjured Mana Cake", 10, 20),
            Item("Conjured Health Potion", 5, 15),
            Item("Conjured Magic Item", 1, 10),
            Item("Conjured Ring", 0, 8),
            Item("Conjured Sword", -1, 12),
            Item("Conjured Shield", -5, 5),
            
            // Conjured граничные случаи
            Item("Conjured Item - качество 0", 5, 0),
            Item("Conjured Item - качество 1", 5, 1),
            
            // Дополнительные тестовые случаи с именами похожими на особые предметы
            Item("Aged", 5, 10), // Не точное совпадение с "Aged Brie"
            Item("Backstage", 5, 10), // Не точное совпадение  
            Item("Sulfuras", 5, 10), // Не точное совпадение
        )
    }
    
    /**
     * Запускает систему на заданное количество дней и записывает все изменения.
     */
    private fun captureSystemBehavior(gildedRose: GildedRose, days: Int): String {
        val result = StringBuilder()
        
        // Записываем начальное состояние
        result.appendLine("День 0:")
        for (item in gildedRose.items) {
            result.appendLine("  $item")
        }
        result.appendLine()
        
        // Записываем изменения по дням
        for (day in 1..days) {
            gildedRose.updateQuality()
            result.appendLine("День $day:")
            for (item in gildedRose.items) {
                result.appendLine("  $item")
            }
            result.appendLine()
        }
        
        return result.toString()
    }
    
    /**
     * Возвращает ожидаемый "золотой" результат.
     * Этот метод нужно будет обновить после первого запуска теста.
     */
    private fun getExpectedGoldenMasterResult(): String {
        return """
            День 0:
              Обычный предмет 1, 10, 20
              Обычный предмет 2, 5, 10
              Обычный предмет 3, 1, 5
              Обычный предмет 4, 0, 10
              Обычный предмет 5, -1, 15
              Обычный предмет 6, -5, 25
              Обычный предмет - качество 0, 5, 0
              Обычный предмет - качество 1, 5, 1
              Обычный предмет - максимальное качество, 5, 50
              Aged Brie, 10, 20
              Aged Brie, 5, 30
              Aged Brie, 1, 40
              Aged Brie, 0, 45
              Aged Brie, -1, 25
              Aged Brie, -5, 10
              Aged Brie, 5, 0
              Aged Brie, 5, 49
              Aged Brie, 5, 50
              Aged Brie, -1, 49
              Backstage passes to a TAFKAL80ETC concert, 20, 30
              Backstage passes to a TAFKAL80ETC concert, 15, 25
              Backstage passes to a TAFKAL80ETC concert, 11, 35
              Backstage passes to a TAFKAL80ETC concert, 10, 40
              Backstage passes to a TAFKAL80ETC concert, 6, 45
              Backstage passes to a TAFKAL80ETC concert, 5, 30
              Backstage passes to a TAFKAL80ETC concert, 1, 20
              Backstage passes to a TAFKAL80ETC concert, 0, 25
              Backstage passes to a TAFKAL80ETC concert, -1, 30
              Backstage passes to a TAFKAL80ETC concert, 15, 49
              Backstage passes to a TAFKAL80ETC concert, 10, 48
              Backstage passes to a TAFKAL80ETC concert, 5, 47
              Backstage passes to a TAFKAL80ETC concert, 10, 50
              Backstage passes to a TAFKAL80ETC concert, 5, 50
              Sulfuras, Hand of Ragnaros, 10, 80
              Sulfuras, Hand of Ragnaros, 5, 80
              Sulfuras, Hand of Ragnaros, 0, 80
              Sulfuras, Hand of Ragnaros, -1, 80
              Sulfuras, Hand of Ragnaros, -10, 80
              Conjured Mana Cake, 10, 20
              Conjured Health Potion, 5, 15
              Conjured Magic Item, 1, 10
              Conjured Ring, 0, 8
              Conjured Sword, -1, 12
              Conjured Shield, -5, 5
              Conjured Item - качество 0, 5, 0
              Conjured Item - качество 1, 5, 1
              Aged, 5, 10
              Backstage, 5, 10
              Sulfuras, 5, 10

            День 1:
              Обычный предмет 1, 9, 19
              Обычный предмет 2, 4, 9
              Обычный предмет 3, 0, 4
              Обычный предмет 4, -1, 8
              Обычный предмет 5, -2, 13
              Обычный предмет 6, -6, 23
              Обычный предмет - качество 0, 4, 0
              Обычный предмет - качество 1, 4, 0
              Обычный предмет - максимальное качество, 4, 49
              Aged Brie, 9, 21
              Aged Brie, 4, 31
              Aged Brie, 0, 41
              Aged Brie, -1, 47
              Aged Brie, -2, 27
              Aged Brie, -6, 12
              Aged Brie, 4, 1
              Aged Brie, 4, 50
              Aged Brie, 4, 50
              Aged Brie, -2, 50
              Backstage passes to a TAFKAL80ETC concert, 19, 31
              Backstage passes to a TAFKAL80ETC concert, 14, 26
              Backstage passes to a TAFKAL80ETC concert, 10, 36
              Backstage passes to a TAFKAL80ETC concert, 9, 42
              Backstage passes to a TAFKAL80ETC concert, 5, 47
              Backstage passes to a TAFKAL80ETC concert, 4, 33
              Backstage passes to a TAFKAL80ETC concert, 0, 23
              Backstage passes to a TAFKAL80ETC concert, -1, 0
              Backstage passes to a TAFKAL80ETC concert, -2, 0
              Backstage passes to a TAFKAL80ETC concert, 14, 50
              Backstage passes to a TAFKAL80ETC concert, 9, 50
              Backstage passes to a TAFKAL80ETC concert, 4, 50
              Backstage passes to a TAFKAL80ETC concert, 9, 50
              Backstage passes to a TAFKAL80ETC concert, 4, 50
              Sulfuras, Hand of Ragnaros, 10, 80
              Sulfuras, Hand of Ragnaros, 5, 80
              Sulfuras, Hand of Ragnaros, 0, 80
              Sulfuras, Hand of Ragnaros, -1, 80
              Sulfuras, Hand of Ragnaros, -10, 80
              Conjured Mana Cake, 9, 19
              Conjured Health Potion, 4, 14
              Conjured Magic Item, 0, 9
              Conjured Ring, -1, 6
              Conjured Sword, -2, 10
              Conjured Shield, -6, 3
              Conjured Item - качество 0, 4, 0
              Conjured Item - качество 1, 4, 0
              Aged, 4, 9
              Backstage, 4, 9
              Sulfuras, 4, 9

            День 2:
              Обычный предмет 1, 8, 18
              Обычный предмет 2, 3, 8
              Обычный предмет 3, -1, 2
              Обычный предмет 4, -2, 6
              Обычный предмет 5, -3, 11
              Обычный предмет 6, -7, 21
              Обычный предмет - качество 0, 3, 0
              Обычный предмет - качество 1, 3, 0
              Обычный предмет - максимальное качество, 3, 48
              Aged Brie, 8, 22
              Aged Brie, 3, 32
              Aged Brie, -1, 43
              Aged Brie, -2, 49
              Aged Brie, -3, 29
              Aged Brie, -7, 14
              Aged Brie, 3, 2
              Aged Brie, 3, 50
              Aged Brie, 3, 50
              Aged Brie, -3, 50
              Backstage passes to a TAFKAL80ETC concert, 18, 32
              Backstage passes to a TAFKAL80ETC concert, 13, 27
              Backstage passes to a TAFKAL80ETC concert, 9, 38
              Backstage passes to a TAFKAL80ETC concert, 8, 44
              Backstage passes to a TAFKAL80ETC concert, 4, 50
              Backstage passes to a TAFKAL80ETC concert, 3, 36
              Backstage passes to a TAFKAL80ETC concert, -1, 0
              Backstage passes to a TAFKAL80ETC concert, -2, 0
              Backstage passes to a TAFKAL80ETC concert, -3, 0
              Backstage passes to a TAFKAL80ETC concert, 13, 50
              Backstage passes to a TAFKAL80ETC concert, 8, 50
              Backstage passes to a TAFKAL80ETC concert, 3, 50
              Backstage passes to a TAFKAL80ETC concert, 8, 50
              Backstage passes to a TAFKAL80ETC concert, 3, 50
              Sulfuras, Hand of Ragnaros, 10, 80
              Sulfuras, Hand of Ragnaros, 5, 80
              Sulfuras, Hand of Ragnaros, 0, 80
              Sulfuras, Hand of Ragnaros, -1, 80
              Sulfuras, Hand of Ragnaros, -10, 80
              Conjured Mana Cake, 8, 18
              Conjured Health Potion, 3, 13
              Conjured Magic Item, -1, 7
              Conjured Ring, -2, 4
              Conjured Sword, -3, 8
              Conjured Shield, -7, 1
              Conjured Item - качество 0, 3, 0
              Conjured Item - качество 1, 3, 0
              Aged, 3, 8
              Backstage, 3, 8
              Sulfuras, 3, 8

            День 3:
              Обычный предмет 1, 7, 17
              Обычный предмет 2, 2, 7
              Обычный предмет 3, -2, 0
              Обычный предмет 4, -3, 4
              Обычный предмет 5, -4, 9
              Обычный предмет 6, -8, 19
              Обычный предмет - качество 0, 2, 0
              Обычный предмет - качество 1, 2, 0
              Обычный предмет - максимальное качество, 2, 47
              Aged Brie, 7, 23
              Aged Brie, 2, 33
              Aged Brie, -2, 45
              Aged Brie, -3, 50
              Aged Brie, -4, 31
              Aged Brie, -8, 16
              Aged Brie, 2, 3
              Aged Brie, 2, 50
              Aged Brie, 2, 50
              Aged Brie, -4, 50
              Backstage passes to a TAFKAL80ETC concert, 17, 33
              Backstage passes to a TAFKAL80ETC concert, 12, 28
              Backstage passes to a TAFKAL80ETC concert, 8, 40
              Backstage passes to a TAFKAL80ETC concert, 7, 46
              Backstage passes to a TAFKAL80ETC concert, 3, 50
              Backstage passes to a TAFKAL80ETC concert, 2, 39
              Backstage passes to a TAFKAL80ETC concert, -2, 0
              Backstage passes to a TAFKAL80ETC concert, -3, 0
              Backstage passes to a TAFKAL80ETC concert, -4, 0
              Backstage passes to a TAFKAL80ETC concert, 12, 50
              Backstage passes to a TAFKAL80ETC concert, 7, 50
              Backstage passes to a TAFKAL80ETC concert, 2, 50
              Backstage passes to a TAFKAL80ETC concert, 7, 50
              Backstage passes to a TAFKAL80ETC concert, 2, 50
              Sulfuras, Hand of Ragnaros, 10, 80
              Sulfuras, Hand of Ragnaros, 5, 80
              Sulfuras, Hand of Ragnaros, 0, 80
              Sulfuras, Hand of Ragnaros, -1, 80
              Sulfuras, Hand of Ragnaros, -10, 80
              Conjured Mana Cake, 7, 17
              Conjured Health Potion, 2, 12
              Conjured Magic Item, -2, 5
              Conjured Ring, -3, 2
              Conjured Sword, -4, 6
              Conjured Shield, -8, 0
              Conjured Item - качество 0, 2, 0
              Conjured Item - качество 1, 2, 0
              Aged, 2, 7
              Backstage, 2, 7
              Sulfuras, 2, 7


        """.trimIndent()
    }
    
    /**
     * Вспомогательный тест для генерации золотого стандарта.
     * Запустите этот тест первым, чтобы получить результат для золотого стандарта.
     */
    @Test
    @Disabled("Тест для генерации золотого стандарта")
    fun generateGoldenMasterStandard() {
        val items = createTestItems()
        val gildedRose = GildedRose(items)
        val result = captureSystemBehavior(gildedRose, days = 3)
        
        println("=== ЗОЛОТОЙ СТАНДАРТ ===")
        println("Скопируйте следующий результат в метод getExpectedGoldenMasterResult():")
        println()
        println("return \"\"\"")
        print(result)
        println("\"\"\".trimIndent()")
        println("=== КОНЕЦ ЗОЛОТОГО СТАНДАРТА ===")
    }
}
