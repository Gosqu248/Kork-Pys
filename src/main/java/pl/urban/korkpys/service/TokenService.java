package pl.urban.korkpys.service;

import org.springframework.stereotype.Service;
import pl.urban.korkpys.config.OAuth2Config;

@Service
public class TokenService {

    private final OAuth2Config oAuth2Config;

    public TokenService(OAuth2Config oAuth2Config) {
        this.oAuth2Config = oAuth2Config;
    }

    public String getAccessToken() {
        return oAuth2Config.getAccessToken();
    }
}
