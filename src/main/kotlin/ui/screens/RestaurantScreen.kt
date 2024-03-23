package ui.screens

import AppState
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.ktor.client.plugins.*
import iterator.DataIteratorImpl
import kotlinx.coroutines.launch
import model.Restaurant
import repository.RestaurantRepositoryImpl
import ui.components.table.DisplayRestaurant



@Composable
@Preview
fun RestaurantScreen(onNavigate: (Screen) -> Unit) {

    var restaurants by remember { mutableStateOf(emptyList<Restaurant>()) }
    var itemsPerPage by remember { mutableStateOf(10) }
    val restaurantIterator = remember { DataIteratorImpl<Restaurant>(itemsPerPage = itemsPerPage,
        fetchData = RestaurantRepositoryImpl::getRestaurant) }
    val scope = rememberCoroutineScope()
//    var currentPage by remember { mutableStateOf(0) }

//    var hardwareIterator by remember { mutableStateOf(DataIteratorImpl<PageResponse<Restaurant>>()) }
//    var currentData by remember { mutableStateOf(hardwareIterator.next()) }


    LaunchedEffect(Unit) {
        scope.launch {
            try {
                restaurants = restaurantIterator.next()
            } catch (e: ClientRequestException) {
                println("Error fetching data: ${e.message}")
            }
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End

        ) {
            val modifier = Modifier
                .padding(8.dp)
            Button(onClick = { onNavigate(Screen.RESTAURANT_INSERT) }) {
                Text("Add Restaurant")
            }
            IconButton(
                modifier = modifier,
                onClick = {
                scope.launch { restaurants = restaurantIterator.previous() } }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Previous")
            }
            IconButton(
                modifier = modifier,
                onClick = {
                scope.launch { restaurants = restaurantIterator.next() } }) {
                Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Next")
            }
        }

        DisplayRestaurant(restaurants, onUpdate = { restaurantToUpdate ->
            println("Update")
            AppState.selectedRestaurant = restaurantToUpdate
            onNavigate(Screen.RESTAURANT_UPDATE)
        }, onDelete = { restaurantToDelete ->
            scope.launch {
                try {
                    println("Deleting restaurant: $restaurantToDelete")
                    RestaurantRepositoryImpl.deleteRestaurantByCode(restaurantToDelete)
                    restaurants = restaurantIterator.fetchItems()
                } catch (e: ClientRequestException) {
                    println("Error deleting data: ${e.message}")
                }
            }
        }
        )
    }
}