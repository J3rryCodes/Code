/* (C)2023 */
package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserContactRequest {
    @NotBlank(message = "Name cannot be null")
    private String name;

    private String address;

    @NotBlank(message = "Phone Number cannot be null")
    private String phoneNumber;

    @Email private String email;
}
