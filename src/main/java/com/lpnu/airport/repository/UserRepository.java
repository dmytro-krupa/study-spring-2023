package com.lpnu.airport.repository;

import com.lpnu.airport.entity.User;
import com.lpnu.airport.exceptions.BadRequestException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByNameAndSurname(String name, String surname);
}
