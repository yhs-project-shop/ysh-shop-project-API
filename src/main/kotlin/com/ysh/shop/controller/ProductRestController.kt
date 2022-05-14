package com.ysh.shop.controller

import com.ysh.shop.domain.product.dto.RequestProductDto
import com.ysh.shop.domain.product.model.Product
import com.ysh.shop.domain.product.service.ProductService
import org.springframework.web.bind.annotation.*

@RestController
class ProductRestController(private val productService: ProductService) {

    @PostMapping("/products")
    fun addProduct(@RequestBody productDto: RequestProductDto): Product {
        val product = Product(productDto)
        return productService.addProduct(product)
    }

    @GetMapping("/products/{category}")
    fun list(@PathVariable category: String): List<Product> {
        return productService.getProductList(category)
    }

    @DeleteMapping("/products")
    fun delete(@RequestParam productId:String){
        return productService.delete(productId.toLong())
    }

    @GetMapping("/product/{productId}")
    fun detail(@PathVariable productId: String): Product {
        return productService.loadProductById(productId.toLong())
    }
}