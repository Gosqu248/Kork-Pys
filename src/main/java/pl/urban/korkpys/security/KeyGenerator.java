package pl.urban.korkpys.security;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class KeyGenerator {
    public static void main(String[] args) {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // generuje klucz odpowiedni dla HS256
        String base64Key = java.util.Base64.getEncoder().encodeToString(key.getEncoded());
        System.out.println(base64Key);
    }
}

