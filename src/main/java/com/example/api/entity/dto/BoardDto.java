package com.example.api.entity.dto;

import com.example.api.entity.Comment;

import java.util.ArrayList;
import java.util.List;

public class BoardDto {
    public static class BoardDetailResponse {
        private Integer idx;
        private String title; //게시판 제목
        private String content; //게시판 내용
        private String created_at;
        private String updated_at;
        private List<Comment> comments; //댓글
        private InventoryDto.BoardResponse boardResponse; // 재료 정보

    }

    public static class BoardResponse {
        private Integer idx;
        private String title; //게시판 제목
        private String created_at;
        private String updated_at;
    }

    public static class BoardResponseList {
        List<BoardResponse> boardResponseList = new ArrayList<>();
    }

    public static class BoardRequest{
        private String title;
        private String content;
        private InventoryDto.BoardRequest boardRequest;
    }

    public static class BoardRequestResponse {
        private Integer idx;
    } // 게시글 등록 요청에 대한 응답

    public static class BoardDelteResponse {
        private boolean isDeleted;
    } // 게시글 등록 요청에 대한 응답

}
