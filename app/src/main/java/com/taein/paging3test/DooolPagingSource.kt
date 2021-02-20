package com.taein.paging3test

import androidx.paging.PagingSource
import androidx.paging.PagingState

class DooolPagingSource( private val repository: PagingRepository )
    : PagingSource<Int, String>() {

    override suspend fun load(params: LoadParams<Int>)
            : LoadResult<Int, String> {
        return try {
            val nextPage = params.key ?: 1
            val response = repository.getPagingData(nextPage)
            LoadResult.Page( data = response.first, prevKey = null, nextKey = response.second )
        } catch (e: Exception) {
            LoadResult.Error(Throwable("Paging Error"))
        }
    }

    override fun getRefreshKey(state: PagingState<Int, String>): Int? {
        TODO("Not yet implemented")
    }
}

