package com.example.api.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "store")
@Data
@Schema(description = "상점 정보")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "상점 ID", example = "1")
    private Integer id;

    @Column(name = "user_id", nullable = false)
    @Schema(description = "사용자 ID (user 테이블의 고유 index)", example = "123")
    private Integer userId;

    @Column(name = "name", length = 100)
    @Schema(description = "상점 이름", example = "맛있는 식당")
    private String name;

    @Column(name = "address", length = 200)
    @Schema(description = "상점 주소", example = "서울시 강남구 역삼동")
    private String address;

    @Column(name = "number", length = 50)
    @Schema(description = "상점 전화번호", example = "02-123-4567")
    private String number;
}