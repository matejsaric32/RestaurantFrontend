package iterator

import model.page.PageResponse

class DataIteratorImpl<T>(
    private val itemsPerPage: Int,
    private val fetchData: suspend (page: Int, size: Int) -> PageResponse<T>
) : DataIterator<T> {
    private var currentPage = 0
    private var totalPages = 1
    private var currentPageData: List<T> = emptyList()

    override suspend fun hasNext(): Boolean = currentPage < totalPages

    override suspend fun hasPrevious(): Boolean = currentPage >= 0

    override suspend fun next(): List<T> {
        if (!hasNext()) return currentPageData
        currentPage++
        println("$currentPage $totalPages")
        return fetchItems()
    }

    override suspend fun previous(): List<T> {
        if (!hasPrevious()) return currentPageData
        currentPage = maxOf(1, currentPage - 1)
        println("$currentPage $totalPages")
        return fetchItems()
    }

    override suspend fun fetchItems(): List<T> {
        return try {
            val response = fetchData.invoke(currentPage - 1, itemsPerPage)
            totalPages = response.totalPages
            currentPage = response.pageable.pageNumber + 1
            currentPageData = response.content
            response.content
        } catch (e: Exception) {
            println("Error fetching data: ${e.message}")
            emptyList()
        }
    }

}