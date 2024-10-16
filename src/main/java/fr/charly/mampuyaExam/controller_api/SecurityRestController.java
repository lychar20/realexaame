package fr.charly.mampuyaExam.controller_api;

import com.fasterxml.jackson.annotation.JsonView;
import fr.charly.mampuyaExam.DTO.UserDTO;
import fr.charly.mampuyaExam.DTO.UserLoginDTO;
import fr.charly.mampuyaExam.entity.User;
import fr.charly.mampuyaExam.json_views.JsonViews;
import fr.charly.mampuyaExam.response.JwtResponse;
import fr.charly.mampuyaExam.security.JwtAuthenticatorService;
import fr.charly.mampuyaExam.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SecurityRestController {

    private final UserService userService;
    private final JwtAuthenticatorService jwtAuthenticatorService;

    @PostMapping("/api/register")
    @JsonView(JsonViews.UserShow.class)
    public User register(@RequestBody UserDTO userDTO) {
        return userService.create(userDTO);
    }

    @PostMapping("/api/login")
    public ResponseEntity<JwtResponse> login(@RequestBody UserLoginDTO userLoginDTO) {
        return jwtAuthenticatorService.authenticate(userLoginDTO);
    }

}
