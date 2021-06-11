package com.avaliacaobackend.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String gender;
    private LocalDate birthday;
    private AddressDTO address;
    private String avatar;

    public String getAvatarUrl() {

        if (ObjectUtils.isEmpty(this.avatar)) {
            return null;
        }
        return "https://myawsbucketduds.s3.sa-east-1.amazonaws.com/" + this.avatar;
    }

}