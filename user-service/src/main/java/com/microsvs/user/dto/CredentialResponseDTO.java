package com.microsvs.user.dto;

import com.microsvs.user.entity.RoleBasedAuthority;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CredentialResponseDTO {

	private Integer id;
	private String username;

	private String password; // usually you hash it in service

	private RoleBasedAuthority roleBasedAuthority;

	private Boolean isEnabled;
	private Boolean isAccountNonExpired;
	private Boolean isAccountNonLocked;
	private Boolean isCredentialsNonExpired;

}
