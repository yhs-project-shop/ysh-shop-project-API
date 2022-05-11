package com.ysh.shop.domain.product.model

import com.ysh.shop.domain.product.dto.RequestProductDto
import java.time.OffsetDateTime
import javax.persistence.*

@Entity
class Product (productDto: RequestProductDto) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null
    @Column
    val name : String = productDto.name
    @Column
    val image : String = productDto.image
    @Column
    val price : Int = productDto.price.toInt()
    @Column
    val brand : String = productDto.brand
    @Column
    val category : String = productDto.category
    @Column
    val description : String = productDto.description
    val createAt : OffsetDateTime = OffsetDateTime.now()
    var updateAt : OffsetDateTime = OffsetDateTime.now();
    val deleteAt : OffsetDateTime? = null;
}