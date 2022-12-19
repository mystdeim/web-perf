package web.perf.app.vertx.kotlinx

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

