package com.microsvs.user.service;

import java.util.List;

import com.microsvs.user.dto.CredentialRequestDTO;
import com.microsvs.user.dto.UserRequestDTO;
import com.microsvs.user.dto.UserResponseDTO;

public interface UserService {

    // ========== User Operations ==========
    UserResponseDTO registerUser(UserRequestDTO userRequestDTO);

    UserResponseDTO updateUser(String userId, UserRequestDTO userRequestDTO);

    void deleteUser(String userId);

    UserResponseDTO getUserById(String userId);

    List<UserResponseDTO> getAllUsers();
    
    UserResponseDTO updateCredentialByUserId(String userId, CredentialRequestDTO credentialRequestDTO);

   
}
