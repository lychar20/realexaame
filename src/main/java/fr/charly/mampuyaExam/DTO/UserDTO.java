package fr.charly.mampuyaExam.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String username;


    private LocalDate birthedAt;


    private String avatar;

    @NotBlank
    private String password;


    @NotBlank
    private String confirmedPassword;



}
