package com.ysh.shop.domain.product.repository

import com.ysh.shop.domain.product.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository  :JpaRepository<Product, Long>{
}