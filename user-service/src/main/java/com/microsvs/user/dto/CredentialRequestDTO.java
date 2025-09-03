package com.microsvs.user.dto;

import com.microsvs.user.entity.RoleBasedAuthority;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CredentialRequestDTO {

	@NotBlank
	private String username;

	@NotBlank
	private String password; // usually you hash it in service

	@NotNull
	private RoleBasedAuthority roleBasedAuthority;

	private Boolean isEnabled;
	private Boolean isAccountNonExpired;
	private Boolean isAccountNonLocked;
	private Boolean isCredentialsNonExpired;

	private UserRequestDTO user; // instead of whole User object
}
