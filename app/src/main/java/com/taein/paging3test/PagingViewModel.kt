package com.taein.paging3test

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig

class PagingViewModel : ViewModel() {
    val flow = Pager(PagingConfig(pageSize = 10)) {  // config 설정
        DooolPagingSource(PagingRepository())    // pagingSource 연결
    }.flow.map {
        it.map<DataModel> { DataModel.Item(it) }.insertHeaderItem(DataModel.Header("HEADER"))
            .insertFooterItem(DataModel.Header("FOOTER")).insertSeparators { before, after ->
                when {
                    before is DataModel.Item && after is DataModel.Item -> {
                        if (before.title.startsWith("C") && after.title.startsWith("A")) DataModel.Separator else null
                    }
                    else -> null
                }
            }
    }.cachedIn(viewModelScope) // 캐싱
}
