package com.example.api.entity.dto;

import com.example.api.entity.Comment;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class BoardDto {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Schema(description = "게시글 상세 응답 DTO")
    public static class BoardDetailResponse {
        @Schema(description = "게시글 ID", example = "1")
        private Integer idx;
        @Schema(description = "게시글 제목", example = "제목01")
        private String title; //게시판 제목
        @Schema(description = "게시글 내용", example = "내용01")
        private String content; //게시판 내용
        @Schema(description = "게시글 작성 날짜", example = "2024-03-18")
        private String created_at;
        @Schema(description = "게시글 수정 날짜", example = "2024-06-18")
        private String updated_at;
        @Schema(description = "댓글 리스트")
        private List<Comment> comments; //댓글
        @Schema(description = "재료 정보")
        private InventoryDto.BoardResponse boardResponse; // 재료 정보

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Schema(description = "게시글 요약 응답 DTO")
    public static class BoardResponse {
        @Schema(description = "게시글 ID", example = "1")
        private Integer idx;
        @Schema(description = "게시글 제목", example = "제목01")
        private String title; //게시판 제목
        @Schema(description = "게시글 작성 날짜", example = "2024-03-18")
        private String created_at;
        @Schema(description = "게시글 수정 날짜", example = "2024-06-18")
        private String updated_at;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Schema(description = "게시글 요약 리스트 응답 DTO")
    public static class BoardResponseList {
        @Schema(description = "게시글 요약 리스트")
        List<BoardResponse> boardResponseList = new ArrayList<>();
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Schema(description = "게시글 등록 요청 DTO")
    public static class BoardRequest{
        @Schema(description = "게시글 제목", example = "제목01")
        private String title;
        @Schema(description = "게시글 내용", example = "내용01")
        private String content;
        @Schema(description = "판매 목록")
        private InventoryDto.BoardRequest boardRequest;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Schema(description = "게시글 등록 응답 DTO")
    public static class BoardRequestResponse {
        @Schema(description = "게시글 ID", example = "1")
        private Integer idx;
    } // 게시글 등록 요청에 대한 응답

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Schema(description = "게시글 삭제 응답 DTO")
    public static class BoardDelteResponse {
        @Schema(description = "삭제요청 결과", example = "1")
        private boolean isDeleted;
    } // 게시글 삭제 요청에 대한 응답

}
