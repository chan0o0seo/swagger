package com.example.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("WMTHIS API 문서")
                        .version("1.0")
                        .description("WMTHIS 프로젝트의 API 문서입니다.")
                        .contact(new Contact()
                                .name("WMTHIS 개발팀")
                                .email("support@wmthis.com")
                        ));
    }

    @Bean
    public GroupedOpenApi communityApi() {
        return GroupedOpenApi.builder()
                .group("커뮤니티 관리")  // Swagger UI에서 표시될 그룹 이름
                .pathsToMatch("/api/community/**") // 특정 URL 패턴을 포함
                .build();
    }

    @Bean
    public GroupedOpenApi boardApi() {
        return GroupedOpenApi.builder()
                .group("게시글 관리")  // Swagger UI에서 표시될 그룹 이름
                .pathsToMatch("/api/board/**") // 특정 URL 패턴을 포함
                .build();
    }

    @Bean
    public GroupedOpenApi inventoryApi() {
        return GroupedOpenApi.builder()
                .group("재고 관리")  // Swagger UI에서 표시될 그룹 이름
                .pathsToMatch("/api/inventory/**") // 특정 URL 패턴을 포함
                .build();
    }
    @Bean
    public GroupedOpenApi chatApi() {
        return GroupedOpenApi.builder()
                .group("채팅 관리")  // Swagger UI에서 표시될 그룹 이름
                .pathsToMatch("/api/chatrooms/**") // 특정 URL 패턴을 포함
                .build();
    }
    @Bean
    public GroupedOpenApi orderApi() {
        return GroupedOpenApi.builder()
                .group("상점간 거래 관리")  // Swagger UI에서 표시될 그룹 이름
                .pathsToMatch("/api/order/**") // 특정 URL 패턴을 포함
                .build();
    }
    @Bean
    public GroupedOpenApi menuOrderApi() {
        return GroupedOpenApi.builder()
                .group("실제 메뉴 거래 관리")  // Swagger UI에서 표시될 그룹 이름
                .pathsToMatch("/api/menu-order/**") // 특정 URL 패턴을 포함
                .build();
    }
    @Bean
    public GroupedOpenApi storeApi() {
        return GroupedOpenApi.builder()
                .group("상점 관리")  // Swagger UI에서 표시될 그룹 이름
                .pathsToMatch("/api/store/**") // 특정 URL 패턴을 포함
                .build();
    }
    @Bean
    public GroupedOpenApi userApi() {
        return GroupedOpenApi.builder()
                .group("회원 관리")  // Swagger UI에서 표시될 그룹 이름
                .pathsToMatch("/api/user/**") // 특정 URL 패턴을 포함
                .build();
    }
}
