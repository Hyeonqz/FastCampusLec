package org.example.api.domain.token.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenResponse {

    private String accessToken;
    private LocalDateTime accessTokenExpiredAt;

    private String refreshToken;

    private LocalDateTime refreshTokenExpiredAt;
}
