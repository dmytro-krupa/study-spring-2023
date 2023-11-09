package com.lpnu.airport.repository;

import com.lpnu.airport.entity.User;
import com.lpnu.airport.exceptions.BadRequestException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private List<User> userList = new ArrayList<>();

    private Long lastUsedId = 0L;

    private Long generateId(){
        ++lastUsedId;
        return lastUsedId;
    }

    public User save(final User user){
        user.setId(generateId());
        userList.add(user);
        return user;
    }

    public User update(final User user){
//        Optional<User> optionalUser = findById(user.getId());
//
//        if(optionalUser.isEmpty()){
//            throw new BadRequestException(String.format("User with id {%s} not found", user.getId()));
//        }
//
//        User savedUser = optionalUser.get();

        User savedUser = findById(user.getId())
                .orElseThrow(() -> new BadRequestException(String.format("User with id {%s} not found", user.getId())));

        savedUser.setName(user.getName());
        savedUser.setSurname(user.getSurname());
        savedUser.setMoney(user.getMoney());

        return savedUser;
    }

    public List<User> findAll(){
        return userList;
    }

    public Optional<User> findById(final Long id){
        return userList.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    public void deleteById(final Long id){
        userList = userList.stream()
                .filter(e -> e.getId().equals(id))
                .collect(Collectors.toList());
    }
}
