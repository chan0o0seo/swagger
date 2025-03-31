package com.example.api.controller;

import com.example.api.entity.dto.InventoryDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Tag(name = "Recipe", description = "레시피 관련 API")
@RestController
@RequestMapping("/api/inventory/recipes")
@RequiredArgsConstructor
public class RecipeController {

    @GetMapping("/{menuId}")
    @Operation(summary = "메뉴별 레시피 조회", description = "특정 메뉴에 대한 레시피 목록을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 레시피 목록 조회", content = @Content(schema = @Schema(implementation = InventoryDto.RecipeResponse.class))),
            @ApiResponse(responseCode = "404", description = "메뉴를 찾을 수 없음", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    public ResponseEntity<List<InventoryDto.RecipeResponse>> getRecipesByMenu(
            @Parameter(description = "메뉴 ID", required = true) @PathVariable Integer menuId) {
        List<InventoryDto.RecipeResponse> recipes = Arrays.asList(
                new InventoryDto.RecipeResponse(1, menuId, 1, 2), // 김치찌개 레시피 예제
                new InventoryDto.RecipeResponse(2, menuId, 2, 3)  // 김치찌개 레시피 예제
        );
        return ResponseEntity.ok(recipes);
    }

    @PostMapping("/add")
    @Operation(summary = "레시피 추가", description = "새로운 레시피를 추가합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 레시피 추가", content = @Content(schema = @Schema(implementation = InventoryDto.RecipeResponse.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    public ResponseEntity<InventoryDto.RecipeResponse> addRecipe(
            @RequestBody InventoryDto.RecipeRequest request) {
        return ResponseEntity.ok(new InventoryDto.RecipeResponse(3, request.getMenuId(), request.getIngredientId(), request.getQuantity()));
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "레시피 수정", description = "ID로 특정 레시피의 정보를 수정합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 레시피 수정", content = @Content(schema = @Schema(implementation = InventoryDto.RecipeResponse.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "404", description = "레시피를 찾을 수 없음", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    public ResponseEntity<InventoryDto.RecipeResponse> updateRecipe(
            @Parameter(description = "레시피 ID", required = true) @PathVariable Integer id,
            @RequestBody InventoryDto.RecipeRequest request) {
        return ResponseEntity.ok(new InventoryDto.RecipeResponse(id, request.getMenuId(), request.getIngredientId(), request.getQuantity()));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "레시피 삭제", description = "ID로 특정 레시피를 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "성공적으로 레시피 삭제"),
            @ApiResponse(responseCode = "404", description = "레시피를 찾을 수 없음", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    public ResponseEntity<Void> deleteRecipe(
            @Parameter(description = "레시피 ID", required = true) @PathVariable Integer id) {
        return ResponseEntity.noContent().build();
    }
}