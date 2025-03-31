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
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/order/{orderId}/items")
public class OrderItemController {

    @PostMapping
    @Operation(summary = "주문 아이템 추가", description = "특정 주문에 아이템을 추가합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "주문 아이템 추가 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentDto.OrderItemResponse.class))),
            @ApiResponse(responseCode = "404", description = "주문을 찾을 수 없음"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    public ResponseEntity<PaymentDto.OrderItemResponse> addOrderItem(@Parameter(description = "주문 ID", required = true) @PathVariable Integer orderId, @RequestBody PaymentDto.AddOrderItemRequest request) {
        PaymentDto.OrderItemResponse response = new PaymentDto.OrderItemResponse(1, orderId, request.getOrderItem().getIngredientId(), request.getOrderItem().getQuantity(), request.getOrderItem().getPrice(), request.getOrderItem().getQuantity() * request.getOrderItem().getPrice());
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{itemId}")
    @Operation(summary = "주문 아이템 수정", description = "특정 주문의 특정 아이템을 수정합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "주문 아이템 수정 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentDto.OrderItemResponse.class))),
            @ApiResponse(responseCode = "404", description = "주문 또는 아이템을 찾을 수 없음"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    public ResponseEntity<PaymentDto.OrderItemResponse> updateOrderItem(@Parameter(description = "주문 ID", required = true) @PathVariable Integer orderId, @Parameter(description = "아이템 ID", required = true) @PathVariable Integer itemId, @RequestBody PaymentDto.UpdateOrderItemRequest request) {
        PaymentDto.OrderItemResponse response = new PaymentDto.OrderItemResponse(itemId, orderId, request.getOrderItem().getIngredientId(), request.getOrderItem().getQuantity(), request.getOrderItem().getPrice(), request.getOrderItem().getQuantity() * request.getOrderItem().getPrice());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{itemId}")
    @Operation(summary = "주문 아이템 삭제", description = "특정 주문의 특정 아이템을 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "주문 아이템 삭제 성공"),
            @ApiResponse(responseCode = "404", description = "주문 또는 아이템을 찾을 수 없음")
    })
    public ResponseEntity<Void> deleteOrderItem(@Parameter(description = "주문 ID", required = true) @PathVariable Integer orderId, @Parameter(description = "아이템 ID", required = true) @PathVariable Integer itemId) {
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @Operation(summary = "주문별 아이템 조회", description = "특정 주문에 포함된 아이템 목록을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "주문 아이템 목록 조회 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentDto.OrderItemResponse.class))),
            @ApiResponse(responseCode = "404", description = "주문을 찾을 수 없음")
    })
    public ResponseEntity<List<PaymentDto.OrderItemResponse>> getOrderItems(@Parameter(description = "주문 ID", required = true) @PathVariable Integer orderId) {
        List<PaymentDto.OrderItemResponse> items = Arrays.asList(
                new PaymentDto.OrderItemResponse(1, orderId, 1, 2, 1000, 2000),
                new PaymentDto.OrderItemResponse(2, orderId, 2, 1, 2000, 2000)
        );
        return ResponseEntity.ok(items);
    }
}