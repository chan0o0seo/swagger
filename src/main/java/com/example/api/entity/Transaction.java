package com.example.api.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "transaction")
@Data
@Schema(description = "거래 정보")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "거래 ID", example = "1")
    private Integer id;

    @Column(name = "payment_id", nullable = false)
    @Schema(description = "결제 ID", example = "123")
    private Integer paymentId;

    @Column(name = "store_id", nullable = false)
    @Schema(description = "상점 ID", example = "456")
    private Integer storeId;

    @Column(name = "amount")
    @Schema(description = "거래 금액", example = "10000")
    private Integer amount;

    @Column(name = "transaction_date")
    @Schema(description = "거래 날짜 및 시간", example = "2023-10-27T10:00:00Z")
    private Timestamp transactionDate;

    @Column(name = "transaction_id", length = 100)
    @Schema(description = "결제사에서 발급한 거래 고유 ID", example = "tx-1234567890")
    private String transactionId;
}
