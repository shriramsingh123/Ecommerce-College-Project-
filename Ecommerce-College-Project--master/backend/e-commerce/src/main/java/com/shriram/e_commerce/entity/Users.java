package com.shriram.e_commerce.entity;

import com.shriram.e_commerce.enums.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_details")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(length = 150,nullable = false)
    private String firstName;
    @Column(length = 150,nullable = false)
    private String lastName;
    @Column(length = 20)
    private String gender;

    @Column(unique = true,length = 250,nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    @Column(length = 10,nullable = false)
    private Roles roles;

    @Column(length = 50)
    private String mobileNo;

    @Column(length = 35)
    private String nationality;

    @Column(length = 35)
    private String province;

    @Lob
    private byte[] profileImg;

}
