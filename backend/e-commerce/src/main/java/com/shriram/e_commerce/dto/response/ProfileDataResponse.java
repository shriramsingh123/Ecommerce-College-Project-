package com.shriram.e_commerce.dto.response;

import com.shriram.e_commerce.enums.Roles;
import lombok.Data;

@Data
public class ProfileDataResponse {
    private int userId;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private Roles roles;
    private String mobileNo;
    private String nationality;
    private String province;
    private byte[] profileImg;
}
