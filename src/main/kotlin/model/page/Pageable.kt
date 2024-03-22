package model.page

import kotlinx.serialization.Serializable
import lombok.Data

@Data
@Serializable
open class Pageable(
    val pageNumber: Int,
    val pageSize: Int,
    val sort: Sort,
    val offset: Int, 
    val paged: Boolean,
    val unpaged: Boolean
) {
    override fun toString(): String {
        return "Pageable(pageNumber=$pageNumber, pageSize=$pageSize, sort=$sort, offset=$offset, paged=$paged, unpaged=$unpaged)"
    }
}