package ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import repository.RestaurantRepositoryImpl
import ui.components.form.RestaurantForm

@Composable
fun RestaurantInsertScreen(onNavigate: (Screen) -> Unit) {

    val scope = rememberCoroutineScope()

    RestaurantForm(onSubmit = { restaurant ->
        GlobalScope.launch{
            RestaurantRepositoryImpl.addRestaurant(restaurant)
        }
        onNavigate(Screen.RESTAURANT)
    })
}