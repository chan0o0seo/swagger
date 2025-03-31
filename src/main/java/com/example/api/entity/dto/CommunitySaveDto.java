package com.example.api.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class CommunitySaveDto {
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Schema(description = "내가 찜한 게시글 응답 DTO")
    public static class MyCommunitySaveResponse {
        @Schema(description = "게시글 ID", example = "1")
        private Integer idx;
        @Schema(description = "재료 ID", example = "2025-03-31")
        private String created_at;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Schema(description = "게시글 찜 개수 응답 DTO")
    public static class CountResponse {
        @Schema(description = "찜 개수", example = "1")
        private Integer count;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Schema(description = "내가 찜한 게시글 리스트 응답 DTO")
    public static class MyCommunitySaveResponseList{
        @Schema(description = "내가 찜한 게시글 리스트")
        List<MyCommunitySaveResponse> myCommunitySaveResponse;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Schema(description = "게시글 찜 요청 DTO")
    public static class PutCommunitySaveResponse{
        @Schema(description = "찜 ID", example = "1")
        private Integer idx;
    }


}
