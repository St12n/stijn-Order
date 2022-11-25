package com.stijn.order.repositories;

import com.stijn.order.domain.user.User;

import com.stijn.order.domain.user.contactInformation.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);

    User findUserByPhoneNumber(PhoneNumber phoneNumber);
}
