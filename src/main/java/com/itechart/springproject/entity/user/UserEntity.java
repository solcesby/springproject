package com.itechart.springproject.entity.user;

import com.itechart.springproject.entity.email.EmailEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static javax.persistence.CascadeType.ALL;

@Data
@Entity
@Builder
@Table(name = "`users`")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne(mappedBy = "user", cascade = ALL)
    private UserRoleEntity role;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Transient
    private Set<String> recipients;

    @Builder.Default
    @OneToMany(mappedBy = "sender", orphanRemoval = true)
    private Set<EmailEntity> recipientEmails = new HashSet<>();
}
