import kotlinx.coroutines.*
import kotlin.random.Random

val keyDBClient = KeyDBClient()

fun main(): Unit = runBlocking {
    println("Запуск автоматической отправки запросов...")
    delay(500) // Задержка перед первым запросом
    launch {
        sendRepeatedly();
    }
    launch {
        sendRepeatedly();
    }
    launch {
        sendRepeatedly();
    }
    launch {
        sendRepeatedly();
    }
    launch {
        sendRepeatedly();
    }

}

suspend fun sendRepeatedly() {
    while (true) {
        println(keyDBClient.sendRequest(
            "requestChannel",
            Message("Запрос"),
            Message::class.java
        )?.message)
        val randomDelay = Random.nextLong(300, 1000)
        delay(randomDelay)
    }
}

data class Message(val message: String)
