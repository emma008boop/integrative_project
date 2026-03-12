package com.myapp.gestor.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table (name = "items")
public class Items {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Item's description is required")
    private String description;

    @NotBlank(message = "This item needs to have a price")
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private ItemState state;

    @URL(message = "Please provide an url")
    @Column(length = 1024)
    private String productUrl;

    @Column(columnDefinition = "TINYINT")
    private Integer needLevel;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_profile_id", referencedColumnName = "id")
    private UserProfile userProfile;

}
