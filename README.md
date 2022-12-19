# WEB PERF

Comparison performance of ktor and vert.x

### Project structure
 * `app-ktor` -- ktop application with kotlinx.serialization
 * `app-vertx` -- vertx application with jackson serialization
 * `app-vertx-kotlinx` -- vertx application with kotlinx.serialization

### Helpful commands
 * show deps: `../gradlew -q dependencies --configuration runtimeClasspath`
 * test: `wrk -t12 -c400 -d30s http://127.0.0.1:8080/api/v1/test`
