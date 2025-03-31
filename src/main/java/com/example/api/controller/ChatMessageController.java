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

@Tag(name = "ChatMessage", description = "채팅방 메시지 관련 API")
@RestController
@RequestMapping("/api/chatrooms/{chatroomId}/messages")
@RequiredArgsConstructor
public class ChatMessageController {

    @Operation(summary = "메시지 전송", description = "특정 채팅방에 메시지를 전송합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 메시지 전송", content = @Content(schema = @Schema(implementation = ChatDto.ChatMessageResponse.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "404", description = "채팅방을 찾을 수 없음", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    @PostMapping("/sendMessage")
    public ResponseEntity<ChatDto.ChatMessageResponse> sendMessage(
            @Parameter(description = "채팅방 ID", required = true) @PathVariable Integer chatroomId,
            @RequestBody ChatDto.ChatMessageRequest request) {
        ChatDto.ChatMessageResponse message = new ChatDto.ChatMessageResponse();
        return ResponseEntity.ok(message);
    }

    @Operation(summary = "메시지 목록 조회", description = "특정 채팅방의 메시지 목록을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 메시지 목록 조회", content = @Content(schema = @Schema(implementation = ChatDto.ChatMessageResponse.class))),
            @ApiResponse(responseCode = "404", description = "채팅방을 찾을 수 없음", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    @GetMapping("/getMessage")
    public ResponseEntity<List<ChatDto.ChatMessageResponse>> getMessages(
            @Parameter(description = "채팅방 ID", required = true) @PathVariable Integer chatroomId) {
        List<ChatDto.ChatMessageResponse> messages = new ArrayList<>();
        return ResponseEntity.ok(messages);
    }
}