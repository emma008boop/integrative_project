package com.myapp.gestor.model;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@NoArgsConstructor
@Table (name = "user")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "email is required")
    @Column (unique = true)
    private String email;

    @NotBlank (message = "password is required")
    private String passwordHash;
}
