package pl.urban.korkpys.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class KeyRotationScheduler {

    @Autowired
    private JwtUtil jwtUtil;

    @Scheduled(cron = "0 0 0 * * SUN") // Co niedzielę o północy
    public void rotateKeys() {
        jwtUtil.rotateKey();
    }
}