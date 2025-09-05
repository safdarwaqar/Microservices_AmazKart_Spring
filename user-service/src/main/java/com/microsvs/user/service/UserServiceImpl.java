package com.microsvs.user.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microsvs.user.dto.AddressResponseDTO;
import com.microsvs.user.dto.CredentialRequestDTO;
import com.microsvs.user.dto.UserRequestDTO;
import com.microsvs.user.dto.UserResponseDTO;
import com.microsvs.user.entity.Address;
import com.microsvs.user.entity.Credential;
import com.microsvs.user.entity.User;
import com.microsvs.user.excepetion.UserAlreadyExists;
import com.microsvs.user.excepetion.UserNotFound;
import com.microsvs.user.repository.UserReposotiry;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserReposotiry userRepository;

	@Autowired
	private ModelMapper modelMapper;

//	@Autowired
//	private CredentialRepository credentialRepository;

	@Override
	public UserResponseDTO registerUser(UserRequestDTO userRequestDTO) {

		if (userRepository.existsByEmail(userRequestDTO.getEmail())) {
			throw new UserAlreadyExists("Email " + userRequestDTO.getEmail() + " already exists");
		}

		if (userRepository.existsByPhone(userRequestDTO.getPhone())) {
			throw new UserAlreadyExists("Phone " + userRequestDTO.getPhone() + " already exists");
		}

		User user = modelMapper.map(userRequestDTO, User.class);
		if (userRequestDTO.getAddresses() != null) {
			Set<Address> addressMappedToUser = userRequestDTO.getAddresses().stream()
					.map(a -> modelMapper.map(a, Address.class)).peek(address -> address.setUser(user))
					.collect(Collectors.toSet());
			user.setAddress(addressMappedToUser);
		}

		Credential credential = modelMapper.map(userRequestDTO.getCredential(), Credential.class);
		credential.setUser(user);

		user.setCredential(credential);

		User savedUser = userRepository.save(user);
		UserResponseDTO userDto = modelMapper.map(savedUser, UserResponseDTO.class);
		if (savedUser.getAddress() != null) {
			Set<AddressResponseDTO> addressResponseDTO = savedUser.getAddress().stream()
					.map(m -> modelMapper.map(m, AddressResponseDTO.class)).collect(Collectors.toSet());

			userDto.setAddresses(addressResponseDTO);

		}

		return userDto;
	}

	@Override
	public UserResponseDTO updateUser(String userId, UserRequestDTO userRequestDTO) {
    
		User user = findUserIfExists(userId);

		user.setEmail(userRequestDTO.getEmail());
		user.setFirstName(userRequestDTO.getFirstName());
		user.setLastName(userRequestDTO.getLastName());
		user.setPhone(userRequestDTO.getPhone());

		User savedUser = userRepository.save(user);
		UserResponseDTO map = modelMapper.map(savedUser, UserResponseDTO.class);
    
    return map;
	}

	@Override
	public void deleteUser(String userId) {
		userRepository.delete(findUserIfExists(userId));
	}

	@Override
	public UserResponseDTO getUserById(String userId) {
		return modelMapper.map(findUserIfExists(userId), UserResponseDTO.class);
	}

	@Override
	public List<UserResponseDTO> getAllUsers() {
		return userRepository.findAll().stream().map(users -> modelMapper.map(users, UserResponseDTO.class)).toList();
	}

	@Override
	public UserResponseDTO updateCredentialByUserId(String userId, CredentialRequestDTO credentialRequestDTO) {
		// TODO Auto-generated method stub
		User user = findUserIfExists(userId);
		Credential map = modelMapper.map(credentialRequestDTO, Credential.class);
		map.setCreatedAt(user.getCredential().getCreatedAt());
		map.setUser(user);
		map.setCredentialId(user.getCredential().getCredentialId());
		user.setCredential(map);
		User save = userRepository.save(user);

		return modelMapper.map(save, UserResponseDTO.class);
	}

	private User findUserIfExists(String user_id) {
		return userRepository.findById(user_id)
				.orElseThrow(() -> new UserNotFound(String.format("user with user_id: %s does not exists", user_id)));
	}

}
