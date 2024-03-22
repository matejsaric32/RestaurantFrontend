package ui.components.navigation

import ScreenModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.DrawerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DrawerContent(
    screens: List<ScreenModel>,
    currentScreen: MutableState<ScreenModel>,
    drawerState: DrawerState,
    scope: CoroutineScope
) {
    Column(
        modifier = Modifier
//            .fillMaxWidth()
            .fillMaxHeight()
            .width(300.dp)
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(8.dp)
    ) {
        Text(
            text = "Interop Frontend",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(8.dp)
                .padding(bottom = 24.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            Image(
                modifier = Modifier.size(100.dp),
                imageVector = Icons.Filled.AccountCircle,
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        screens.forEach { screen ->
            NavigationDrawerItem(
                label = {
                    Text(
                        style = MaterialTheme.typography.bodyLarge,
                        text = screen.route.displayName
                    )
                },
                selected = currentScreen.value == screen,
                onClick = {
                    currentScreen.value = screen
                    scope.launch { drawerState.close() }
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}