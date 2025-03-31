package com.example.api.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "order_item")
@Data
@Schema(description = "주문 아이템 정보")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "주문 아이템 ID", example = "1")
    private Integer id;

    @Column(name = "order_id", nullable = false)
    @Schema(description = "주문 ID", example = "123")
    private Integer orderId;

    @Column(name = "ingredient_id", nullable = false)
    @Schema(description = "재료 ID", example = "456")
    private Integer ingredientId;

    @Column(name = "quantity")
    @Schema(description = "수량", example = "10")
    private Integer quantity;

    @Column(name = "price")
    @Schema(description = "단가", example = "1000")
    private Integer price;

    @Column(name = "total_price")
    @Schema(description = "총 가격", example = "10000")
    private Integer totalPrice;
}