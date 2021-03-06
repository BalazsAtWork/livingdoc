package org.livingdoc.converters.number

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.livingdoc.converters.DefaultTypeConverterContract

internal class FloatConverterTest : BoundedNumberConverterContract<Float>(), DefaultTypeConverterContract {

    override val cut = FloatConverter()

    override val minValue = Float.MIN_VALUE
    override val negativeValue = -42.24f
    override val zeroValue = 0.0f
    override val positiveValue = 42.24f
    override val maxValue = Float.MAX_VALUE

    override val englishValue = "42,000.24" to 42000.24f
    override val germanValue = "42.000,24" to 42000.24f

    @Test fun `not a number is handled correctly`() {
        cut.convert(Float.NaN.toString())
    }

    @Test fun `positive infinity is handled correctly`() {
        cut.convert(Float.POSITIVE_INFINITY.toString())
    }

    @Test fun `negative infinity is handled correctly`() {
        cut.convert(Float.NEGATIVE_INFINITY.toString())
    }

    @Test fun `converter can converted to Kotlin Float`() {
        assertThat(cut.canConvertTo(Float::class.java)).isTrue()
    }

}
