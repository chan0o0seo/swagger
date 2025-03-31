package com.example.api.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "menu")
@Data
@Schema(description = "메뉴 정보")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "메뉴 ID", example = "1")
    private Integer id;

    @Column(name = "store_id", nullable = false)
    @Schema(description = "상점 ID", example = "123")
    private Integer storeId;

    @Column(name = "name", length = 50)
    @Schema(description = "메뉴 이름", example = "김치찌개")
    private String name;

    @Column(name = "price")
    @Schema(description = "메뉴 가격", example = "8000")
    private Integer price;
}