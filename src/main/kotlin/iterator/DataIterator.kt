package iterator

interface DataIterator<T> {
    suspend fun hasNext(): Boolean
    suspend fun next(): List<T>
    suspend fun fetchItems(): List<T>
    suspend fun hasPrevious(): Boolean
    suspend fun previous(): List<T>
}