package com.example.api.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "chat_participant")
@Data
@Schema(description = "채팅 참여자 정보")
public class ChatParticipant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "참여자 정보 ID", example = "1")
    private Integer id;

    @Column(name = "chatroom_id", nullable = false)
    @Schema(description = "채팅방 ID", example = "123")
    private Integer chatroomId;

    @Column(name = "store_id", nullable = false)
    @Schema(description = "상점 ID", example = "456")
    private Integer storeId;
}