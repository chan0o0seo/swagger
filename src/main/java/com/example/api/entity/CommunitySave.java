package com.example.api.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "community_save")
@Data
@Schema(description = "커뮤니티 게시글 찜 정보")
public class CommunitySave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "찜 ID", example = "1")
    private Integer id;

    @Column(name = "post_id", nullable = false)
    @Schema(description = "게시글 ID", example = "123")
    private Integer postId;

    @Column(name = "store_id", nullable = false)
    @Schema(description = "상점 ID", example = "456")
    private Integer storeId;

    @Column(name = "created_at")
    @Schema(description = "찜 생성 시간", example = "2023-10-27T10:00:00Z")
    private Timestamp createdAt;
}