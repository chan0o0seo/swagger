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

@Tag(name = "ChatParticipant", description = "채팅방 참여자 관련 API")
@RestController
@RequestMapping("/api/chatrooms/{chatroomId}/participants")
@RequiredArgsConstructor
public class ChatParticipantController {

    @Operation(summary = "채팅방 참여자 목록 조회", description = "특정 채팅방의 참여자 목록을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 참여자 목록 조회", content = @Content(schema = @Schema(implementation = ChatDto.ChatParticipantResponse.class))),
            @ApiResponse(responseCode = "404", description = "채팅방을 찾을 수 없음", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<ChatDto.ChatParticipantResponse>> getParticipants(
            @Parameter(description = "채팅방 ID", required = true) @PathVariable Integer chatroomId) {
        List<ChatDto.ChatParticipantResponse> participants = new ArrayList<>();
        return ResponseEntity.ok(participants);
    }

    @Operation(summary = "채팅방 참여자 추가", description = "특정 채팅방에 참여자를 추가합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 참여자 추가", content = @Content(schema = @Schema(implementation = ChatDto.ChatParticipantResponse.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "404", description = "채팅방을 찾을 수 없음", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    @PostMapping("/add")
    public ResponseEntity<ChatDto.ChatParticipantResponse> addParticipant(
            @Parameter(description = "채팅방 ID", required = true) @PathVariable Integer chatroomId,
            @RequestBody ChatDto.ChatParticipantResponse request) {
        ChatDto.ChatParticipantResponse participant = new ChatDto.ChatParticipantResponse();
        return ResponseEntity.ok(participant);
    }

    @Operation(summary = "채팅방 참여자 삭제", description = "특정 채팅방에서 특정 참여자를 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "성공적으로 참여자 삭제"),
            @ApiResponse(responseCode = "404", description = "채팅방 또는 참여자를 찾을 수 없음", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    @DeleteMapping("/{storeId}")
    public ResponseEntity<Void> removeParticipant(
            @Parameter(description = "채팅방 ID", required = true) @PathVariable Integer chatroomId,
            @Parameter(description = "삭제할 참여자 ID (storeId)", required = true) @PathVariable Integer storeId) {
        return ResponseEntity.noContent().build();
    }
}