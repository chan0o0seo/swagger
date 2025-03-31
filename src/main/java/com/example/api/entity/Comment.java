package com.example.api.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "comment")
@Data
@Schema(description = "댓글 정보")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "댓글 ID", example = "1")
    private Integer id;

    @Column(name = "board_id", nullable = false)
    @Schema(description = "게시글 ID", example = "123")
    private Integer boardId;

    @Column(name = "store_id", nullable = false)
    @Schema(description = "상점 ID", example = "456")
    private Integer storeId;

    @Column(name = "content", columnDefinition = "TEXT")
    @Schema(description = "댓글 내용", example = "댓글 내용입니다.")
    private String content;

    @Column(name = "created_at")
    @Schema(description = "댓글 생성 시간", example = "2023-10-27T10:00:00Z")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @Schema(description = "댓글 수정 시간", example = "2023-10-27T11:00:00Z")
    private Timestamp updatedAt;
}