package pl.urban.korkpys.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordResetConfirmRequest {
    private String token;
    private String newPassword;
}
