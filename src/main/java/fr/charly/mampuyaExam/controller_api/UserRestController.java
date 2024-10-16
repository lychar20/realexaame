package fr.charly.mampuyaExam.controller_api;

import fr.charly.mampuyaExam.entity.User;
import fr.charly.mampuyaExam.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserRestController {

    private UserService userService;

    @GetMapping("/me")
    public User show(Principal principal) {
        return userService.findByEmail(principal.getName());
    }


}
