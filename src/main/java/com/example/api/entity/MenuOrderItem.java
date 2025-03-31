package com.example.api.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "menu_order_item")
@Data
@Schema(description = "메뉴 주문 아이템 정보")
public class MenuOrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "메뉴 주문 아이템 ID", example = "1")
    private Integer id;

    @Column(name = "menu_order_id", nullable = false)
    @Schema(description = "메뉴 주문 ID", example = "123")
    private Integer menuOrderId;

    @Column(name = "menu_id", nullable = false)
    @Schema(description = "메뉴 ID", example = "456")
    private Integer menuId;

    @Column(name = "quantity")
    @Schema(description = "수량", example = "2")
    private Integer quantity;

    @Column(name = "total_price")
    @Schema(description = "총 가격", example = "16000")
    private Integer totalPrice;
}