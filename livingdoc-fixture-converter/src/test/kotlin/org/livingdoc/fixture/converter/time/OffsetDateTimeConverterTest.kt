package org.livingdoc.fixture.converter.time

import java.time.OffsetDateTime
import java.time.OffsetDateTime.parse


internal class OffsetDateTimeConverterTest : TemporalConverterContract<OffsetDateTime>() {

    override val cut = OffsetDateTimeConverter()

    override val validInputVariations = mapOf(
            "2017-05-12T12:34+01:00" to parse("2017-05-12T12:34+01:00"),
            "2017-05-12T12:34:56+01:00" to parse("2017-05-12T12:34:56+01:00"),
            "2017-05-12T12:34:56.123+01:00" to parse("2017-05-12T12:34:56.123+01:00")
    )

    override val defaultFormatValue = "2017-05-12T12:34+01:00" to parse("2017-05-12T12:34+01:00")

    override val customFormat = "dd.MM.uuuu HH:mm 'Uhr' X"
    override val customFormatValue = "12.05.2017 12:34 Uhr +01" to parse("2017-05-12T12:34+01:00")
    override val malformedCustomFormat = "dd.MM.uuuu HH:mm X V"

}