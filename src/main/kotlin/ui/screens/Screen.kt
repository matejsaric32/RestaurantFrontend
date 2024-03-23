package ui.screens

import androidx.compose.runtime.Composable


data class ScreenModel(
    val route: Screen,
    val screenType: ScreenType = ScreenType.SECONDARY,
    val content: @Composable ((Screen) -> Unit) -> Unit
)

enum class ScreenType {
    MAIN,
    SECONDARY
}

enum class Screen(val displayName: String) {
    RESTAURANT("Restaurant"),
    RESTAURANT_INSERT("Restaurant Insert"),
    RESTAURANT_UPDATE("Restaurant Update")
}

val screens = listOf(
    ScreenModel(
        route = Screen.RESTAURANT,
        screenType = ScreenType.MAIN,
        content = { navigateTo -> RestaurantScreen(navigateTo) }
    ),
    ScreenModel(
        route = Screen.RESTAURANT_INSERT,
        content = { navigateTo -> RestaurantInsertScreen(navigateTo) }
    ),
    ScreenModel(
        route = Screen.RESTAURANT_UPDATE,
        content = { navigateTo -> RestaurantUpdateScreen(navigateTo) }
    )
)