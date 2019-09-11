import io.ktor.application.ApplicationCallPipeline
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.server.testing.it
import io.ktor.server.testing.on
import io.ktor.server.testing.withTestApplication
import kotlin.test.Test
import kotlin.test.assertTrue

internal class ApplicationTest {
    @Test
    fun `application with handler returning true`() = withTestApplication {
        application.intercept(ApplicationCallPipeline.Call) { call.respond(HttpStatusCode.OK) }
        on("making a request") {
            val call = handleRequest { }
            it("should be handled") {
                assertTrue(call.requestHandled)
            }
        }
    }
}