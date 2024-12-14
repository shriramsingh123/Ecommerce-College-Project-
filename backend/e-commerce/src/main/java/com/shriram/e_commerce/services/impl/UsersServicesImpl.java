package com.shriram.e_commerce.services.impl;

import com.shriram.e_commerce.dto.request.UsersDtoRequest;
import com.shriram.e_commerce.dto.response.ProfileDataResponse;
import com.shriram.e_commerce.entity.Users;
import com.shriram.e_commerce.repository.UsersRepository;
import com.shriram.e_commerce.services.UsersServices;
import com.shriram.e_commerce.supports.ConvertsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UsersServicesImpl implements UsersServices {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean singUpUser(UsersDtoRequest usersDtoRequest) {
        Users users = new Users();
        users.setFirstName(usersDtoRequest.getFirstName());
        users.setLastName(usersDtoRequest.getLastName());
        users.setGender(usersDtoRequest.getGender());
        users.setEmail(usersDtoRequest.getEmail());
        users.setPassword(passwordEncoder.encode(usersDtoRequest.getPassword()));
        users.setRoles(usersDtoRequest.getRoles());
        users.setMobileNo(usersDtoRequest.getMobileNo());
        users.setNationality(usersDtoRequest.getNationality());
        users.setProvince(usersDtoRequest.getProvince());
        try{
            if (usersDtoRequest.getProfileImg() == null) System.out.println("Getting null as image");
            else users.setProfileImg(usersDtoRequest.getProfileImg().getBytes());
        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
        usersRepository.save(users);
        return true;
    }

    @Override
    public ProfileDataResponse getUsersDetails(int userId) {
        Users users = usersRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("Error during getting user details"));
        ProfileDataResponse response = ConvertsDto.convertUsersToProfileResponse(users);
        return response;
    }

}
