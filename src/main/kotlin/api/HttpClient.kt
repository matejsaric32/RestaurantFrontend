package api

import com.google.gson.Gson
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.util.*
import kotlinx.serialization.json.Json
import model.Restaurant
import model.page.PageResponse

@OptIn(InternalAPI::class)
object Api {

    val httpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
    }
    val gson = Gson()

    val baseUrl = "http://localhost:8088"
    val restaurantUrl = "$baseUrl/restaurant"

//    suspend fun getAllHardware(): List<Restaurant> {
//        val body = httpClient.get("http://localhost:8088/restaurant").body<String>()
//        val x = Json.decodeFromString<PageResponse<Restaurant>>(body)
////        println(x)
//        return gson.fromJson(body, Array<Restaurant>::class.java).toList()
//    }

//    suspend fun postNewHardware(hardware: Hardware): Hardware {
//        val body = httpClient.post("http://localhost:8081/hardware") {
//            contentType(ContentType.Application.Json)
//            body = gson.toJson(hardware)
//        }.body<String>()
//        println(body)
//        return gson.fromJson(body, Hardware::class.java)
//    }
//
//    suspend fun putHardware(hardware: Hardware): Hardware {
//        val body = httpClient.put("http://localhost:8081/hardware") {
//            contentType(ContentType.Application.Json)
//            body = gson.toJson(hardware)
//        }.body<String>()
//        println(body)
//        return gson.fromJson(body, Hardware::class.java)
//    }
//
//    suspend fun deleteHardware(hardware: Hardware): Hardware {
//        val body = httpClient.delete("${hardwareUrl}/${hardware.code}") {
//            contentType(ContentType.Application.Json)
//            body = gson.toJson(hardware)
//        }.body<String>()
//        return gson.fromJson(body, Hardware::class.java)
//    }
}

