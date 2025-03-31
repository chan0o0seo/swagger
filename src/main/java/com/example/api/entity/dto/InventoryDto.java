package com.example.api.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class InventoryDto {
    @Getter
    @AllArgsConstructor
    @Schema(description = "재료 응답 DTO")
    public static class IngredientResponse {
        @Schema(description = "재료 ID", example = "1")
        private Integer id;

        @Schema(description = "상점 ID", example = "123")
        private Integer storeId;

        @Schema(description = "재료 이름", example = "양파")
        private String name;

        @Schema(description = "재료 수량", example = "10")
        private Integer quantity;

        @Schema(description = "재료 단위", example = "개")
        private String unit;
    }

    @Getter
    @Schema(description = "재료 추가/수정 요청 DTO")
    public class IngredientRequest {
        @Schema(description = "상점 ID", example = "123")
        private Integer storeId;

        @Schema(description = "재료 이름", example = "양파")
        private String name;

        @Schema(description = "재료 수량", example = "10")
        private Integer quantity;

        @Schema(description = "재료 단위", example = "개")
        private String unit;
    }

    @AllArgsConstructor
    @Schema(description = "메뉴 응답 DTO")
    public static class MenuResponse {
        @Schema(description = "메뉴 ID", example = "1")
        private Integer id;

        @Schema(description = "상점 ID", example = "123")
        private Integer storeId;

        @Schema(description = "메뉴 이름", example = "김치찌개")
        private String name;

        @Schema(description = "메뉴 가격", example = "8000")
        private Integer price;
    }
    @Getter
    @Schema(description = "메뉴 추가/수정 요청 DTO")
    public class MenuRequest {
        @Schema(description = "상점 ID", example = "123")
        private Integer storeId;

        @Schema(description = "메뉴 이름", example = "김치찌개")
        private String name;

        @Schema(description = "메뉴 가격", example = "8000")
        private Integer price;
    }

    @AllArgsConstructor
    @Schema(description = "레시피 응답 DTO")
    public static class RecipeResponse {
        @Schema(description = "레시피 ID", example = "1")
        private Integer id;

        @Schema(description = "메뉴 ID", example = "123")
        private Integer menuId;

        @Schema(description = "재료 ID", example = "456")
        private Integer ingredientId;

        @Schema(description = "수량", example = "10")
        private Integer quantity;
    }

    @Getter
    @Schema(description = "레시피 추가/수정 요청 DTO")
    public class RecipeRequest {
        @Schema(description = "메뉴 ID", example = "123")
        private Integer menuId;

        @Schema(description = "재료 ID", example = "456")
        private Integer ingredientId;

        @Schema(description = "수량", example = "10")
        private Integer quantity;
    }
}
