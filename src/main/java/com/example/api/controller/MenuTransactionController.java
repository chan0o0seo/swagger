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
@RequestMapping("/api/menu-order/menu-transactions")
public class MenuTransactionController {

    @GetMapping
    @Operation(summary = "메뉴 거래 내역 조회", description = "모든 메뉴 거래 내역을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "메뉴 거래 내역 조회 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MenuPaymentDto.MenuTransactionResponse.class)))
    })
    public ResponseEntity<List<MenuPaymentDto.MenuTransactionResponse>> getMenuTransactions() {
        List<MenuPaymentDto.MenuTransactionResponse> transactions = Arrays.asList(
                new MenuPaymentDto.MenuTransactionResponse(1, 123, 1, 20000, new Timestamp(System.currentTimeMillis()), "tx-1234567890")
        );
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/{id}")
    @Operation(summary = "메뉴 거래 상세 조회", description = "특정 메뉴 거래 ID에 대한 상세 정보를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "메뉴 거래 상세 조회 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MenuPaymentDto.MenuTransactionResponse.class))),
            @ApiResponse(responseCode = "404", description = "메뉴 거래를 찾을 수 없음")
    })
    public ResponseEntity<MenuPaymentDto.MenuTransactionResponse> getMenuTransaction(@Parameter(description = "메뉴 거래 ID", required = true) @PathVariable Integer id) {
        return ResponseEntity.ok(new MenuPaymentDto.MenuTransactionResponse(id, 123, 1, 20000, new Timestamp(System.currentTimeMillis()), "tx-1234567890"));
    }

    @GetMapping("/payment/{paymentId}")
    @Operation(summary = "메뉴 결제 ID로 거래 내역 조회", description = "특정 메뉴 결제 ID에 대한 거래 내역을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "메뉴 결제 ID로 거래 내역 조회 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MenuPaymentDto.MenuTransactionResponse.class))),
            @ApiResponse(responseCode = "404", description = "메뉴 결제를 찾을 수 없음")
    })
    public ResponseEntity<List<MenuPaymentDto.MenuTransactionResponse>> getMenuTransactionsByPaymentId(@Parameter(description = "메뉴 결제 ID", required = true) @PathVariable Integer paymentId) {
        List<MenuPaymentDto.MenuTransactionResponse> transactions = Arrays.asList(
                new MenuPaymentDto.MenuTransactionResponse(1, 123, paymentId, 20000, new Timestamp(System.currentTimeMillis()), "tx-1234567890"),
                new MenuPaymentDto.MenuTransactionResponse(2, 456, paymentId, 30000, new Timestamp(System.currentTimeMillis()), "tx-0987654321")
        );
        return ResponseEntity.ok(transactions);
    }
}