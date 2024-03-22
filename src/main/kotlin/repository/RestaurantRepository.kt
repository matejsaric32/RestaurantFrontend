package repository

import model.Restaurant
import model.page.PageResponse

interface RestaurantRepository {

    suspend fun getRestaurant(index: Int, size: Int): PageResponse<Restaurant>
    suspend fun getRestaurantByCode(code: String): Restaurant?
    suspend fun addRestaurant(restaurant: Restaurant)
    suspend fun updateRestaurant(restaurant: Restaurant)
    suspend fun deleteRestaurantByCode(restaurant: Restaurant)

}