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
@RequestMapping("/api/order")
public class OrderController {

    @GetMapping("/search")
    @Operation(summary = "주문 목록 조회", description = "모든 주문 목록을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "주문 목록 조회 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentDto.OrderResponse.class)))
    })
    public ResponseEntity<List<PaymentDto.OrderResponse>> getOrders() {
        List<PaymentDto.OrderResponse> orders = Arrays.asList(
                new PaymentDto.OrderResponse(1, 123, 20000, "PENDING", new Timestamp(System.currentTimeMillis()), 456, 789, null)
        );
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    @Operation(summary = "주문 상세 조회", description = "특정 주문 ID에 대한 상세 정보를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "주문 상세 조회 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentDto.OrderResponse.class))),
            @ApiResponse(responseCode = "404", description = "주문을 찾을 수 없음")
    })
    public ResponseEntity<PaymentDto.OrderResponse> getOrderDetails(@Parameter(description = "주문 ID", required = true) @PathVariable Integer id) {
        PaymentDto.OrderResponse order = new PaymentDto.OrderResponse(id, 123, 20000, "PENDING", new Timestamp(System.currentTimeMillis()), 456, 789, null);
        return ResponseEntity.ok(order);
    }

    @PostMapping("/create")
    @Operation(summary = "주문 생성", description = "새로운 주문을 생성합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "주문 생성 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentDto.OrderResponse.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    public ResponseEntity<PaymentDto.OrderResponse> createOrder(@RequestBody PaymentDto.OrderRequest request) {
        PaymentDto.OrderResponse response = new PaymentDto.OrderResponse(1, 123, 20000, "PENDING", new Timestamp(System.currentTimeMillis()), request.getSellerStoreId(), request.getBuyerStoreId(), null);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/status")
    @Operation(summary = "주문 상태 변경", description = "특정 주문의 상태를 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "주문 상태 변경 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentDto.OrderResponse.class))),
            @ApiResponse(responseCode = "404", description = "주문을 찾을 수 없음"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    public ResponseEntity<PaymentDto.OrderResponse> updateOrderStatus(@Parameter(description = "주문 ID", required = true) @PathVariable Integer id, @Parameter(description = "변경할 주문 상태", required = true) @RequestParam String status) {
        return ResponseEntity.ok(new PaymentDto.OrderResponse(id, 123, 20000, status, new Timestamp(System.currentTimeMillis()), 456, 789, null));
    }
}