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

@Tag(name = "Menu", description = "메뉴 관련 API")
@RestController
@RequestMapping("/api/inventory/menu")
@RequiredArgsConstructor
public class MenuController {

    @GetMapping("/search")
    @Operation(summary = "메뉴 목록 조회", description = "상점의 모든 메뉴 목록을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 메뉴 목록 조회", content = @Content(schema = @Schema(implementation = InventoryDto.MenuResponse.class))),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    public ResponseEntity<List<InventoryDto.MenuResponse>> getMenus() {
        List<InventoryDto.MenuResponse> menus = Arrays.asList(
                new InventoryDto.MenuResponse(1, 123, "김치찌개", 8000),
                new InventoryDto.MenuResponse(2, 123, "된장찌개", 7500)
        );
        return ResponseEntity.ok(menus);
    }

    @GetMapping("/detail/{id}")
    @Operation(summary = "메뉴 상세 조회", description = "ID로 특정 메뉴의 상세 정보를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 메뉴 상세 정보 조회", content = @Content(schema = @Schema(implementation = InventoryDto.MenuResponse.class))),
            @ApiResponse(responseCode = "404", description = "메뉴를 찾을 수 없음", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    public ResponseEntity<InventoryDto.MenuResponse> getMenu(
            @Parameter(description = "메뉴 ID", required = true) @PathVariable Integer id) {
        return ResponseEntity.ok(new InventoryDto.MenuResponse(id, 123, "김치찌개", 8000));
    }

    @PostMapping("/add")
    @Operation(summary = "메뉴 추가", description = "새로운 메뉴를 추가합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 메뉴 추가", content = @Content(schema = @Schema(implementation = InventoryDto.MenuResponse.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    public ResponseEntity<InventoryDto.MenuResponse> addMenu(
            @RequestBody InventoryDto.MenuRequest request) {
        return ResponseEntity.ok(new InventoryDto.MenuResponse(3, request.getStoreId(), request.getName(), request.getPrice()));
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "메뉴 수정", description = "ID로 특정 메뉴의 정보를 수정합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 메뉴 수정", content = @Content(schema = @Schema(implementation = InventoryDto.MenuResponse.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
            @ApiResponse(responseCode = "404", description = "메뉴를 찾을 수 없음", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    public ResponseEntity<InventoryDto.MenuResponse> updateMenu(
            @Parameter(description = "메뉴 ID", required = true) @PathVariable Integer id,
            @RequestBody InventoryDto.MenuRequest request) {
        return ResponseEntity.ok(new InventoryDto.MenuResponse(id, request.getStoreId(), request.getName(), request.getPrice()));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "메뉴 삭제", description = "ID로 특정 메뉴를 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "성공적으로 메뉴 삭제"),
            @ApiResponse(responseCode = "404", description = "메뉴를 찾을 수 없음", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    public ResponseEntity<Void> deleteMenu(
            @Parameter(description = "메뉴 ID", required = true) @PathVariable Integer id) {
        return ResponseEntity.noContent().build();
    }
}