import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class ExampleShould {
    @Test
    fun returnWellKnownPhrase() {
        val subject = Example()

        val actual = subject.greeting

        assertEquals("Hello, World!", actual)
    }

    @ParameterizedTest
    @ValueSource(ints = [2, 4, 18, 346])
    fun defineNumberIsEven(number: Int) {
        val subject = Example()

        val actual = subject.isEvenNumber(number)

        assertTrue(actual)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", " 3 ", "  3 "])
    fun defineStringIsNotBlank(value: String?) {
        val subject = Example()

        val actual = subject.isBlankString(value!!)

        assertFalse(actual)
    }

    @ParameterizedTest
    @CsvSource(
        "hello world, 11",
        " hello,       5",
        "hello    ,    5"
    )
    fun definePhraseLengthWithoutLeadingAndTrailingSpaces(phrase: String?, expectedLength: Int) {
        val subject = Example()

        val actual = subject.getStringLengthWithTrim(phrase!!)

        assertThat(actual).isEqualTo(expectedLength)
    }
}
