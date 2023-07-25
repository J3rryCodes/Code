package com.example.demo.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class UserContact {
    @Id
    private UUID id;
    @NotNull(message = "Name cannot be null")
    private String Name;
    private String address;
    @NotNull(message = "Phone Number cannot be null")
    @Column(unique = true)
    private String phoneNumber;
    @Email
    private String email;
}
