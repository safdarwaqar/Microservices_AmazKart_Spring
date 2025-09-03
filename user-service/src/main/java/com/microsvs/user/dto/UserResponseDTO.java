package com.microsvs.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    private Set<AddressResponseDTO> addresses;

    private CredentialResponseDTO credential;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
