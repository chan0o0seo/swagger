package com.example.api.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.List;

public class MenuPaymentDto {

    @AllArgsConstructor
    @Schema(description = "메뉴 주문 응답 DTO")
    public static class MenuOrderResponse {
        @Schema(description = "메뉴 주문 ID")
        private Integer id;
        @Schema(description = "상점 ID")
        private Integer storeId;
        @Schema(description = "고객 ID")
        private Integer customerId;
        @Schema(description = "총 금액")
        private Integer totalAmount;
        @Schema(description = "주문 상태")
        private String status;
        @Schema(description = "주문 생성 일시")
        private Timestamp createdAt;
        @Schema(description = "메뉴 주문 아이템 목록")
        private List<MenuOrderItemResponse> items;
    }

    @Getter
    @Schema(description = "메뉴 주문 생성 요청 DTO")
    public static class MenuOrderRequest {
        @Schema(description = "상점 ID")
        private Integer storeId;
        @Schema(description = "고객 ID")
        private Integer customerId;
        @Schema(description = "메뉴 주문 아이템 목록")
        private List<MenuOrderItemRequest> items;
    }

    @AllArgsConstructor
    @Schema(description = "메뉴 주문 아이템 응답 DTO")
    public static class MenuOrderItemResponse {
        @Schema(description = "메뉴 주문 아이템 ID")
        private Integer id;
        @Schema(description = "메뉴 주문 ID")
        private Integer menuOrderId;
        @Schema(description = "메뉴 ID")
        private Integer menuId;
        @Schema(description = "수량")
        private Integer quantity;
        @Schema(description = "총 가격")
        private Integer totalPrice;
    }

    @Getter
    @Schema(description = "메뉴 주문 아이템 요청 DTO")
    public static class MenuOrderItemRequest {
        @Schema(description = "메뉴 ID")
        private Integer menuId;
        @Schema(description = "수량")
        private Integer quantity;
    }

    @AllArgsConstructor
    @Schema(description = "메뉴 결제 응답 DTO")
    public static class MenuPaymentResponse {
        @Schema(description = "메뉴 결제 ID")
        private Integer id;
        @Schema(description = "메뉴 주문 ID")
        private Integer menuOrderId;
        @Schema(description = "결제 금액")
        private Integer amount;
        @Schema(description = "결제 방법")
        private String method;
        @Schema(description = "결제 상태")
        private String status;
        @Schema(description = "결제 일시")
        private Timestamp paymentDate;
    }

    @Getter
    @Schema(description = "메뉴 결제 요청 DTO")
    public static class MenuPaymentRequest {
        @Schema(description = "메뉴 주문 ID")
        private Integer menuOrderId;
        @Schema(description = "결제 금액")
        private Integer amount;
        @Schema(description = "결제 방법")
        private String method;
    }

    @AllArgsConstructor
    @Schema(description = "메뉴 거래 응답 DTO")
    public static class MenuTransactionResponse {
        @Schema(description = "메뉴 거래 ID")
        private Integer id;
        @Schema(description = "상점 ID")
        private Integer storeId;
        @Schema(description = "메뉴 결제 ID")
        private Integer menuPaymentId;
        @Schema(description = "거래 금액")
        private Integer amount;
        @Schema(description = "거래 일시")
        private Timestamp transactionDate;
        @Schema(description = "거래 번호")
        private String transactionId;
    }

    @Getter
    @Schema(description = "메뉴 주문 아이템 추가 요청 DTO")
    public static class AddMenuOrderItemRequest {
        @Schema(description = "추가할 메뉴 주문 아이템 정보")
        private MenuOrderItemRequest item;
    }

    @Getter
    @Schema(description = "메뉴 주문 아이템 수정 요청 DTO")
    public static class UpdateMenuOrderItemRequest {
        @Schema(description = "수정할 메뉴 주문 아이템 ID")
        private Integer itemId;
        @Schema(description = "수정할 메뉴 주문 아이템 정보")
        private MenuOrderItemRequest item;
    }

    @Getter
    @Schema(description = "메뉴 주문 아이템 삭제 요청 DTO")
    public static class DeleteMenuOrderItemRequest {
        @Schema(description = "삭제할 메뉴 주문 아이템 ID")
        private Integer itemId;
    }
}