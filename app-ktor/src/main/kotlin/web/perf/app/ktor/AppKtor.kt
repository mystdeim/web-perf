package web.perf.app.ktor

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.http.content.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.*

import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import web.perf.app.ktor.model.SimpleModel
import java.time.Instant


fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureRouting()
    configureJson()
}

fun Application.configureRouting() {
    val currentDir = File(".").absoluteFile
    environment.log.info("Current directory: $currentDir")

    routing {
        get("/api/v1/test") {
            call.respond(SimpleModel("test", Instant.now()))
        }
    }
}

fun Application.configureJson() {
    install(ContentNegotiation) {
        json()
    }
}
