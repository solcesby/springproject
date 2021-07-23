package com.itechart.springproject.dto.user;

import com.itechart.springproject.dto.user.enums.UserRoleDTO;
import lombok.Data;

@Data
public class UserDTO {

    private UserRoleDTO role;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

}