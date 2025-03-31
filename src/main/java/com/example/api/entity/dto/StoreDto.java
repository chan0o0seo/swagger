package com.example.api.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class StoreDto {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Schema(description = "상점 생성 및 수정 요청 DTO")
    public static class StoreRequestDto {

        @Schema(description = "사용자 ID", example = "123", required = true)
        private Integer userId;

        @Schema(description = "상점 이름", example = "맛있는 식당", required = true)
        private String name;

        @Schema(description = "상점 주소", example = "서울시 강남구 역삼동", required = true)
        private String address;

        @Schema(description = "상점 전화번호", example = "02-123-4567", required = true)
        private String number;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(description = "상점 응답 DTO")
    public static class StoreResponseDto {

        @Schema(description = "상점 ID", example = "1")
        private Integer id;

        @Schema(description = "사용자 ID", example = "123")
        private Integer userId;

        @Schema(description = "상점 이름", example = "맛있는 식당")
        private String name;

        @Schema(description = "상점 주소", example = "서울시 강남구 역삼동")
        private String address;

        @Schema(description = "상점 전화번호", example = "02-123-4567")
        private String number;
    }
}