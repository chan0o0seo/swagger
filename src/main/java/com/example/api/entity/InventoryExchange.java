package com.example.api.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "inventory_exchange")
@Data
@Schema(description = "재고 교환 정보")
public class InventoryExchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "교환 ID", example = "1")
    private Integer id;

    @Column(name = "seller_store_id", nullable = false)
    @Schema(description = "판매자 상점 ID", example = "123")
    private Integer sellerStoreId;

    @Column(name = "buyer_store_id")
    @Schema(description = "구매자 상점 ID", example = "456")
    private Integer buyerStoreId;

    @Column(name = "ingridient_id", nullable = false)
    @Schema(description = "재료 ID", example = "789")
    private Integer ingridientId;

    @Column(name = "quantity")
    @Schema(description = "수량", example = "10")
    private Integer quantity;

    @Column(name = "price")
    @Schema(description = "가격", example = "1000")
    private Integer price;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @Schema(description = "교환 상태", example = "available", allowableValues = {"available", "sold", "canceled"})
    private ExchangeStatus status;

    @Column(name = "created_at")
    @Schema(description = "생성 시간", example = "2023-10-27T10:00:00Z")
    private Timestamp createdAt;

    public enum ExchangeStatus {
        available,
        sold,
        canceled
    }
}