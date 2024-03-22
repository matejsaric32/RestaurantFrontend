package model.page

import kotlinx.serialization.Serializable
import lombok.Data

@Data
@Serializable
open class Sort(
    val empty: Boolean,
    val sorted: Boolean,
    val unsorted: Boolean
) {
    override fun toString(): String {
        return "Sort(empty=$empty, sorted=$sorted, unsorted=$unsorted)"
    }
}