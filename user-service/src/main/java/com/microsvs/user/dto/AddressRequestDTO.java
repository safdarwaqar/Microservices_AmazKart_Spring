package com.microsvs.user.dto;

import com.microsvs.user.entity.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressRequestDTO {

    private String street;
    private String landmark;
    private String city;
    private String state;
    private String postalCode;
    private String country;

    private String addressType; // HOME, WORK, BILLING, SHIPPING
    private boolean isDefault;

    private Double latitude;
    private Double longitude;

    private User user;
}
