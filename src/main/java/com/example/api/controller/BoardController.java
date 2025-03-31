package com.example.api.controller;

import com.example.api.entity.dto.BoardDto;
import com.example.api.entity.dto.ChatDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/board")
public class BoardController {

    @PostMapping("/board/requset")
    @Operation(summary = "게시글 등록", description = "게시글을 등록합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 게시글 등록", content = @Content(schema = @Schema(implementation = BoardDto.BoardRequestResponse.class))),
            @ApiResponse(responseCode = "404", description = "게시글을 등록 할 수 없음", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    public ResponseEntity<BoardDto.BoardRequestResponse> registerBoard(@RequestBody BoardDto.BoardRequest boardRequest) {
        BoardDto.BoardRequestResponse response = new BoardDto.BoardRequestResponse();
        return ResponseEntity.ok(response);
    }


    @GetMapping("/board/{storeIdx}")
    @Operation(summary = "게시글 리스트 조회", description = "특정 상점의 전체 게시글 목록을 보여줍니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 게시글 리스트 조회", content = @Content(schema = @Schema(implementation = BoardDto.BoardResponseList.class))),
            @ApiResponse(responseCode = "404", description = "게시글 리스트를 찾을 수 없음", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    public ResponseEntity<BoardDto.BoardResponseList> getBoardList(@PathVariable Long storeIdx) {
        BoardDto.BoardResponseList boardList = new BoardDto.BoardResponseList();
        return ResponseEntity.ok(boardList);
    }

    @GetMapping("/board/search/{boardIdx}")
    @Operation(summary = "게시글 상세조회", description = "특정 게시글의 정보를 보여줍니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 게시글 조회", content = @Content(schema = @Schema(implementation = BoardDto.BoardDetailResponse.class))),
            @ApiResponse(responseCode = "404", description = "게시글을 찾을 수 없음", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    public ResponseEntity<BoardDto.BoardDetailResponse> getBoardDetail(@PathVariable Long boardIdx) {
        BoardDto.BoardDetailResponse boardDetail = new BoardDto.BoardDetailResponse();
        return ResponseEntity.ok(boardDetail);
    }

    @DeleteMapping("/board/delete/{boardIdx}")
    @Operation(summary = "게시글 삭제", description = "특정 게시글을 삭제합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 게시글 삭제", content = @Content(schema = @Schema(implementation = BoardDto.BoardDelteResponse.class))),
            @ApiResponse(responseCode = "404", description = "게시글을 찾을 수 없음", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    public ResponseEntity<BoardDto.BoardDelteResponse> deleteBoard(@PathVariable Long boardIdx) {
        BoardDto.BoardDelteResponse response = new BoardDto.BoardDelteResponse();
        return ResponseEntity.ok(response);
    }

}
