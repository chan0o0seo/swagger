package com.example.api.controller;

import com.example.api.entity.dto.StoreDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Arrays;

@RestController
@RequestMapping("/api/store")
@Tag(name = "Store API", description = "상점 관리 API")
public class StoreController {

    @PostMapping
    @Operation(summary = "상점 등록", description = "새로운 상점을 등록합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "상점 등록 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StoreDto.StoreResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    public ResponseEntity<StoreDto.StoreResponseDto> createStore(@RequestBody StoreDto.StoreRequestDto requestDto) {
        StoreDto.StoreResponseDto responseDto = new StoreDto.StoreResponseDto(1, requestDto.getUserId(), requestDto.getName(), requestDto.getAddress(), requestDto.getNumber());
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "상점 조회", description = "ID를 기반으로 상점 정보를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "상점 조회 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StoreDto.StoreResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "상점을 찾을 수 없음")
    })
    public ResponseEntity<StoreDto.StoreResponseDto> getStore(@Parameter(description = "상점 ID", required = true) @PathVariable Integer id) {
        StoreDto.StoreResponseDto responseDto = new StoreDto.StoreResponseDto(id, 123, "맛있는 식당", "서울시 강남구 역삼동", "02-123-4567");
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    @Operation(summary = "모든 상점 목록 조회", description = "등록된 모든 상점을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "상점 목록 조회 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StoreDto.StoreResponseDto.class)))
    })
    public ResponseEntity<List<StoreDto.StoreResponseDto>> getAllStores() {
        List<StoreDto.StoreResponseDto> stores = Arrays.asList(
                new StoreDto.StoreResponseDto(1, 123, "맛있는 식당", "서울시 강남구 역삼동", "02-123-4567"),
                new StoreDto.StoreResponseDto(2, 456, "한식당", "서울시 서초구 서초동", "02-456-7890")
        );
        return ResponseEntity.ok(stores);
    }

    @PutMapping("/{id}")
    @Operation(summary = "상점 정보 수정", description = "ID를 기반으로 상점 정보를 수정합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "상점 정보 수정 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StoreDto.StoreResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "상점을 찾을 수 없음"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    public ResponseEntity<StoreDto.StoreResponseDto> updateStore(@Parameter(description = "상점 ID", required = true) @PathVariable Integer id, @RequestBody StoreDto.StoreRequestDto requestDto) {
        StoreDto.StoreResponseDto responseDto = new StoreDto.StoreResponseDto(id, requestDto.getUserId(), requestDto.getName(), requestDto.getAddress(), requestDto.getNumber());
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "상점 삭제", description = "ID를 기반으로 상점을 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "상점 삭제 성공", content = @Content(mediaType = "text/plain")),
            @ApiResponse(responseCode = "404", description = "상점을 찾을 수 없음")
    })
    public ResponseEntity<String> deleteStore(@Parameter(description = "상점 ID", required = true) @PathVariable Integer id) {
        return ResponseEntity.ok("상점 ID " + id + " 삭제 완료");
    }
}