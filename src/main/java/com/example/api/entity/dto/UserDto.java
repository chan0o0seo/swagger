package com.example.api.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserDto {

    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(description = "사용자 생성 및 수정 요청 DTO")
    @Getter
    public static class UserRequestDto {

        @Schema(description = "사용자 이름", example = "홍길동", required = true)
        private String name;

        @Schema(description = "사용자 이메일", example = "user@example.com", required = true)
        private String email;

        @Schema(description = "사용자 비밀번호", example = "password123", required = true)
        private String password;

        @Schema(description = "사업자 등록 번호", example = "123-45-67890")
        private String businessNumber;

        @Schema(description = "사용자 전화번호", example = "010-1234-5678")
        private String phoneNumber;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(description = "사용자 응답 DTO")
    public static class UserResponseDto {

        @Schema(description = "사용자 고유 ID", example = "1")
        private Integer id;

        @Schema(description = "사용자 이름", example = "홍길동")
        private String name;

        @Schema(description = "사용자 이메일", example = "user@example.com")
        private String email;

        @Schema(description = "사업자 등록 번호", example = "123-45-67890")
        private String businessNumber;

        @Schema(description = "사용자 전화번호", example = "010-1234-5678")
        private String phoneNumber;
    }
}