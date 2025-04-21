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

<<<<<<< HEAD
    @Column(length = 15,nullable = false)
    private String firstName;
    @Column(length = 15,nullable = false)
=======
    @Column(length = 150,nullable = false)
    private String firstName;
    @Column(length = 150,nullable = false)
>>>>>>> c6bd71b (updated cards in frontend)
    private String lastName;
    @Column(length = 20)
    private String gender;

<<<<<<< HEAD
    @Column(unique = true,length = 25,nullable = false)
=======
    @Column(unique = true,length = 250,nullable = false)
>>>>>>> c6bd71b (updated cards in frontend)
    private String email;
    @Column(nullable = false)
    private String password;

    @Column(length = 10,nullable = false)
    private Roles roles;

<<<<<<< HEAD
    @Column(length = 15)
    private String mobileNo;

    @Column(length = 15)
    private String nationality;

    @Column(length = 15)
=======
    @Column(length = 50)
    private String mobileNo;

    @Column(length = 35)
    private String nationality;

    @Column(length = 35)
>>>>>>> c6bd71b (updated cards in frontend)
    private String province;

    @Lob
    private byte[] profileImg;

}
