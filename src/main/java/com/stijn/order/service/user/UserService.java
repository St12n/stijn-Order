package com.stijn.order.service.user;

import com.stijn.order.domain.user.User;
import com.stijn.order.repositories.UserRepository;
import com.stijn.order.service.user.dto.CreateUserDTO;
import com.stijn.order.service.user.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userMapper = new UserMapper();
    }

    public UserDTO saveUser(CreateUserDTO createUserDTO) {
        User newUser = userMapper.mapCreateUserDTOToUser(createUserDTO);
        userRepository.saveUser(newUser);
        return userMapper.mapUserToDTO(newUser);
    }
}
