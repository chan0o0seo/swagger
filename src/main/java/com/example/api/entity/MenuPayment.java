package com.example.api.entity;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "menu_payment")
@Schema(description = "메뉴 결제 정보")
public class MenuPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "결제 ID", example = "1")
    private Integer id;

    @Schema(description = "메뉴 주문 ID", example = "1")
    private Integer menuOrderId;

    @Schema(description = "결제 금액", example = "10000")
    private Integer amount;

    @Enumerated(EnumType.STRING)
    @Schema(description = "결제 방법", example = "CREDIT_CARD")
    private PaymentMethod method;

    @Enumerated(EnumType.STRING)
    @Schema(description = "결제 상태", example = "PENDING")
    private PaymentStatus status;

    @Schema(description = "결제 일자", example = "2024-03-30T12:00:00")
    private Timestamp paymentDate;

    enum PaymentMethod {
        CREDIT_CARD, BANK_TRANSFER, KAKAOPAY, NAVERPAY
    }

    enum PaymentStatus {
        PENDING, SUCCESS, FAILED
    }
}


