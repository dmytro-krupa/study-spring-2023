package com.lpnu.airport.resource;

import com.lpnu.airport.entity.User;
import com.lpnu.airport.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// RequestMapping - містить префікс для усіх @***Mapping-ів які будуть в класі
@RequestMapping("/api/user")
public class UserResource {
    @Autowired
    private UserService userService;
    /*
        GetMapping відповідає за отримання ресурсів
     */
    @GetMapping("/{id}")
    public User findById(final @PathVariable Long id){
        return userService.findById(id);
    }
    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }
    /*
        PostMapping відповідає за створення ресурсів
     */
    @PostMapping
    public User createUser(final @RequestBody User user){
        return userService.save(user);
    }


    @PutMapping
    public User updateUser(final @RequestBody User user){
        return userService.update(user);
    }

    @PatchMapping("/{id}")
    public User updateUserName(final @PathVariable Long id, final @RequestBody String name){
        return userService.updateUserName(id, name);
    }

    @DeleteMapping("/{id}")
    public void deleteById(final @PathVariable Long id){
        userService.deleteById(id);
    }
}
