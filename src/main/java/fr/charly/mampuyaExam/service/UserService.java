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

    public User create(UserDTO dto, Principal principal) {
        User user = create(dto);
        return userRepository.saveAndFlush(user);
    }


    @Override
    public User create(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        user.setBirthedAt(userDTO.getBirthedAt());
        user.setAvatar(userDTO.getAvatar());
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));

        return userRepository.saveAndFlush(user);
    }

    @Override
    public User findOneById(String id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("Les cochons sont dans la baie"));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.getAuthorities()
        );


}



}