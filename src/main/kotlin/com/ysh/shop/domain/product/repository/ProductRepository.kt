package com.ysh.shop.domain.product.repository

import com.ysh.shop.domain.product.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import java.time.OffsetDateTime

interface ProductRepository  :JpaRepository<Product, Long>{
    fun findAllByCategoryAndDeleteAt(category: String, deleteAt: OffsetDateTime?):List<Product>

    fun findByIdAndDeleteAt(id:Long,deleteAt: OffsetDateTime?):Product?

}