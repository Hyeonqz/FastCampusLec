package org.example.api.domain.token.ifs;


import java.util.Map;

import org.example.api.domain.token.model.TokenDto;

public interface TokenHelperIfs {

    TokenDto issueAccessToken(Map<String, Object> data);
    TokenDto issueRefreshToken(Map<String, Object> data);

    Map<String, Object> validationTokenWithThrow(String token);

}
