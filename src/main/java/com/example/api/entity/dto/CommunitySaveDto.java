package com.example.api.entity.dto;

import java.util.List;

public class CommunitySaveDto {
    public static class MyCommunitySaveResponse {
        private Integer idx;
        private String created_at;
    }

    public static class CountResponse {
        private Integer count;
    }

    public static class MyCommunitySaveResponseList{
        List<MyCommunitySaveResponse> my_community_save_response;
    }

    public static class PutCommunitySaveResponse{
        private Integer idx;
    }


}
