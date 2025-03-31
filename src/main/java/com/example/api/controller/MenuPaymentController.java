package com.example.api.controller;

import com.example.api.entity.dto.MenuPaymentDto;
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
@RequestMapping("/menu-payments")
public class MenuPaymentController {

    @GetMapping
    @Operation(summary = "메뉴 결제 목록 조회", description = "모든 메뉴 결제 목록을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "메뉴 결제 목록 조회 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MenuPaymentDto.MenuPaymentResponse.class)))
    })
    public ResponseEntity<List<MenuPaymentDto.MenuPaymentResponse>> getMenuPayments() {
        List<MenuPaymentDto.MenuPaymentResponse> payments = Arrays.asList(
                new MenuPaymentDto.MenuPaymentResponse(1, 1, 20000, "CREDIT_CARD", "SUCCESS", new Timestamp(System.currentTimeMillis()))
        );
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/{id}")
    @Operation(summary = "메뉴 결제 상세 조회", description = "특정 메뉴 결제 ID에 대한 상세 정보를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "메뉴 결제 상세 조회 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MenuPaymentDto.MenuPaymentResponse.class))),
            @ApiResponse(responseCode = "404", description = "메뉴 결제를 찾을 수 없음")
    })
    public ResponseEntity<MenuPaymentDto.MenuPaymentResponse> getMenuPaymentDetails(@Parameter(description = "메뉴 결제 ID", required = true) @PathVariable Integer id) {
        return ResponseEntity.ok(new MenuPaymentDto.MenuPaymentResponse(id, 1, 20000, "CREDIT_CARD", "SUCCESS", new Timestamp(System.currentTimeMillis())));
    }

    @PostMapping
    @Operation(summary = "메뉴 결제 생성", description = "새로운 메뉴 결제를 생성합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "메뉴 결제 생성 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MenuPaymentDto.MenuPaymentResponse.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    public ResponseEntity<MenuPaymentDto.MenuPaymentResponse> createMenuPayment(@RequestBody MenuPaymentDto.MenuPaymentRequest request) {
        return ResponseEntity.ok(new MenuPaymentDto.MenuPaymentResponse(2, request.getMenuOrderId(), request.getAmount(), request.getMethod(), "PENDING", new Timestamp(System.currentTimeMillis())));
    }

    @PutMapping("/{id}/status")
    @Operation(summary = "메뉴 결제 상태 변경", description = "특정 메뉴 결제의 상태를 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "메뉴 결제 상태 변경 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MenuPaymentDto.MenuPaymentResponse.class))),
            @ApiResponse(responseCode = "404", description = "메뉴 결제를 찾을 수 없음"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    public ResponseEntity<MenuPaymentDto.MenuPaymentResponse> updateMenuPaymentStatus(@Parameter(description = "메뉴 결제 ID", required = true) @PathVariable Integer id, @Parameter(description = "변경할 메뉴 결제 상태", required = true) @RequestParam String status) {
        return ResponseEntity.ok(new MenuPaymentDto.MenuPaymentResponse(id, 1, 20000, "CREDIT_CARD", status, new Timestamp(System.currentTimeMillis())));
    }

    @GetMapping("/{id}/transactions")
    @Operation(summary = "메뉴 결제 거래 목록 조회", description = "특정 메뉴 결제에 대한 거래 목록을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "메뉴 결제 거래 목록 조회 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MenuPaymentDto.MenuTransactionResponse.class))),
            @ApiResponse(responseCode = "404", description = "메뉴 결제를 찾을 수 없음")
    })
    public ResponseEntity<List<MenuPaymentDto.MenuTransactionResponse>> getMenuPaymentTransactions(@Parameter(description = "메뉴 결제 ID", required = true) @PathVariable Integer id) {
        List<MenuPaymentDto.MenuTransactionResponse> transactions = Arrays.asList(
                new MenuPaymentDto.MenuTransactionResponse(1, 123, id, 10000, new Timestamp(System.currentTimeMillis()), "TXN123"),
                new MenuPaymentDto.MenuTransactionResponse(2, 456, id, 10000, new Timestamp(System.currentTimeMillis()), "TXN456")
        );
        return ResponseEntity.ok(transactions);
    }
}