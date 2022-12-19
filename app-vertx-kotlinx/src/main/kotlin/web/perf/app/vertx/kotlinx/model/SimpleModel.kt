package web.perf.app.vertx.app.model

import kotlinx.serialization.Serializable
import web.perf.app.vertx.kotlinx.InstantTimeSerializer
import java.time.Instant

@Serializable
data class SimpleModel(
    val id: String,

    @Serializable(InstantTimeSerializer::class)
    val date: Instant
)
