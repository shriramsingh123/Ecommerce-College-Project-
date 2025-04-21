package com.shriram.e_commerce.dto.request;

import com.shriram.e_commerce.enums.Roles;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Data
@ToString
public class UsersDtoRequest {

    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String password;
    private Roles roles;
    private String mobileNo;
    private String nationality;
    private String province;
    private MultipartFile profileImg;


}
