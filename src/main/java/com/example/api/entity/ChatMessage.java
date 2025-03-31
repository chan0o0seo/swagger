package com.example.api.entity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "chat_message")
@Data
@Schema(description = "채팅 메시지 정보")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "메시지 ID", example = "1")
    private Integer id;

    @Column(name = "chatroom_id", nullable = false)
    @Schema(description = "채팅방 ID", example = "123")
    private Integer chatroomId;

    @Column(name = "store_id", nullable = false)
    @Schema(description = "상점 ID", example = "456")
    private Integer storeId;

    @Column(name = "message", nullable = false, columnDefinition = "TEXT")
    @Schema(description = "메시지 내용", example = "안녕하세요!")
    private String message;

    @Column(name = "send_at", nullable = false)
    @Schema(description = "메시지 전송 시간", example = "2023-10-27T10:00:00Z")
    private Timestamp sendAt;
}