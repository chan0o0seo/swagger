package com.example.api.entity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
@Schema(description = "사용자 정보")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "사용자 고유 ID", example = "1")
    private Integer id;

    @Column(name = "name", length = 20)
    @Schema(description = "사용자 이름", example = "홍길동")
    private String name;

    @Column(name = "email", length = 30)
    @Schema(description = "사용자 이메일", example = "user@example.com")
    private String email;

    @Column(name = "password", length = 30)
    @Schema(description = "사용자 비밀번호", example = "password123")
    private String password;

    @Column(name = "business_number", length = 30)
    @Schema(description = "사업자 등록 번호", example = "123-45-67890")
    private String businessNumber;

    @Column(name = "phone_number", length = 30)
    @Schema(description = "사용자 전화번호", example = "010-1234-5678")
    private String phoneNumber;

    @Column(name = "ssn", length = 30)
    @Schema(description = "주민등록번호", example = "900101-1234567")
    private String ssn;
}