package com.example.api.controller;

import com.example.api.entity.CommunitySave;
import com.example.api.entity.User;
import com.example.api.entity.dto.BoardDto;
import com.example.api.entity.dto.CommunitySaveDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/community")
public class CommunitySaveController {

//    @GetMapping("/communitysave/{boardIdx}")
//    @Operation(summary = "댓글 조회")
//    public ResponseEntity<List<BoardDto.BoardResponse>> getCommunitySave(@PathVariable Long boardIdx) {
//        List<BoardDto.BoardResponse> boardList = new ArrayList<>();
//        return ResponseEntity.ok(boardList);
//    } 게시판 상세조회에 있음

    @GetMapping("/communitysave/{boardIdx}")
    @Operation(summary = "게시글 찜 개수 조회", description = "특정 개시글의 찜 개수를 조회합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 게시글 찜 개수 조회", content = @Content(schema = @Schema(implementation = CommunitySaveDto.CountResponse.class))),
            @ApiResponse(responseCode = "404", description = "게시글 찜 개수를 조회할 수 없음", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    public ResponseEntity<CommunitySaveDto.CountResponse> getCommunitySaveCount(@PathVariable Long boardIdx) {
        CommunitySaveDto.CountResponse response = new CommunitySaveDto.CountResponse();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/mycommunitysave")
    @Operation(summary = "내가 찜한 개시글 조회", description = "자신이 찜한 게시글을 모두 조회합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 내가 찜한 게시글 조회", content = @Content(schema = @Schema(implementation = CommunitySaveDto.MyCommunitySaveResponseList.class))),
            @ApiResponse(responseCode = "404", description = "내가 찜한 게시글을 조회할 수 없음", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    public ResponseEntity<CommunitySaveDto.MyCommunitySaveResponseList> getMyCommunitySave(User user) {
        // 나중에 security 추가하고 Authentication 넣을예정
        CommunitySaveDto.MyCommunitySaveResponseList response = new CommunitySaveDto.MyCommunitySaveResponseList();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/communitysave/put/{boardIdx}")
    @Operation(summary = "게시글 찜/취소 하기", description = "특정 게시글을 찜/취소합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 게시글 찜 개수 조회", content = @Content(schema = @Schema(implementation = CommunitySaveDto.PutCommunitySaveResponse.class))),
            @ApiResponse(responseCode = "404", description = "게시글 찜 개수를 조회할 수 없음", content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 에러", content = @Content)
    })
    public ResponseEntity<CommunitySaveDto.PutCommunitySaveResponse> putCommunitySaveCount(@PathVariable Long boardIdx, User user) {
        CommunitySaveDto.PutCommunitySaveResponse response = new CommunitySaveDto.PutCommunitySaveResponse();
        return ResponseEntity.ok(response);
    }


}
