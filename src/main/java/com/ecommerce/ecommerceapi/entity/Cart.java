package com.ecommerce.ecommerceapi.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {

    @Id
    private String id;
    @JoinColumn
    @ManyToOne
    private Product product;
    @JoinColumn
    @ManyToOne
    private User user;
    private Double quantity;
    private BigDecimal price;
    private BigDecimal total;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

}
