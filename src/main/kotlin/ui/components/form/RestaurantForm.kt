package ui.components.form

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import model.Category
import model.Restaurant

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantForm(
    restaurant: Restaurant? = null, // Accepting nullable for flexibility
    onSubmit: (Restaurant) -> Unit
) {
    var name by remember { mutableStateOf(restaurant?.name ?: "") }
    var code by remember { mutableStateOf(restaurant?.code ?: "") }
    var address by remember { mutableStateOf(restaurant?.address ?: "") }
    var phone by remember { mutableStateOf(restaurant?.phone ?: "") }
    var selectedCategory by remember { mutableStateOf(restaurant?.category ?: Category.CAFE) }

    // Assuming you want to keep the expanded logic for a dropdown
    var expanded by remember { mutableStateOf(false) }
    val categories = Category.values().toList()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
        ) {

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") }
            )
            Spacer(modifier = Modifier.height(8.dp))
//        OutlinedTextField(
//            value = code,
//            onValueChange = { code = it },
//            label = { Text("Code") },
//            keyboardOptions = KeyboardOptions.Default.copy(
//                keyboardType = KeyboardType.Text,
//                imeAction = ImeAction.Next
//            )
//        )
            Spacer(modifier = Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.Start) {
                OutlinedButton(onClick = { expanded = true }) {
                    Text(text = selectedCategory?.displayName ?: "Select Category")
                }
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                categories.forEach { category ->
                    DropdownMenuItem(
                        text = { Text(category.displayName) },
                        onClick = {
                            selectedCategory = category
                            expanded = false
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = address,
                onValueChange = { address = it },
                label = { Text("Address") }
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text("Phone") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Phone
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    onSubmit(Restaurant(name, code, selectedCategory, address, phone))
                }
            ) {
                Text("Submit")
            }
        }
    }
}

