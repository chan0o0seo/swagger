package com.example.api.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "menu_order")
@Data
@Schema(description = "메뉴 주문 정보")
public class MenuOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "주문 ID", example = "1")
    private Integer id;

    @Column(name = "store_id", nullable = false)
    @Schema(description = "상점 ID", example = "123")
    private Integer storeId;

    @Column(name = "customer_id")
    @Schema(description = "고객 ID", example = "456")
    private Integer customerId;

    @Column(name = "total_amount")
    @Schema(description = "총 주문 금액", example = "20000")
    private Integer totalAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @Schema(description = "주문 상태", example = "PENDING", allowableValues = {"PENDING", "PAID", "CANCELLED", "COMPLETED"})
    private OrderStatus status;

    @Column(name = "created_at")
    @Schema(description = "주문 생성 시간", example = "2023-10-27T10:00:00Z")
    private Timestamp createdAt;

    public enum OrderStatus {
        PENDING,
        PAID,
        CANCELLED,
        COMPLETED
    }
}