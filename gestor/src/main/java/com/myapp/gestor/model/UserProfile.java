package com.myapp.gestor.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table (name = "user_profiles")
public class UserProfile {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne (mappedBy = "profile")
    private User user;

    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.REMOVE)
    private List<Items> items;

    private Integer streaks = 0;

    @NotBlank(message = "The currency must be selected")
    private String currency;
}
