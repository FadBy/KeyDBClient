import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
fun receiveRequests() {
    val keyDBClient = KeyDBClient()
    GlobalScope.launch {
        keyDBClient.subscribeWithResponse("requestChannel", { _ -> Message("OK") }, Message::class.java)
    }
}

fun main() = runBlocking {
    println("Ожидание запросов...")
    receiveRequests()
    // Блокируем main, чтобы программа не завершалась
    delay(Long.MAX_VALUE)
}

data class Message(val message: String)
