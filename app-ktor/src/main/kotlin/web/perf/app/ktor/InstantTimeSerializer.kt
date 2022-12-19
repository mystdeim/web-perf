package web.perf.app.ktor

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.Instant

object InstantTimeSerializer : KSerializer<Instant> {
  override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Instant", PrimitiveKind.LONG)

  override fun serialize(encoder: Encoder, value: Instant) {
    encoder.encodeLong(value.toEpochMilli())
  }

  override fun deserialize(decoder: Decoder): Instant {
    val string = decoder.decodeString()
    return Instant.parse(string)
  }
}

