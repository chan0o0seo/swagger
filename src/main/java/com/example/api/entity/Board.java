package com.example.api.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "board")
@Data
@Schema(description = "게시판 게시글 정보")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "게시글 ID", example = "1")
    private Integer id;

    @Column(name = "store_id", nullable = false)
    @Schema(description = "상점 ID", example = "123")
    private Integer storeId;

    @Column(name = "title", length = 255)
    @Schema(description = "게시글 제목", example = "게시판 제목")
    private String title;

    @Column(name = "content", columnDefinition = "TEXT")
    @Schema(description = "게시글 내용", example = "게시판 내용")
    private String content;

    @Column(name = "created_at")
    @Schema(description = "게시글 생성 시간", example = "2023-10-27T10:00:00Z")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @Schema(description = "게시글 수정 시간", example = "2023-10-27T10:00:00Z")
    private Timestamp updatedAt;
}