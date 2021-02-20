package com.taein.paging3test

enum class DataType { HEADER, ITEM, SEPARATOR }

sealed class DataModel(val type: DataType) {
    data class Item(val title: String) : DataModel(DataType.ITEM)
    data class Header(val title: String) : DataModel(DataType.HEADER)
    object Separator : DataModel(DataType.SEPARATOR)
}
