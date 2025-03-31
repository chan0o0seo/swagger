package com.example.api.controller;

import com.example.api.entity.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@Tag(name = "User API", description = "사용자 관련 API")
public class UserController {

    @PostMapping
    @Operation(summary = "회원가입", description = "새로운 사용자를 등록합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "회원가입 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.UserResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    public ResponseEntity<UserDto.UserResponseDto> registerUser(@RequestBody UserDto.UserRequestDto requestDto) {
        UserDto.UserResponseDto responseDto = new UserDto.UserResponseDto(1, requestDto.getName(), requestDto.getEmail(), requestDto.getBusinessNumber(), requestDto.getPhoneNumber());
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/login")
    @Operation(summary = "로그인", description = "이메일과 비밀번호로 로그인합니다. 성공시 JWT 토큰도 반환합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "로그인 성공", content = @Content(mediaType = "text/plain")),
            @ApiResponse(responseCode = "401", description = "잘못된 이메일 또는 비밀번호")
    })
    public ResponseEntity<String> loginUser(@Parameter(description = "사용자 이메일", required = true) @RequestParam String email, @Parameter(description = "사용자 비밀번호", required = true) @RequestParam String password) {
        return ResponseEntity.ok("로그인 성공: " + email);
    }

    @GetMapping("/{id}")
    @Operation(summary = "사용자 조회", description = "ID로 사용자의 정보를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "사용자 조회 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.UserResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없음")
    })
    public ResponseEntity<UserDto.UserResponseDto> getUser(@Parameter(description = "사용자 ID", required = true) @PathVariable Integer id) {
        UserDto.UserResponseDto responseDto = new UserDto.UserResponseDto(id, "홍길동", "user@example.com", "123-45-67890", "010-1234-5678");
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "사용자 정보 수정", description = "사용자의 정보를 수정합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "사용자 정보 수정 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.UserResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없음"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    public ResponseEntity<UserDto.UserResponseDto> updateUser(@Parameter(description = "사용자 ID", required = true) @PathVariable Integer id, @RequestBody UserDto.UserRequestDto requestDto) {
        UserDto.UserResponseDto responseDto = new UserDto.UserResponseDto(id, requestDto.getName(), requestDto.getEmail(), requestDto.getBusinessNumber(), requestDto.getPhoneNumber());
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "회원 탈퇴", description = "사용자를 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "회원 탈퇴 성공", content = @Content(mediaType = "text/plain")),
            @ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없음")
    })
    public ResponseEntity<String> deleteUser(@Parameter(description = "사용자 ID", required = true) @PathVariable Integer id) {
        return ResponseEntity.ok("사용자 삭제 완료: " + id);
    }
}