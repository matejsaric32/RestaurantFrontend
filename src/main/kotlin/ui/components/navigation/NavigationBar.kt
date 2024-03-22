package ui.components.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.screens.Screen

//@Composable
//fun NavigationBar(currentScreen: Screen) {
//    Row(
//        modifier = Modifier.fillMaxWidth()
//            .padding(8.dp)
//            .padding(bottom = 24.dp),
//        horizontalArrangement = Arrangement.SpaceEvenly
//    ) {
//        Button(onClick = { AppState.currentScreen = Screen.RESTAURANT }) {
//            Text("RESTAURANT")
//        }
//        Button(onClick = { AppState.currentScreen = Screen.RESTAURANT_INSERT }) {
//            Text("RESTAURANT INSERT")
//        }
//    }
//}