package repository

import api.Api
import api.Api.restaurantUrl
import exception.ApiExcpetion
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.util.*
import kotlinx.serialization.json.Json
import model.Restaurant
import model.page.PageResponse
import utils.createPageUrl

object RestaurantRepositoryImpl : RestaurantRepository {
    override suspend fun getRestaurant(index: Int, size: Int): PageResponse<Restaurant> {
        val body = Api.httpClient.get("${restaurantUrl}${createPageUrl(index, size)}").body<String>()
        val pageResponse: PageResponse<Restaurant> = Json.decodeFromString<PageResponse<Restaurant>>(body)
        return pageResponse
    }

    override suspend fun getRestaurantByCode(code: String): Restaurant? {
        TODO("Not yet implemented")
    }

    @OptIn(InternalAPI::class)
    override suspend fun addRestaurant(restaurant: Restaurant) {
        try {
            val response = Api.httpClient.post(restaurantUrl) {
                contentType(ContentType.Application.Json)
                setBody(restaurant)
            }
        } catch (e: Exception) {
            println(e.message)
        }

    }

    override suspend fun updateRestaurant(restaurant: Restaurant) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteRestaurantByCode(restaurant: Restaurant) {

        val response = Api.httpClient.delete("${restaurantUrl}/${restaurant.code}")

        if (!response.status.isSuccess()) {
            throw ApiExcpetion("Error deleting restaurant: ${response.status}")
        }
    }
}