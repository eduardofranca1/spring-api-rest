package com.avaliacaobackend.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;

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
    private Long id;

    private String userName;

    @Column(unique = true)
    private String email;

    private String password;

    private boolean deleted;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_person", unique = true)
    private Person person;

    public User() { }

    public User(String userName, String email, String password, Person person) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.person = person;
    }

    @PrePersist
    private void created() {
        this.password = new BCryptPasswordEncoder()
                .encode(password);
    }

}
