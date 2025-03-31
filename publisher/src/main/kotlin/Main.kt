import kotlinx.coroutines.*

fun main() = runBlocking {
    val keyDBClient = KeyDBClient()

    println("Запуск автоматической отправки запросов...")
    delay(500) // Задержка перед первым запросом

    while (true) {
        keyDBClient.sendRequest(
            "requestChannel",
            "Запрос",
            { response -> println(response) }, // Это messageHandler
            String::class.java
        )
        delay(500) // Задержка перед следующим запросом
    }
}
