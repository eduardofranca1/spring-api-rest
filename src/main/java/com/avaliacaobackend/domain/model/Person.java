package com.avaliacaobackend.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

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

    @NotEmpty
    private String birthday;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_address", unique = true)
    private Address address;

//     IMPORTANTE: testar com unidirecional
//
//     @OneToOne()
//     IMPORTANTE: private User user;

//    private String email;
//    private String password;
//    private LocalDateTime registerDate;

    private String avatar;

    public String getAvatarUrl() {

        if (ObjectUtils.isEmpty(this.avatar)) {
            return null;
        }
        return "https://myawsbucketduds.s3.sa-east-1.amazonaws.com/" + this.avatar;
    }

}
