package com.ysh.shop.domain.product.service

import com.ysh.shop.domain.product.model.Product
import com.ysh.shop.domain.product.repository.ProductRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@RequiredArgsConstructor
@Service
class ProductService(private val productRepository: ProductRepository) {
    fun addProduct(product: Product):Product{
        val res = productRepository.save(product);
        return res
    }

    fun getProductList(category:String): List<Product> {
        return productRepository.findAllByCategoryAndDeleteAt(category,null)
    }

    @Transactional
    fun delete(productId:Long){
        val product = loadProductById(productId);
        product.delete()

    }
    fun loadProductById(id: Long): Product {
        val product = productRepository.findByIdAndDeleteAt(id,null)

        if (product == null) {
            throw IllegalAccessException("해당 상품을 찾을 수 없습니다.")
        }else return product
    }
}