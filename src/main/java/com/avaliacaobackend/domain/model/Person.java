package com.avaliacaobackend.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;

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

    @NotEmpty
    private String name;

    @NotEmpty
    private String gender;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthday;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_address", unique = true)
    private Address address;

    private String avatar;

    public String getAvatarUrl() {

        if (ObjectUtils.isEmpty(this.avatar)) {
            return null;
        }
        return "https://myawsbucketduds.s3.sa-east-1.amazonaws.com/" + this.avatar;
    }

}
