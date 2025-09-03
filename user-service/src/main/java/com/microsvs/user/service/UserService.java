package com.microsvs.user.service;

import com.microsvs.user.dto.UserRequestDTO;
import com.microsvs.user.dto.UserResponseDTO;
import java.util.List;

public interface UserService {

    // ========== User Operations ==========
    UserResponseDTO registerUser(UserRequestDTO userRequestDTO);

    UserResponseDTO updateUser(String userId, UserRequestDTO userRequestDTO);

    void deleteUser(String userId);

    UserResponseDTO getUserById(String userId);

    List<UserResponseDTO> getAllUsers();

   
}
