package com.avaliacaobackend.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_address")
public class Address implements Serializable {
    public static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_address")
    private Long id;

    @NotEmpty(message = "{address.notempty}")
    private String address;

    @NotEmpty(message = "{city.notempty}")
    private String city;

    @NotEmpty(message = "{state.notempty}")
    private String state;

    @Column(name = "postal_code")
    @NotEmpty(message = "{postalCode.notempty}")
    private String postalCode;

    @NotEmpty(message = "{country.notempty}")
    private String country;

    @JsonIgnore
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @JsonIgnore
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PreUpdate
    private void preUpdate() { this.updatedAt = LocalDateTime.now(); }

    @PrePersist
    private void prePersist() { this.createdAt = LocalDateTime.now(); }

}
