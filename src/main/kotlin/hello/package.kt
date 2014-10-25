package hello

import com.example.statusnet.pullStatuses

fun main(args: Array<String>) {
    val stream = pullStatuses()
    val filteredStream = stream.filter { it.text.toLowerCase().contains("and") }
    filteredStream.forEach {
        println("@${it.user.screen_name}: ${it.text}")
    }

}