package model.page

import kotlinx.serialization.Serializable

@Serializable
open class PageResponse<T>(
    val content: List<T>,
    val pageable: Pageable,
    val last: Boolean,
    val totalPages: Int,
    val totalElements: Int,
    val numberOfElements: Int,
    val first: Boolean,
    val size: Int,
    val number: Int,
    val sort: Sort,
    val empty: Boolean
) {
    override fun toString(): String {
        return "PageResponse(content=$content, pageable=$pageable, last=$last, totalPages=$totalPages, totalElements=$totalElements, numberOfElements=$numberOfElements, first=$first, size=$size, number=$number, sort=$sort, empty=$empty)"
    }
}