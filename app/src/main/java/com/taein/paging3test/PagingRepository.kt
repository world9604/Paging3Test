package com.taein.paging3test

class PagingRepository {

    fun getPagingData(page: Int): Pair<List<String>, Int?> {
        return if (page <= 30)
            Pair(listOf("A $page", "B $page", "C $page"), page + 1)
        else
            Pair(listOf(), null)
    }
}