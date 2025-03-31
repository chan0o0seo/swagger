package com.example.api.controller;

import com.example.api.entity.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "User", description = "사용자 API")
public class UserController {


    @GetMapping("/user")
    @Operation(summary = "사용자 조회")
    public ResponseEntity<User> getUser() {
        User user = new User();
        return ResponseEntity.ok(user);
    }

    @GetMapping("/chatmessage")
    @Operation(summary = "채팅 메시지 조회")
    public ResponseEntity<ChatMessage> getChatMessage() {
        ChatMessage chatMessage = new ChatMessage();
        return ResponseEntity.ok(chatMessage);
    }
    @GetMapping("/chatparticipant")
    @Operation(summary = "채팅 참여자 조회")
    public ResponseEntity<ChatParticipant> getChatParticipant() {
        ChatParticipant chatParticipant = new ChatParticipant();
        return ResponseEntity.ok(chatParticipant);
    }
    @GetMapping("/chatroom")
    @Operation(summary = "채팅방 조회")
    public ResponseEntity<ChatRoom> getChatRoom() {
        ChatRoom chatRoom = new ChatRoom();
        return ResponseEntity.ok(chatRoom);
    }
    @GetMapping("/comment")
    @Operation(summary = "댓글 조회")
    public ResponseEntity<Comment> getComment() {
        Comment comment = new Comment();
        return ResponseEntity.ok(comment);
    }

    @GetMapping("/aingredient")
    @Operation(summary = "재료 조회")
    public ResponseEntity<Ingredient> getIngredient() {
        Ingredient ingredient = new Ingredient();
        return ResponseEntity.ok(ingredient);
    }

    @GetMapping("/inventoryexchange")
    @Operation(summary = "재고 교환 조회")
    public ResponseEntity<InventoryExchange> getInventoryExchange() {
        InventoryExchange inventoryExchange = new InventoryExchange();
        return ResponseEntity.ok(inventoryExchange);
    }
    @GetMapping("/menu")
    @Operation(summary = "메뉴 조회")
    public ResponseEntity<Menu> getMenu() {
        Menu menu = new Menu();
        return ResponseEntity.ok(menu);
    }
    @GetMapping("/menuorder")
    @Operation(summary = "메뉴 주문 조회")
    public ResponseEntity<MenuOrder> getMenuOrder() {
        MenuOrder menuOrder = new MenuOrder();
        return ResponseEntity.ok(menuOrder);
    }
    @GetMapping("/menuorderitem")
    @Operation(summary = "메뉴 주문 아이템 조회")
    public ResponseEntity<MenuOrderItem> getMenuOrderItem() {
        MenuOrderItem menuOrderItem = new MenuOrderItem();
        return ResponseEntity.ok(menuOrderItem);
    }
    @GetMapping("/menupayment")
    @Operation(summary = "메뉴 결제 조회")
    public ResponseEntity<MenuPayment> getMenuPayment() {
        MenuPayment menuPayment = new MenuPayment();
        return ResponseEntity.ok(menuPayment);
    }
    @GetMapping("/menutransaction")
    @Operation(summary = "메뉴 거래 조회")
    public ResponseEntity<MenuTransaction> getMenuTransaction() {
        MenuTransaction menuTransaction = new MenuTransaction();
        return ResponseEntity.ok(menuTransaction);
    }
    @GetMapping("/order")
    @Operation(summary = "주문 조회")
    public ResponseEntity<Order> getOrder() {
        Order order = new Order();
        return ResponseEntity.ok(order);
    }
    @GetMapping("/orderitem")
    @Operation(summary = "주문 아이템 조회")
    public ResponseEntity<OrderItem> getOrderItem() {
        OrderItem orderItem = new OrderItem();
        return ResponseEntity.ok(orderItem);
    }
    @GetMapping("/payment")
    @Operation(summary = "결제 조회")
    public ResponseEntity<Payment> getPayment() {
        Payment payment = new Payment();
        return ResponseEntity.ok(payment);
    }
    @GetMapping("/recipe")
    @Operation(summary = "레시피 조회")
    public ResponseEntity<Recipe> getRecipe() {
        Recipe recipe = new Recipe();
        return ResponseEntity.ok(recipe);
    }
    @GetMapping("/store")
    @Operation(summary = "상점 조회")
    public ResponseEntity<Store> getStore() {
        Store store = new Store();
        return ResponseEntity.ok(store);
    }
    @GetMapping("/transaction")
    @Operation(summary = "거래 조회")
    public ResponseEntity<Transaction> getTransaction() {
        Transaction transaction = new Transaction();
        return ResponseEntity.ok(transaction);
    }
}