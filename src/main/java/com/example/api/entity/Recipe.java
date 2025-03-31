package com.example.api.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "recipe")
@Data
@Schema(description = "레시피 정보")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "레시피 ID", example = "1")
    private Integer id;

    @Column(name = "menu_id", nullable = false, insertable = false, updatable = false)
    @Schema(description = "메뉴 ID", example = "123")
    private Integer menuId;

    @Column(name = "ingredient_id", nullable = false, insertable = false, updatable = false)
    @Schema(description = "재료 ID", example = "456")
    private Integer ingredientId;

    @Column(name = "quantity")
    @Schema(description = "수량", example = "10")
    private Integer quantity;
}