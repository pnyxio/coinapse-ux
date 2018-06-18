package io.pnyx.coinapse.ktor

import io.ktor.application.*
import io.ktor.content.TextContent
import io.ktor.features.StatusPages
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
    val server = embeddedServer(Netty, port = 9090) {
        install(StatusPages) {
            status(HttpStatusCode.NotFound) {
                call.respond(TextContent("${it.value} ${it.description}", ContentType.Text.Plain/*TODO.withCharset(Charsets.UTF_8)*/, it))
            }
        }
        routing {
            get("/") {
                call.respondText("Hello World!", ContentType.Text.Plain)
            }
            get("/demo") {
                call.respondText("HELLO WORLD!")
            }

        }
    }
    server.start(wait = true)
}