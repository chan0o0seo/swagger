package com.example.api.controller;

import com.example.api.entity.dto.MenuPaymentDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/menu-order")
public class MenuOrderController {

    @GetMapping("/search")
    @Operation(summary = "메뉴 주문 목록 조회")
    public ResponseEntity<List<MenuPaymentDto.MenuOrderResponse>> getMenuOrders() {
        List<MenuPaymentDto.MenuOrderResponse> orders = Arrays.asList(
                new MenuPaymentDto.MenuOrderResponse(1, 123, 456, 20000, "PENDING", new Timestamp(System.currentTimeMillis()), null)
        );
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    @Operation(summary = "메뉴 주문 상세 조회")
    public ResponseEntity<MenuPaymentDto.MenuOrderResponse> getMenuOrderDetails(@PathVariable Integer id) {
        return ResponseEntity.ok(new MenuPaymentDto.MenuOrderResponse(id, 123, 456, 20000, "PENDING", new Timestamp(System.currentTimeMillis()), null));
    }

    @PostMapping("/create")
    @Operation(summary = "메뉴 주문 생성")
    public ResponseEntity<MenuPaymentDto.MenuOrderResponse> createMenuOrder(@RequestBody MenuPaymentDto.MenuOrderRequest request) {
        return ResponseEntity.ok(new MenuPaymentDto.MenuOrderResponse(2, request.getStoreId(), request.getCustomerId(), 15000, "PENDING", new Timestamp(System.currentTimeMillis()), null));
    }

    @PutMapping("/{id}/status")
    @Operation(summary = "메뉴 주문 상태 변경")
    public ResponseEntity<MenuPaymentDto.MenuOrderResponse> updateMenuOrderStatus(@PathVariable Integer id, @RequestParam String status) {
        return ResponseEntity.ok(new MenuPaymentDto.MenuOrderResponse(id, 123, 456, 20000, status, new Timestamp(System.currentTimeMillis()), null));
    }
}