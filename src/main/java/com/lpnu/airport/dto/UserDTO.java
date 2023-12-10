package com.lpnu.airport.dto;

import com.lpnu.airport.entity.User;
import com.lpnu.airport.validation.CrossCheck;
import com.lpnu.airport.validation.enumeration.Condition;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String email;
    private String password;
    private BigDecimal money;


    @Valid
    @NotNull
    @Size(min = 5, max = 15)
    private List<PlaneDTO> planeDTOList;

    public static UserDTO toDTO(final User user){
        final UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setMoney(user.getMoney());

        return userDTO;
    }


}
