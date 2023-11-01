package com.lpnu.airport.sevice.impl;

import com.lpnu.airport.entity.User;
import com.lpnu.airport.exceptions.BadRequestException;
import com.lpnu.airport.repository.UserRepository;
import com.lpnu.airport.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(final Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(String.format("User with id {%s} not found", id)));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(final User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(User user) {
        if(user.getId() == null){
            throw new BadRequestException("Id can't be null");
        }

        return userRepository.update(user);
    }

    @Override
    public User updateUserName(Long id, String name) {
        User user = findById(id);
        user.setName(name);
        return user;
    }
}
