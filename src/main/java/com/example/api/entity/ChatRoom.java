package com.example.api.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "chat_room")
@Data
@Schema(description = "채팅방 정보")
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "채팅방 ID", example = "1")
    private Integer id;

    @Column(name = "created_at", nullable = false)
    @Schema(description = "채팅방 생성 시간", example = "2023-10-27T10:00:00Z")
    private Timestamp createdAt;

    @Column(name = "last_message", columnDefinition = "TEXT")
    @Schema(description = "마지막 메시지 내용", example = "최근 메시지")
    private String lastMessage;
}