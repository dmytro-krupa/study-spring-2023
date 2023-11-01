package com.lpnu.airport.sevice;

import com.lpnu.airport.entity.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    void deleteById(Long id);
    List<User> findAll();
    User save(User user);
    User update(User user);
    User updateUserName(Long id, String name);
}
