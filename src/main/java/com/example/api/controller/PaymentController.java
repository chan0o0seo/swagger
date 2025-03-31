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
@RequestMapping("/api/order/payment")
public class PaymentController {

    @GetMapping("/search")
    @Operation(summary = "결제 목록 조회", description = "모든 결제 목록을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "결제 목록 조회 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentDto.PaymentResponse.class)))
    })
    public ResponseEntity<List<PaymentDto.PaymentResponse>> getPayments() {
        List<PaymentDto.PaymentResponse> payments = Arrays.asList(
                new PaymentDto.PaymentResponse(1, 1, 20000, "CREDIT_CARD", "SUCCESS", new Timestamp(System.currentTimeMillis()))
        );
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/{id}")
    @Operation(summary = "결제 상세 조회", description = "특정 결제 ID에 대한 상세 정보를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "결제 상세 조회 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentDto.PaymentResponse.class))),
            @ApiResponse(responseCode = "404", description = "결제를 찾을 수 없음")
    })
    public ResponseEntity<PaymentDto.PaymentResponse> getPaymentDetails(@Parameter(description = "결제 ID", required = true) @PathVariable Integer id) {
        PaymentDto.PaymentResponse payment = new PaymentDto.PaymentResponse(id, 1, 20000, "CREDIT_CARD", "SUCCESS", new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(payment);
    }

    @PostMapping("/create")
    @Operation(summary = "결제 생성", description = "새로운 결제를 생성합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "결제 생성 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentDto.PaymentResponse.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    public ResponseEntity<PaymentDto.PaymentResponse> createPayment(@RequestBody PaymentDto.PaymentRequest request) {
        return ResponseEntity.ok(new PaymentDto.PaymentResponse(2, request.getOrderId(), request.getAmount(), request.getMethod(), "PENDING", new Timestamp(System.currentTimeMillis())));
    }

    @PutMapping("/{id}/status")
    @Operation(summary = "결제 상태 변경", description = "특정 결제의 상태를 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "결제 상태 변경 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentDto.PaymentResponse.class))),
            @ApiResponse(responseCode = "404", description = "결제를 찾을 수 없음"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    public ResponseEntity<PaymentDto.PaymentResponse> updatePaymentStatus(@Parameter(description = "결제 ID", required = true) @PathVariable Integer id, @Parameter(description = "변경할 결제 상태", required = true) @RequestParam String status) {
        return ResponseEntity.ok(new PaymentDto.PaymentResponse(id, 1, 20000, "CREDIT_CARD", status, new Timestamp(System.currentTimeMillis())));
    }
}