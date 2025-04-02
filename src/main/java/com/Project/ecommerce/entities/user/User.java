package com.Project.ecommerce.entities.user;

import com.Project.ecommerce.entities.address.Address;
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
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ID;

    @Email
    private String email;

    @NotNull(message = "First name cannot be null")
    @NotBlank(message = "First name cannot be blank")
    @Size(min = 3, max = 15, message = "First name must be between 3 and 15 characters")
    private String firstName;

    @Size(max = 15, message = "Middle name must not exceed 15 characters")
    private String middleName;

    @NotNull(message = "Last name cannot be null")
    @NotBlank(message = "Last name cannot be blank")
    @Size(min = 3, max = 15, message = "First name must be between 3 and 15 characters")
    private String lastName;

    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,15}$",
            message = "Password must contain at least one lowercase letter, one uppercase letter, one number, and one special character")
    private String password;


    private Boolean isDeleted = false;
    private Boolean isActive = false;
    private Boolean isExpired = false;
    private Boolean isLocked = false;
    private int invalidAttemptCount = 0;
    private Date passwordUpdateDate = new Date();

    @ManyToOne
    private Role role;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Address> addresses;
}
