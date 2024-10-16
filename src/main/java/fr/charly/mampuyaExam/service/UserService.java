package fr.charly.mampuyaExam.service;


import fr.charly.mampuyaExam.DTO.UserDTO;
import fr.charly.mampuyaExam.entity.User;
import fr.charly.mampuyaExam.repository.UserRepository;
import fr.charly.mampuyaExam.service.interfaces.ServiceListInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements ServiceListInterface<User, String, UserDTO, UserDTO>, UserDetailsService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    public User show(Principal principal) {
        return findOneById(principal.getName());
    }


    @Override
    public User create(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        user.setBirthedAt(userDTO.getBirthedAt());
        user.setAvatar(userDTO.getAvatar());
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        user.setLevel(1);
        user.setCreatedAt(LocalDateTime.now());
        user.setRoles("[\"ROLE_USER\"]");
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User findOneById(String email) {
        return userRepository.findById(email).orElseThrow(EntityNotFoundException::new);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(EntityNotFoundException::new);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Les cochons sont dans la baie"));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.getAuthorities()
        );


}



}