package com.Project.ecommerce.entities.user;

import com.Project.ecommerce.entities.address.Address;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
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

    @NotBlank
    @Size(min = 3, message = "Enter at least 3 characters")
    private String firstName;

    @Nullable
    private String middleName;

    @NotBlank
    @Size(min = 3, message = "Enter at least 3 characters")
    private String lastName;

    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,15}$",
            message = "Password must contain at least one lowercase letter, one uppercase letter, one number, and one special character")
    private String password;


    private Boolean isDeleted = false;
    private Boolean isActive = true;
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
