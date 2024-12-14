package com.shriram.e_commerce.services;

import com.shriram.e_commerce.dto.request.UsersDtoRequest;
import com.shriram.e_commerce.dto.response.ProfileDataResponse;

public interface UsersServices {
    boolean singUpUser(UsersDtoRequest usersDtoRequest);

    ProfileDataResponse getUsersDetails(int userId);
}
