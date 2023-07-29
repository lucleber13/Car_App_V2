package com.cbcode.car_app_v2.User_Packages.services;

import com.cbcode.car_app_v2.User_Packages.model.DTO.UserRegisterDto;
import com.cbcode.car_app_v2.User_Packages.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegisterDto userRegisterDto);


    /*UserDto getUserById(Integer id);
    UserDto getFirstName(String firstName);
    UserDto getUserByEmail(String email);
    List<UserDto> getAllUsers();
    UserDto createNewUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);
    String deleteUser(Integer id);*/
}
