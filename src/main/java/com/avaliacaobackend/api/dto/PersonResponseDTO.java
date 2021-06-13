package com.avaliacaobackend.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonResponseDTO {

    private Long id;
    private String name;
    private String email;
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
