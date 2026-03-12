package com.myapp.gestor.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "email is required")
    @Column (unique = true)
    private String email;

    @NotBlank (message = "password is required")
    private String passwordHash;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "user")
    private UserProfile profile;


}
