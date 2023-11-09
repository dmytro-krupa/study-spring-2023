package com.lpnu.airport.resource;

import com.lpnu.airport.dto.UserDTO;
import com.lpnu.airport.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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
    public UserDTO findById(final @PathVariable Long id){
        return userService.findDTOById(id);
    }

    @GetMapping
    public List<UserDTO> findAll(){
        return userService.findAll();
    }

    /*
        PostMapping відповідає за створення ресурсів
     */
    @PostMapping
    public UserDTO createUser(final @RequestBody UserDTO user){
        return userService.save(user);
    }

    @PutMapping
    public UserDTO updateUser(final @RequestBody UserDTO user){
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(final @PathVariable Long id){
        userService.deleteById(id);
    }

    @PatchMapping("/{id}")
    public void addMoney(final @PathVariable Long id,
                         final @RequestParam BigDecimal money){
        userService.addMoney(id, money);
    }
}
