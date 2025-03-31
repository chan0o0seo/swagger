package com.example.api.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "payment")
@Data
@Schema(description = "결제 정보")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "결제 ID", example = "1")
    private Integer id;

    @Column(name = "order_id", nullable = false)
    @Schema(description = "주문 ID", example = "123")
    private Integer orderId;

    @Column(name = "amount")
    @Schema(description = "결제 금액", example = "10000")
    private Integer amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "method", nullable = false)
    @Schema(description = "결제 수단", example = "CREDIT_CARD", allowableValues = {"CREDIT_CARD", "BANK_TRANSFER", "KAKAOPAY", "NAVERPAY"})
    private PaymentMethod method;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    @Schema(description = "결제 상태", example = "PENDING", allowableValues = {"PENDING", "SUCCESS", "FAILED"})
    private PaymentStatus status;

    @Column(name = "payment_date")
    @Schema(description = "결제 시간", example = "2023-10-27T10:00:00Z")
    private Timestamp paymentDate;

    public enum PaymentMethod {
        CREDIT_CARD,
        BANK_TRANSFER,
        KAKAOPAY,
        NAVERPAY
    }

    public enum PaymentStatus {
        PENDING,
        SUCCESS,
        FAILED
    }
}