package web.perf.app.vertx

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.vertx.core.json.jackson.DatabindCodec
import io.vertx.ext.web.Route
import io.vertx.ext.web.RoutingContext
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun Route.coroutineHandler(fn: suspend (RoutingContext) -> Unit): Route = handler { ctx ->
    GlobalScope.launch(ctx.vertx().dispatcher()) {
        try {
            fn(ctx)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

fun mapper() {
    val mapper = DatabindCodec.mapper()
    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
    mapper.registerModule(KotlinModule())
    mapper.registerModule(JavaTimeModule())
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
      .disable(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS)
      .disable(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS)
}
