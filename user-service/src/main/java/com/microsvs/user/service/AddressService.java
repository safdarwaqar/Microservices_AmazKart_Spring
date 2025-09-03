package com.microsvs.user.service;

import com.microsvs.user.dto.AddressRequestDTO;
import com.microsvs.user.dto.AddressResponseDTO;

import java.util.List;

public interface AddressService {

	// ========== CRUD Operations ==========
	AddressResponseDTO createAddress(String userId, AddressRequestDTO dto);

	AddressResponseDTO updateAddress(Integer addressId, AddressRequestDTO dto);

	void deleteAddress(Integer addressId);

	AddressResponseDTO getAddressById(Integer addressId);

	List<AddressResponseDTO> getAllAddressesByUser(String userId);

	// ========== Extra Helpers ==========
	List<AddressResponseDTO> getAllAddresses();

	AddressResponseDTO setDefaultAddress(String userId, Integer addressId);
}
