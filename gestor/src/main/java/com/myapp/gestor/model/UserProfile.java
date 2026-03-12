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
@Entity
@Table (name = "user_profiles")
public class UserProfile {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    private Integer streaks = 0;

    @NotBlank(message = "The currency must be selected")
    private String currency;

    @OneToOne
    @JoinColumn (name = "user_id")
    private User user;

    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.REMOVE)
    private List<Items> items;
}
