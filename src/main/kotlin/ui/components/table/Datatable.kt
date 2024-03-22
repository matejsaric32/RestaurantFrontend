package ui.components.table

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.Restaurant

@Composable
@Preview
fun <T> DataTable(
    headerComposable: @Composable (Modifier) -> Unit,
    data: List<T>,
    rowComposable: @Composable (Int, T, Modifier, (T) -> Unit, (T) -> Unit) -> Unit,
) {
    Column {
        headerComposable(
            Modifier
                .fillMaxWidth()
                .padding(vertical =  8.dp)
                .padding(start = 16.dp)
        )
        Divider()
    }
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colorScheme.background)
    ) {

        data.forEachIndexed { index, item ->
            val backgroundColor = if (index % 2 == 0) MaterialTheme.colorScheme.surface
            else MaterialTheme.colorScheme.surfaceVariant
            val rowModifier = Modifier
                .fillMaxWidth()
                .background(backgroundColor)
                .padding(vertical = 8.dp)
                .padding(start = 16.dp)


            rowComposable(index, item, rowModifier, { hardwareToUpdate -> }, { hardwareToDelete -> })
        }
    }
}

@Composable
fun DisplayRestaurant(
    data: List<Restaurant>,
    onUpdate: (Restaurant) -> Unit,
    onDelete: (Restaurant) -> Unit
) {
    Divider(
        thickness = 1.dp,
        color = MaterialTheme.colorScheme.onBackground
    )
    DataTable(
        headerComposable = { RestaurantHeader() },
        data = data,
        rowComposable = { index, hardware, modifier, _, _ ->
            RestaurantRowComposable(index, hardware, modifier, onUpdate, onDelete)
        }
    )
}