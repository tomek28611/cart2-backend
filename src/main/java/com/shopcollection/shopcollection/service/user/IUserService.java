package com.shopcollection.shopcollection.service.user;

import com.shopcollection.shopcollection.dto.UserDto;
import com.shopcollection.shopcollection.model.User;
import com.shopcollection.shopcollection.request.CreateUserRequest;
import com.shopcollection.shopcollection.request.UserUpdateRequest;

public interface IUserService {

    User getUserById(Long userId);
    User createUser(CreateUserRequest request);
    User updateUser(UserUpdateRequest request, Long userId);
    void deleteUser(Long userId);

    UserDto convertUserToDto(User user);


}
