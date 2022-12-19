package web.perf.app.ktor.model

import kotlinx.serialization.Serializable
import web.perf.app.ktor.InstantTimeSerializer
import java.time.Instant

@Serializable
data class SimpleModel(
    val id: String,

    @Serializable(InstantTimeSerializer::class)
    val date: Instant
)
