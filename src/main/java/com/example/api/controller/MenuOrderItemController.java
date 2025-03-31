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
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/menu-order/{menuOrderId}/items")
public class MenuOrderItemController {

    @GetMapping
    @Operation(summary = "메뉴 주문 아이템 목록 조회", description = "특정 메뉴 주문에 포함된 아이템 목록을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "메뉴 주문 아이템 목록 조회 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MenuPaymentDto.MenuOrderItemResponse.class))),
            @ApiResponse(responseCode = "404", description = "메뉴 주문을 찾을 수 없음")
    })
    public ResponseEntity<List<MenuPaymentDto.MenuOrderItemResponse>> getMenuOrderItems(@Parameter(description = "메뉴 주문 ID", required = true) @PathVariable Integer menuOrderId) {
        List<MenuPaymentDto.MenuOrderItemResponse> items = Arrays.asList(
                new MenuPaymentDto.MenuOrderItemResponse(1, menuOrderId, 1, 2, 1000),
                new MenuPaymentDto.MenuOrderItemResponse(2, menuOrderId, 2, 1, 2000)
        );
        return ResponseEntity.ok(items);
    }

    @PostMapping
    @Operation(summary = "메뉴 주문 아이템 추가", description = "특정 메뉴 주문에 아이템을 추가합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "메뉴 주문 아이템 추가 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MenuPaymentDto.MenuOrderItemResponse.class))),
            @ApiResponse(responseCode = "404", description = "메뉴 주문을 찾을 수 없음"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    public ResponseEntity<MenuPaymentDto.MenuOrderItemResponse> addMenuOrderItem(@Parameter(description = "메뉴 주문 ID", required = true) @PathVariable Integer menuOrderId, @RequestBody MenuPaymentDto.MenuOrderItemRequest request) {
        MenuPaymentDto.MenuOrderItemResponse response = new MenuPaymentDto.MenuOrderItemResponse(3, menuOrderId, request.getMenuId(), request.getQuantity(), request.getQuantity() * 1000);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{itemId}")
    @Operation(summary = "메뉴 주문 아이템 수정", description = "특정 메뉴 주문의 특정 아이템을 수정합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "메뉴 주문 아이템 수정 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MenuPaymentDto.MenuOrderItemResponse.class))),
            @ApiResponse(responseCode = "404", description = "메뉴 주문 또는 아이템을 찾을 수 없음"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    public ResponseEntity<MenuPaymentDto.MenuOrderItemResponse> updateMenuOrderItem(@Parameter(description = "메뉴 주문 ID", required = true) @PathVariable Integer menuOrderId, @Parameter(description = "아이템 ID", required = true) @PathVariable Integer itemId, @RequestBody MenuPaymentDto.MenuOrderItemRequest request) {
        MenuPaymentDto.MenuOrderItemResponse response = new MenuPaymentDto.MenuOrderItemResponse(itemId, menuOrderId, request.getMenuId(), request.getQuantity(), request.getQuantity() * 1000);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{itemId}")
    @Operation(summary = "메뉴 주문 아이템 삭제", description = "특정 메뉴 주문의 특정 아이템을 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "메뉴 주문 아이템 삭제 성공"),
            @ApiResponse(responseCode = "404", description = "메뉴 주문 또는 아이템을 찾을 수 없음")
    })
    public ResponseEntity<Void> deleteMenuOrderItem(@Parameter(description = "메뉴 주문 ID", required = true) @PathVariable Integer menuOrderId, @Parameter(description = "아이템 ID", required = true) @PathVariable Integer itemId) {
        return ResponseEntity.noContent().build();
    }
}