package com.ecommerce.ecommerceapi.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long productId;

    private String productName;
    private String productDesc;
    private String productImg;

    @JoinColumn (
            name = "category_id",
            referencedColumnName = "categoryId"
    )
    @ManyToOne()
    private Category category;
    private BigDecimal price;
    private Double stock;


}
