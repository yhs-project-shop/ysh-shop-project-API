package com.ysh.shop.controller

import com.ysh.shop.domain.product.dto.ProductDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductRestController {

    @PostMapping("/products") // ?? : @RequestBody 안해도 값 들어온다.
    fun addProduct(productDto: ProductDto): ProductDto {
        println("productDto = ${productDto}")
        return productDto;
    }
}