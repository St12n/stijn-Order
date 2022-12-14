package com.stijn.order.service.user;

import com.stijn.order.domain.user.contactInformation.Address;
import com.stijn.order.domain.user.contactInformation.PhoneNumber;
import com.stijn.order.domain.user.role.Role;
import com.stijn.order.domain.user.User;
import com.stijn.order.service.user.dto.CreateUserDTO;
import com.stijn.order.service.user.dto.UserDTO;

public class UserMapper {

    public UserDTO mapUserToDTO(User user) {
        return new UserDTO()
                .setFirstname(user.getFirstname())
                .setLastname(user.getLastname())
                .setEmail(user.getEmail())
                .setCountryCode(user.getPhoneNumber().getCountryCode())
                .setLocalPhoneNumber(user.getPhoneNumber().getLocalPhoneNumber())
                .setAddress(user.getAddress().toString());
    }

    public User mapCreateUserDTOToUser(CreateUserDTO createUserDTO) {
        return new User(createUserDTO.getFirstname(), createUserDTO.getLastname(), createUserDTO.getEmail(), new PhoneNumber(createUserDTO.getCountryCode(), createUserDTO.getLocalPhoneNumber()), new Address(createUserDTO.getStreetname(), createUserDTO.getHousenumber(), createUserDTO.getBoxNumber(), createUserDTO.getCity(), createUserDTO.getPostalCode()), Role.USER,createUserDTO.getPassword());
    }
}
