package com.example.api.entity.dto;

import com.example.api.entity.Comment;

import java.util.List;

public class BoardDto {
    public static class BoardDetailResponse {
        private Long idx;
        private String title; //게시판 제목
        private String content; //게시판 내용
        private String created_at;
        private String updated_at;
        private List<Comment> comments; //댓글
    }

    public static class BoardResponse {
        private Long idx;
        private String title; //게시판 제목
        private String created_at;
        private String updated_at;
    }

}
