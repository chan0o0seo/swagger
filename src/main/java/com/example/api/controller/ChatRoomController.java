package com.example.api.controller;

import com.example.api.entity.dto.ChatDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "ChatRoom", description = "채팅방 관련 API")
@RestController
@RequestMapping("/api/chatrooms")
@RequiredArgsConstructor
public class ChatRoomController {

    @Operation(summary = "채팅방 생성", description = "새로운 채팅방을 생성합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 채팅방 생성", content = @Content(schema = @Schema(implementation = ChatDto.ChatRoomResponse.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    @PostMapping("/create")
    public ResponseEntity<ChatDto.ChatRoomResponse> createChatRoom(@RequestBody ChatDto.ChatRoomCreateRequest request) {
        ChatDto.ChatRoomResponse chatRoom = new ChatDto.ChatRoomResponse();
        return ResponseEntity.ok(chatRoom);
    }

    @Operation(summary = "채팅방 목록 조회", description = "모든 채팅방 목록을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 채팅방 목록 조회", content = @Content(schema = @Schema(implementation = ChatDto.ChatRoomResponse.class))),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    @GetMapping("/getRooms")
    public ResponseEntity<List<ChatDto.ChatRoomResponse>> getChatRooms() {
        List<ChatDto.ChatRoomResponse> chatRooms = new ArrayList<>();
        return ResponseEntity.ok(chatRooms);
    }

    @Operation(summary = "특정 채팅방 조회", description = "ID로 특정 채팅방을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 채팅방 조회", content = @Content(schema = @Schema(implementation = ChatDto.ChatRoomResponse.class))),
            @ApiResponse(responseCode = "404", description = "채팅방을 찾을 수 없음", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<ChatDto.ChatRoomResponse> getChatRoom(@Parameter(description = "채팅방 ID", required = true) @PathVariable Integer id) {
        ChatDto.ChatRoomResponse chatRoom = new ChatDto.ChatRoomResponse();
        return ResponseEntity.ok(chatRoom);
    }

    @Operation(summary = "채팅방 삭제", description = "ID로 특정 채팅방을 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "성공적으로 채팅방 삭제"),
            @ApiResponse(responseCode = "404", description = "채팅방을 찾을 수 없음", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChatRoom(@Parameter(description = "채팅방 ID", required = true) @PathVariable Integer id) {
        return ResponseEntity.noContent().build();
    }
}