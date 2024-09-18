package com.shopcollection.shopcollection.service.user;

import com.shopcollection.shopcollection.dto.UserDto;
import com.shopcollection.shopcollection.exception.AlreadyExistsException;
import com.shopcollection.shopcollection.exception.ResourceNotFoundException;
import com.shopcollection.shopcollection.model.User;
import com.shopcollection.shopcollection.repository.UserRepository;
import com.shopcollection.shopcollection.request.CreateUserRequest;
import com.shopcollection.shopcollection.request.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found!"));
    }

    @Override
    public User createUser(CreateUserRequest request) {
        return  Optional.of(request)
                .filter(user -> !userRepository.existsByEmail(request.getEmail()))
                .map(req -> {
                    User user = new User();
                    user.setEmail(request.getEmail());
                    user.setPassword(request.getPassword());
                    user.setFirstName(request.getFirstName());
                    user.setLastName(request.getLastName());
                    return  userRepository.save(user);
                }) .orElseThrow(() -> new AlreadyExistsException("User : " + request.getEmail() +" already exists!"));
    }

    @Override
    public User updateUser(UserUpdateRequest request, Long userId) {
        return  userRepository.findById(userId)
                .map(existingUser -> {
            existingUser.setFirstName(request.getFirstName());
            existingUser.setLastName(request.getLastName());
            return userRepository.save(existingUser);
        }).orElseThrow(() -> new ResourceNotFoundException("User not found!"));

    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.findById(userId).ifPresentOrElse(userRepository :: delete, () ->{
            throw new ResourceNotFoundException("User not found!");
        });
    }

    @Override
    public UserDto convertUserToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

}
