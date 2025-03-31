package com.example.api.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ingrdient")
@Data
@Schema(description = "재료 정보")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "재료 ID", example = "1")
    private Integer id;

    @Column(name = "store_id", nullable = false, insertable = false, updatable = false)
    @Schema(description = "상점 ID", example = "123")
    private Integer storeId;

    @Column(name = "name", length = 255)
    @Schema(description = "재료 이름", example = "양파")
    private String name;

    @Column(name = "quantity")
    @Schema(description = "재료 수량", example = "10")
    private Integer quantity;

    @Column(name = "unit", length = 50)
    @Schema(description = "재료 단위", example = "개")
    private String unit;
}