package com.lpnu.airport.resource;

import com.lpnu.airport.dto.UserDTO;
import com.lpnu.airport.sevice.RoleService;
import com.lpnu.airport.sevice.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
// RequestMapping - містить префікс для усіх @***Mapping-ів які будуть в класі
@RequestMapping("/api/user")
public class UserResource {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


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
    public ResponseEntity createUser(final @RequestBody @Valid UserDTO userDTO){
        final UserDTO responseBody = userService.save(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
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

    @GetMapping("/search")
    public ResponseEntity<UserDTO> find(final @RequestParam String name, final @RequestParam String surname){
        final UserDTO responseBody = userService.searchByNameAndSurname(name, surname);
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/role")
    public String getRole(){
        return roleService.getRole();
    }


}
