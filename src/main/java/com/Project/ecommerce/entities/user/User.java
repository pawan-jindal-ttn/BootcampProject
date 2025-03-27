package com.Project.ecommerce.entities.user;

import com.Project.ecommerce.entities.address.Address;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ID;

    @Email
    private String email;

    @NotBlank
    @Size(min = 3, message = "Enter at least 3 characters")
    private String firstName;

    @Nullable
    private String middleName;

    @NotBlank
    @Size(min = 3, message = "Enter at least 3 characters")
    private String lastName;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    private String password;


    private boolean isDeleted;
    private boolean isActive;
    private boolean isExpired;
    private boolean isLocked;
    private int invalidAttemptCount;
    private Date passwordUpdateDate;

    @ManyToMany
    private List<Role> roles;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Address> addresses;
}
