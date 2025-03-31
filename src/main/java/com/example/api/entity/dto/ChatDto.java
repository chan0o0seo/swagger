package com.example.api.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.sql.Timestamp;

public class ChatDto {

    @Schema(description = "채팅방 생성 요청 DTO")
    public static class ChatRoomCreateRequest {
        @Schema(description = "채팅을 시작하는 상점 ID", example = "1")
        private Integer storeId; // 채팅을 시작하는 상점 ID
    }

    @Schema(description = "채팅방 응답 DTO")
    public static class ChatRoomResponse {
        @Schema(description = "채팅방 ID", example = "1")
        private Integer id;
        @Schema(description = "생성 시간", example = "2023-10-27T10:00:00.000+00:00")
        private Timestamp createdAt;
        @Schema(description = "마지막 메시지", example = "안녕하세요!")
        private String lastMessage;
    }

    @Schema(description = "채팅 메시지 요청 DTO")
    public static class ChatMessageRequest {
        @Schema(description = "메시지를 보내는 상점 ID", example = "1")
        private Integer storeId;
        @Schema(description = "메시지 내용", example = "안녕하세요!")
        private String message;
    }

    @Schema(description = "채팅 메시지 응답 DTO")
    public static class ChatMessageResponse {
        @Schema(description = "메시지 ID", example = "1")
        private Integer id;
        @Schema(description = "채팅방 ID", example = "1")
        private Integer chatroomId;
        @Schema(description = "메시지를 보낸 상점 ID", example = "1")
        private Integer storeId;
        @Schema(description = "메시지 내용", example = "안녕하세요!")
        private String message;
        @Schema(description = "전송 시간", example = "2023-10-27T10:00:00.000+00:00")
        private Timestamp sendAt;
    }

    @Schema(description = "채팅방 참여자 응답 DTO")
    public static class ChatParticipantResponse {
        @Schema(description = "참여자 ID", example = "1")
        private Integer id;
        @Schema(description = "채팅방 ID", example = "1")
        private Integer chatroomId;
        @Schema(description = "상점 ID", example = "1")
        private Integer storeId;
    }
}