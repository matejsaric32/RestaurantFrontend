package ui.screens

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import repository.RestaurantRepositoryImpl
import ui.components.form.RestaurantForm

@Composable
fun RestaurantInsertScreen(onNavigate: (Screen) -> Unit, modifier: Modifier = Modifier.fillMaxWidth().fillMaxHeight()) {

    RestaurantForm(onSubmit = { restaurant ->
        GlobalScope.launch{
            RestaurantRepositoryImpl.addRestaurant(restaurant)
        }
        onNavigate(Screen.RESTAURANT)
    })
}