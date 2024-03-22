package model

import kotlinx.serialization.Serializable
import lombok.Data

@Data
@Serializable
data class Restaurant(
    val name: String,
    val code: String,
    val category: Category,
    val address: String,
    val phone: String
)
