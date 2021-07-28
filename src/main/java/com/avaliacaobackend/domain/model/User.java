package com.avaliacaobackend.domain.model;

import com.avaliacaobackend.domain.utils.StringUtils;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
@Table(name = "tb_users")
public class User implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "cod_user")
    private String id;

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
        this.id = StringUtils.uuid();
        this.createdAt = LocalDateTime.now();
        this.password = new BCryptPasswordEncoder().encode(password);
    }

}
