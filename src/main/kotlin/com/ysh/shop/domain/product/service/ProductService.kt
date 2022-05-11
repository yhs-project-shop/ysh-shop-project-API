package com.ysh.shop.domain.product.service

import com.ysh.shop.domain.product.dto.RequestProductDto

import com.ysh.shop.domain.product.model.Product
import com.ysh.shop.domain.product.repository.ProductRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import java.util.*

@RequiredArgsConstructor
@Service
class ProductService(private val productRepository: ProductRepository) {
    fun addProduct(productDto: RequestProductDto):Product?{
        val product = Product(productDto);
        val res = productRepository.save(product);
        return res
    }
}