package com.shriram.e_commerce.dto.response;

import com.shriram.e_commerce.enums.Roles;
import lombok.Data;

@Data
public class AuthResponse {

    private String jwt;
    private Roles role;
    private int userId;
}
