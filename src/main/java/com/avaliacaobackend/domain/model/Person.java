package com.avaliacaobackend.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_persons")
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_person")
    private Long id;

    @NotEmpty(message = "{NotEmpty.name}")
    private String name;

    @NotEmpty(message = "{NotEmpty.gender}")
    private String gender;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthday;

    @JsonIgnore
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @JsonIgnore
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_address", unique = true)
    private Address address;

    private String avatar;

    public Person() { }

    public Person (String name, String gender, LocalDate birthday, LocalDateTime createdAt, Address address) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.createdAt = createdAt;
        this.address = address;
    }

    public String getAvatarUrl() {

        if (ObjectUtils.isEmpty(this.avatar)) {
            return null;
        }
        return "https://myawsbucketduds.s3.sa-east-1.amazonaws.com/" + this.avatar;
    }

    @PreUpdate
    private void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    @PrePersist
    private void prePersist() { this.createdAt = LocalDateTime.now(); }

}
