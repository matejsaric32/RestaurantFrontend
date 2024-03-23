import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlinx.coroutines.launch
import model.Restaurant
import ui.components.navigation.DrawerContent
import ui.screens.Screen
import ui.screens.screens
import ui.style.DarkColorScheme


object AppState {
    var selectedRestaurant: Restaurant? by mutableStateOf(null)
    var currentScreen: Screen by mutableStateOf(Screen.RESTAURANT)
}

@Composable
@Preview
fun App() {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val currentScreen = remember { mutableStateOf(screens.first()) }
    val scope = rememberCoroutineScope()

    val navigateTo: (Screen) -> Unit = { targetScreen ->
        val targetModel = screens.find { it.route == targetScreen }
        targetModel?.let {
            currentScreen.value = it
        }
    }

    MaterialTheme(
        colorScheme = DarkColorScheme
    ) {

        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                DrawerContent(screens, currentScreen, drawerState, scope)
            },
            content = {
                Surface {
                    Column {
                        FloatingActionButton(
                            modifier = Modifier.padding(16.dp),
                            onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }) {
                            Icon(Icons.Filled.Menu, contentDescription = "Open Drawer")
                        }
                        currentScreen.value.content(navigateTo)
                    }
                }
            }
        )
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
