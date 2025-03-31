package com.example.api.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.List;

public class PaymentDto {

    @Schema(description = "주문 응답 DTO")
    @AllArgsConstructor
    public static class OrderResponse {
        @Schema(description = "주문 ID")
        private Integer id;
        @Schema(description = "상점 ID")
        private Integer storeId;
        @Schema(description = "총 금액")
        private Integer totalAmount;
        @Schema(description = "주문 상태")
        private String status;
        @Schema(description = "주문 생성 일시")
        private Timestamp createdAt;
        @Schema(description = "판매자 상점 ID")
        private Integer sellerStoreId;
        @Schema(description = "구매자 상점 ID")
        private Integer buyerStoreId;
        @Schema(description = "주문 아이템 목록")
        private List<OrderItemResponse> items;
    }

    @Schema(description = "주문 생성 요청 DTO")
    @Getter
    public static class OrderRequest {
        @Schema(description = "판매자 상점 ID")
        private Integer sellerStoreId;
        @Schema(description = "구매자 상점 ID")
        private Integer buyerStoreId;
        @Schema(description = "주문 아이템 목록")
        private List<OrderItemRequest> items;
    }

    @Schema(description = "주문 아이템 응답 DTO")
    @AllArgsConstructor
    public static class OrderItemResponse {
        @Schema(description = "주문 아이템 ID")
        private Integer id;
        @Schema(description = "주문 ID")
        private Integer orderId;
        @Schema(description = "재료 ID")
        private Integer ingredientId;
        @Schema(description = "수량")
        private Integer quantity;
        @Schema(description = "가격")
        private Integer price;
        @Schema(description = "총 가격")
        private Integer totalPrice;
    }

    @Schema(description = "주문 아이템 요청 DTO")
    @Getter
    public static class OrderItemRequest {
        @Schema(description = "재료 ID")
        private Integer ingredientId;
        @Schema(description = "수량")
        private Integer quantity;
        @Schema(description = "가격")
        private Integer price;
    }

    @Schema(description = "결제 응답 DTO")
    @AllArgsConstructor
    public static class PaymentResponse {
        @Schema(description = "결제 ID")
        private Integer id;
        @Schema(description = "주문 ID")
        private Integer orderId;
        @Schema(description = "결제 금액")
        private Integer amount;
        @Schema(description = "결제 방법")
        private String method;
        @Schema(description = "결제 상태")
        private String status;
        @Schema(description = "결제 일시")
        private Timestamp paymentDate;
    }

    @Schema(description = "결제 요청 DTO")
    @Getter
    public static class PaymentRequest {
        @Schema(description = "주문 ID")
        private Integer orderId;
        @Schema(description = "결제 금액")
        private Integer amount;
        @Schema(description = "결제 방법")
        private String method;
    }

    @Schema(description = "거래 응답 DTO")
    @AllArgsConstructor
    public static class TransactionResponse {
        @Schema(description = "거래 ID")
        private Integer id;
        @Schema(description = "결제 ID")
        private Integer paymentId;
        @Schema(description = "상점 ID")
        private Integer storeId;
        @Schema(description = "거래 금액")
        private Integer amount;
        @Schema(description = "거래 일시")
        private Timestamp transactionDate;
        @Schema(description = "거래 번호")
        private String transactionId;
    }

    @Schema(description = "주문 아이템 추가 요청 DTO")
    @Getter
    public static class AddOrderItemRequest {
        @Schema(description = "주문 ID")
        private Integer orderId;
        @Schema(description = "주문 아이템 정보")
        private OrderItemRequest orderItem;
    }

    @Schema(description = "주문 아이템 수정 요청 DTO")
    @Getter
    public static class UpdateOrderItemRequest {
        @Schema(description = "주문 ID")
        private Integer orderId;
        @Schema(description = "주문 아이템 ID")
        private Integer itemId;
        @Schema(description = "수정할 주문 아이템 정보")
        private OrderItemRequest orderItem;
    }

    @Schema(description = "주문 아이템 삭제 요청 DTO")
    @Getter
    public static class DeleteOrderItemRequest {
        @Schema(description = "주문 ID")
        private Integer orderId;
        @Schema(description = "주문 아이템 ID")
        private Integer itemId;
    }
}