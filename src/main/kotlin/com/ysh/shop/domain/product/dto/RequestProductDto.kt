package com.ysh.shop.domain.product.dto

data class RequestProductDto (
    val name : String = "",
    val image : String = "",
    val price : String = "",
    val brand : String = "",
    val category : String = "",
    val description : String = ""
)