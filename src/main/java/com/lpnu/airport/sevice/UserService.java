package com.lpnu.airport.sevice;

import com.lpnu.airport.dto.UserDTO;

import java.math.BigDecimal;
import java.util.List;


public interface UserService {
    UserDTO findDTOById(Long id);
    void deleteById(Long id);
    List<UserDTO> findAll();
    UserDTO save(UserDTO user);
    UserDTO update(UserDTO user);

    void addMoney(Long userId, BigDecimal money);

    UserDTO searchByNameAndSurname(String name, String surname);
}
