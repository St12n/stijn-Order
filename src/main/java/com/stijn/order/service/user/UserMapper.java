package com.stijn.order.service.user;

import com.stijn.order.domain.user.Role;
import com.stijn.order.domain.user.User;
import com.stijn.order.service.user.dto.CreateUserDTO;
import com.stijn.order.service.user.dto.UserDTO;

public class UserMapper {

    public UserDTO mapUserToDTO(User user) {
        return new UserDTO()
                .setFirstname(user.getFirstname())
                .setLastname(user.getLastname())
                .setEmail(user.getEmail())
                .setPhoneNumber(user.getPhoneNumber())
                .setAddress(user.getAddress());
    }

    public User mapCreateUserDTOToUser(CreateUserDTO createUserDTO) {
        return new User(createUserDTO.getFirstname(), createUserDTO.getLastname(), createUserDTO.getEmail(), createUserDTO.getPhoneNumber(), createUserDTO.getAddress(), Role.USER);
    }
}
