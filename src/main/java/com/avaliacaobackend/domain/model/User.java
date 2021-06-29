package com.avaliacaobackend.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_user")
    private Long id;

    @EqualsAndHashCode.Include
    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String password;

    private boolean deleted;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_person", unique = true)
    private Person person;

    public User() { }

    public User(String username, String email, String password, LocalDateTime createdAt, Person person) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.person = person;
    }

    @PreUpdate
    private void preUpdate() { this.updatedAt = LocalDateTime.now(); }

    @PrePersist
    private void created() {
        this.password = new BCryptPasswordEncoder().encode(password);
        this.createdAt = LocalDateTime.now();
    }

}
