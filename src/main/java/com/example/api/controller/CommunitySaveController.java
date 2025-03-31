package com.example.api.controller;

import com.example.api.entity.CommunitySave;
import com.example.api.entity.User;
import com.example.api.entity.dto.BoardDto;
import com.example.api.entity.dto.CommunitySaveDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/community")
public class CommunitySaveController {

    @GetMapping("/board/{storeIdx}")
    @Operation(summary = "게시판 리스트 조회")
    public ResponseEntity<List<BoardDto.BoardResponse>> getBoardList(@PathVariable Long storeIdx) {
        List<BoardDto.BoardResponse> boardList = new ArrayList<>();
        return ResponseEntity.ok(boardList);
    }

    @GetMapping("/board/{boardIdx}")
    @Operation(summary = "게시판 상세조회")
    public ResponseEntity<BoardDto.BoardDetailResponse> getBoardDetail(@PathVariable Long boardIdx) {
        BoardDto.BoardDetailResponse boardDetail = new BoardDto.BoardDetailResponse();
        return ResponseEntity.ok(boardDetail);
    }

//    @GetMapping("/communitysave/{boardIdx}")
//    @Operation(summary = "댓글 조회")
//    public ResponseEntity<List<BoardDto.BoardResponse>> getCommunitySave(@PathVariable Long boardIdx) {
//        List<BoardDto.BoardResponse> boardList = new ArrayList<>();
//        return ResponseEntity.ok(boardList);
//    } 게시판 상세조회에 있음

    @GetMapping("/communitysave/{boardIdx}")
    @Operation(summary = "게시글 찜 개수 조회")
    public ResponseEntity<Long> getCommunitySaveCount(@PathVariable Long boardIdx) {
        List<CommunitySave> communitySaveList = new ArrayList<>();
        Long communitySaveCount = communitySaveList.stream().count();
        return ResponseEntity.ok(communitySaveCount);
    }

    @GetMapping("/mycommunitysave")
    @Operation(summary = "내가 찜한 게시글 조회")
    public ResponseEntity<List<CommunitySaveDto.MyCommunitySaveResponse>> getMyCommunitySave(User user) {
        // 나중에 security 추가하고 Authentication 넣을예정
        List<CommunitySaveDto.MyCommunitySaveResponse> myCommunitySaveList = new ArrayList<>();
        return ResponseEntity.ok(myCommunitySaveList);
    }
    

}
