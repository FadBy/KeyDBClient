import kotlinx.coroutines.runBlocking

fun receiveRequests() {
    val keyDBClient = KeyDBClient()
    runBlocking {
        while (true) {
            keyDBClient.receiveRequest("requestChannel", { _ -> "OK" }, String::class.java)
        }
    }
}

fun main() {
    println("Ожидание запросов...")
    receiveRequests()
}
