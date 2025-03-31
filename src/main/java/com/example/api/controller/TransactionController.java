package com.example.api.controller;

import com.example.api.entity.dto.PaymentDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/order/transactions")
public class TransactionController {

    @GetMapping("/search")
    @Operation(summary = "거래 내역 조회", description = "모든 거래 내역을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "거래 내역 조회 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentDto.TransactionResponse.class)))
    })
    public ResponseEntity<List<PaymentDto.TransactionResponse>> getTransactions() {
        List<PaymentDto.TransactionResponse> transactions = Arrays.asList(
                new PaymentDto.TransactionResponse(1, 1, 456, 20000, new Timestamp(System.currentTimeMillis()), "tx-1234567890")
        );
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/detail/{id}")
    @Operation(summary = "거래 상세 조회", description = "특정 거래 ID에 대한 상세 정보를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "거래 상세 조회 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentDto.TransactionResponse.class))),
            @ApiResponse(responseCode = "404", description = "거래를 찾을 수 없음")
    })
    public ResponseEntity<PaymentDto.TransactionResponse> getTransaction(@Parameter(description = "거래 ID", required = true) @PathVariable Integer id) {
        return ResponseEntity.ok(new PaymentDto.TransactionResponse(id, 1, 456, 20000, new Timestamp(System.currentTimeMillis()), "tx-1234567890"));
    }

    @GetMapping("/{paymentId}")
    @Operation(summary = "결제 ID로 거래 내역 조회", description = "특정 결제 ID에 대한 거래 내역을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "거래 내역 조회 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentDto.TransactionResponse.class))),
            @ApiResponse(responseCode = "404", description = "결제를 찾을 수 없음")
    })
    public ResponseEntity<List<PaymentDto.TransactionResponse>> getTransactionsByPaymentId(@Parameter(description = "결제 ID", required = true) @PathVariable Integer paymentId) {
        List<PaymentDto.TransactionResponse> transactions = Arrays.asList(
                new PaymentDto.TransactionResponse(1, paymentId, 456, 20000, new Timestamp(System.currentTimeMillis()), "tx-1234567890"),
                new PaymentDto.TransactionResponse(2, paymentId, 789, 30000, new Timestamp(System.currentTimeMillis()), "tx-0987654321")
        );
        return ResponseEntity.ok(transactions);
    }

}