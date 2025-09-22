class Example {
    val greeting: String
        get() = "Hello, World!"

    fun isEvenNumber(number: Int): Boolean {
        return number % 2 == 0
    }

    fun isBlankString(value: String): Boolean {
        return value.isBlank()
    }

    fun getStringLengthWithTrim(value: String): Int {
        return value.trim { it <= ' ' }.length
    }
}