/* (C)2023 */
package com.example.demo.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserContact {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "Name cannot be null")
    private String name;

    private String address;

    @NotNull(message = "Phone Number cannot be null")
    @Column(unique = true)
    private String phoneNumber;

    @Email private String email;
}
