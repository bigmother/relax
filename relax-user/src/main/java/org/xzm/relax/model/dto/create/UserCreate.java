package org.xzm.relax.model.dto.create;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class UserCreate {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Pattern(regexp = "\\w+@\\w+\\.com")
    private String email;

    @Pattern(regexp = "\\d{11}")
    private String phone;

    private String avatar;

    private String nickname;
}
