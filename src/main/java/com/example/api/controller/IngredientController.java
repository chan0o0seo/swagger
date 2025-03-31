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

import java.util.List;
import java.util.Arrays;

@Tag(name = "Ingredient", description = "재료 관련 API")
@RestController
@RequestMapping("/api/inventory/ingredients")
@RequiredArgsConstructor
public class IngredientController {

    @GetMapping("/search")
    @Operation(summary = "재료 목록 조회", description = "상점의 모든 재료 목록을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 재료 목록 조회", content = @Content(schema = @Schema(implementation = InventoryDto.IngredientResponse.class))),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    public ResponseEntity<List<InventoryDto.IngredientResponse>> getIngredients() {
        List<InventoryDto.IngredientResponse> ingredients = Arrays.asList(
                new InventoryDto.IngredientResponse(1, 123, "양파", 10, "개"),
                new InventoryDto.IngredientResponse(2, 123, "마늘", 5, "쪽")
        );
        return ResponseEntity.ok(ingredients);
    }

    @GetMapping("/detail/{id}")
    @Operation(summary = "재료 상세 조회", description = "ID로 특정 재료의 상세 정보를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 재료 상세 정보 조회", content = @Content(schema = @Schema(implementation = InventoryDto.IngredientResponse.class))),
            @ApiResponse(responseCode = "404", description = "재료를 찾을 수 없음", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    public ResponseEntity<InventoryDto.IngredientResponse> getIngredient(
            @Parameter(description = "재료 ID", required = true) @PathVariable Integer id) {
        return ResponseEntity.ok(new InventoryDto.IngredientResponse(id, 123, "양파", 10, "개"));
    }

    @PostMapping("/add")
    @Operation(summary = "재료 추가", description = "새로운 재료를 추가합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 재료 추가", content = @Content(schema = @Schema(implementation = InventoryDto.IngredientResponse.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    public ResponseEntity<InventoryDto.IngredientResponse> addIngredient(
            @RequestBody InventoryDto.IngredientRequest request) {
        return ResponseEntity.ok(new InventoryDto.IngredientResponse(3, request.getStoreId(), request.getName(), request.getQuantity(), request.getUnit()));
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "재료 수정", description = "ID로 특정 재료의 정보를 수정합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 재료 수정", content = @Content(schema = @Schema(implementation = InventoryDto.IngredientResponse.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "404", description = "재료를 찾을 수 없음", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    public ResponseEntity<InventoryDto.IngredientResponse> updateIngredient(
            @Parameter(description = "재료 ID", required = true) @PathVariable Integer id,
            @RequestBody InventoryDto.IngredientRequest request) {
        return ResponseEntity.ok(new InventoryDto.IngredientResponse(id, request.getStoreId(), request.getName(), request.getQuantity(), request.getUnit()));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "재료 삭제", description = "ID로 특정 재료를 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "성공적으로 재료 삭제"),
            @ApiResponse(responseCode = "404", description = "재료를 찾을 수 없음", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    public ResponseEntity<Void> deleteIngredient(
            @Parameter(description = "재료 ID", required = true) @PathVariable Integer id) {
        return ResponseEntity.noContent().build();
    }
}